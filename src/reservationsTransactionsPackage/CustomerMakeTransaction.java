package reservationsTransactionsPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidParameterException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelObject.CreditCard;
import modelObject.CustomerHotelSearchBean;
import modelObject.CustomerReservationListBean;
import modelObject.Hotel;
import modelObject.Reservation;
import modelObject.ReservationsBean;
import modelObject.Room;
import modelObject.ShoppingCartBean;
import modelObject.Transaction;

import org.apache.log4j.Logger;

import utils.globals;
import ModelServiceLayer.HotelService;
import ModelServiceLayer.IHotelServiceLayer;
import ModelServiceLayer.IUserService;
import ModelServiceLayer.PaymentService;
import ModelServiceLayer.ReservationService;
import ModelServiceLayer.TransactionService;
import ModelServiceLayer.UserService;

/**
 * Servlet implementation class CustomerMakeTransaction
 */
@WebServlet(name = "/CustomerMakeTransaction", urlPatterns = { "/CustomerMakeTransaction" })
public class CustomerMakeTransaction extends HttpServlet {
	private static final long serialVersionUID = 1L;       
	static Logger logger = Logger.getLogger(CustomerMakeTransaction.class.getName());
    
    public CustomerMakeTransaction() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{
			this.handleRequest(request, response);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{
			this.handleRequest(request, response);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new ServletException(e.getMessage());
		}
	}

	protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
		PrintWriter out = response.getWriter();
		HttpSession session = null;
		IUserService userService = null;
		TransactionService transactionService = null;
		ReservationService reservationService = null;
		PaymentService paymentService = null;
		
		Transaction transaction = null;
		
		IHotelServiceLayer hotelService = null;
		Hotel hotel = null;
		Room room = null;
		
		CreditCard customercc = null;
		CreditCard clientcc = null;
		String customerccid = null;
		String clientccid = null;
		int ccid = 0;
		int ocid = 0;
		
		CustomerReservationListBean rbean = null; 
		ArrayList<Reservation> reservationList = null;
		
		try
		{
			logger.info("make transaction and confirm reservation");
			logger.info("Get session objects");
			session = request.getSession();
			
			customerccid = request.getParameter("customercreditcard");
			if(null == customerccid)
			{
				throw new InvalidParameterException("Atleast one of the input is null");
			}
			
			ccid = Integer.valueOf(customerccid);
			
			logger.info("get reservation bean");
			rbean = (CustomerReservationListBean)session.getAttribute(globals.session_customerReservationBean);
			
			transaction = rbean.getTransaction();
			reservationList = rbean.getReservation();
			
			logger.info("get credit card for user and owner");
			userService = new UserService();
			customercc = userService.getCreditCardForUser(transaction.getCustomerUserId(), ccid);
			clientcc = userService.getCreditCardForUser(transaction.getOwnerUserId(), ocid);
			
			logger.info("set transaction params");
			transactionService = new TransactionService();
			transaction.setCustomerCreditCardId(ccid);
			transaction.setTransactionStatus(globals.transaction_reservationTrue);
			
			// comment this part of the code for bank transaction 
			logger.info("make payment for user");
			paymentService = new PaymentService();
			if(false == paymentService.makePayment(transaction.getCustomerUserId(), transaction.getCustomerCreditCardId(),
					transaction.getOwnerUserId(), transaction.getOwnerCreditCardId(), transaction.getAmount()))
			{
				throw new Exception ("Payment not successful. cancelling transaction");
			}
			// end of comment this part of code for bank transaction
			
			logger.info("add transaction");
			transactionService.addTransaction(transaction);
			
			logger.info("foreach reservation in the shopping cart, add reservation : " + reservationList.size());
			for (Reservation reservation : reservationList)
			{
				logger.info("add reservatition");
				reservationService = new ReservationService();
				reservation.setTransactionId(transaction.getId());
				reservation.setReservationNumber(String.valueOf(transaction.getId()));
				reservationService.addReservation(reservation);
				
				logger.info("Update available room");
				hotelService = new HotelService();
				hotel = hotelService.getHotelById(reservation.getHotelId());
				room = hotelService.getHotelRoomOfRoomType(hotel, reservation.getRoomTypeId());
				
				int available = room.getAvailableNumber();
				room.setAvailableNumber(available - reservation.getNumberOfRooms());
				hotelService.updateRoomForHotel(hotel, room);
			}
			
			logger.info("empty shopping cart");
			ShoppingCartBean scb = (ShoppingCartBean)session.getAttribute(globals.session_shoppingcart);
			scb.reset();
				
			logger.info("Update session objects for transaction conf page");
			rbean.setTransaction(transaction);
			rbean.setReservation(reservationList);
			session.setAttribute(globals.session_customerReservationBean, rbean);
			session.setAttribute(globals.session_customerResCustCC, customercc);

			logger.info("redirect to transaction success");
			response.sendRedirect("ReservationTransactionConfirmation.jsp");
		}
		catch(Exception ex)
		{
			logger.fatal("unable to make transaction:");
			response.sendRedirect("CustomerReservationTransactionConfirmationFailed.jsp");
		}

	}
}
