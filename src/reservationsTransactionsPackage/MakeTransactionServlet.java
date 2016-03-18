package reservationsTransactionsPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidParameterException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelObject.CreditCard;
import modelObject.Hotel;
import modelObject.Reservation;
import modelObject.Room;
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
 * Servlet implementation class MakeTransactionServlet
 */
@WebServlet(name = "/MakeTransactionServlet", urlPatterns = { "/MakeTransactionServlet" })
public class MakeTransactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(MakeTransactionServlet.class.getName());
       
    public MakeTransactionServlet() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
			this.handleRequest(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
			this.handleRequest(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		Reservation reservation = null;
		
		IHotelServiceLayer hotelService = null;
		Hotel hotel = null;
		Room room = null;
		
		CreditCard customercc = null;
		CreditCard clientcc = null;
		String customerccid = null;
		String clientccid = null;
		int ccid = 0;
		int ocid = 0;
		
		try
		{
			logger.info("make transaction and confirm reservation");
			customerccid = request.getParameter("customercreditcard");
			clientccid = request.getParameter("ownercreditcard");
			
			if(null == customerccid || null == clientccid)
			{
				throw new InvalidParameterException("Atleast one of the input is null");
			}
			ccid = Integer.valueOf(customerccid);
			ocid = Integer.valueOf(clientccid);
			
			logger.info("Get session objects");
			session = request.getSession();
			transaction = (Transaction)session.getAttribute(globals.session_clientResTrans);
			reservation = (Reservation)session.getAttribute(globals.session_clientres);
			
			logger.info("get credit card for user and owner");
			userService = new UserService();
			customercc = userService.getCreditCardForUser(transaction.getCustomerUserId(), ccid);
			clientcc = userService.getCreditCardForUser(transaction.getOwnerUserId(), ocid);
			
			logger.info("set transaction params");
			transactionService = new TransactionService();
			transaction.setCustomerCreditCardId(ccid);
			transaction.setOwnerCreditCardId(ocid);
			transaction.setTransactionStatus(globals.transaction_reservationTrue);
			
			logger.info("make payment for user");
			paymentService = new PaymentService();
			if(false == paymentService.makePayment(transaction.getCustomerUserId(), transaction.getCustomerCreditCardId(),
					transaction.getOwnerUserId(), transaction.getOwnerCreditCardId(), transaction.getAmount()))
			{
				throw new Exception ("Payment not successful. cancelling transaction");
			}
			
			logger.info("Make transaction");
			transactionService.addTransaction(transaction);
			
			logger.info("add reservatition");
			room = (Room)session.getAttribute(globals.session_clientResRoom);
			reservationService = new ReservationService();
			reservation.setTransactionId(transaction.getId());
			reservation.setReservationNumber(String.valueOf(transaction.getId()));
			reservation.setRoomTypeId(room.getRoomTypeId());
			reservationService.addReservation(reservation);
			
			logger.info("Update available room");
			hotelService = new HotelService();
			hotel = hotelService.getHotelById(reservation.getHotelId());
			int available = room.getAvailableNumber();
			room.setAvailableNumber(available - reservation.getNumberOfRooms());
			hotelService.updateRoomForHotel(hotel, room);
			
			logger.info("Update session objects for transaction conf page");
			session.setAttribute(globals.session_clientResTrans, transaction);
			session.setAttribute(globals.session_clientres, reservation);
			session.setAttribute(globals.session_clientResRoom, room);
			session.setAttribute(globals.session_clientResCustCC, customercc);
			
			logger.info("redirect to transaction success");
			response.sendRedirect("ClientReservationTransactionConfirmation.jsp");
		}
		catch(Exception ex)
		{
			logger.fatal("unable to make transaction:");
			response.sendRedirect("ClientReservationTransactionFailed.jsp");
		}
	}
}
