package reservationsTransactionsPackage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelObject.CreditCard;
import modelObject.CustomerHotelSearchBean;
import modelObject.Reservation;
import modelObject.ReservationsBean;
import modelObject.Transaction;
import modelObject.User;

import org.apache.log4j.Logger;

import ModelServiceLayer.IHotelServiceLayer;
import ModelServiceLayer.IUserService;
import ModelServiceLayer.UserService;

import utils.globals;

/**
 * Servlet implementation class CustomerCreateHotelReservation
 */
@WebServlet(name = "/CustomerCreateHotelReservation", urlPatterns = { "/CustomerCreateHotelReservation" })
public class CustomerCreateHotelReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(CustomerCreateHotelReservation.class.getName());
	
    public CustomerCreateHotelReservation() {
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
		HttpSession session = request.getSession();
		ArrayList<CustomerHotelSearchBean> searchList = null;
		Reservation reservation = null;
		Transaction transaction = null;
		IUserService us = null;
		User user = null;
		ReservationsBean rb = null;
		CustomerHotelSearchBean selectbean = null;
		int hotelId = -1;
		String hotelIdStr = null;
		String roomsStr = null;
		int numrooms = -1;
		String username = null;
		
		try
		{
			logger.info("create a reservation for user");
			session = request.getSession();
			searchList = (ArrayList<CustomerHotelSearchBean>)session.getAttribute(globals.session_customerSearchHotelList);
			reservation = (Reservation)session.getAttribute(globals.session_customerReservationObject);
			username = (String)session.getAttribute(globals.session_username);
			
			hotelIdStr = request.getParameter("id");
			roomsStr = request.getParameter("rooms");
			
			if(null == hotelIdStr)
			{
				throw new Exception("Parameter id is null");
			}
			hotelId = Integer.valueOf(hotelIdStr);
			
			if(null == roomsStr)
			{
//				throw new Exception("rooms is null");
				roomsStr = "1";
			}
			numrooms = Integer.valueOf(roomsStr);
			
			logger.info("get selected hotel");
			for(CustomerHotelSearchBean c : searchList)
			{
				if(c.getHotel().getId() == hotelId)
				{
					selectbean = c;
				}
			}
			
			logger.info("get user details");
			us = new UserService();
			user = us.getUserByUsername(username);
			if(null == user)
			{
				throw new Exception("cannot find user");
			}
			
			User owner = us.getUserById(selectbean.getHotel().getOwnerUserId()); 
			
			logger.info("Update hotel details in reservation object");
			reservation.setHotelId(selectbean.getHotel().getId());
			reservation.setNumberOfRooms(numrooms);
			reservation.setReservationStatus(globals.reservation_cancelFalse);
			reservation.setNotes("");
			
			logger.info("Update transaction Object");
			transaction = new Transaction();
			transaction.setAmount(selectbean.getRoom().getPricePerNight() * numrooms);
			transaction.setCustomerUserId(user.getUserId());
			transaction.setOwnerUserId(owner.getUserId());
			transaction.setOwnerCreditCardId(owner.getCreditCard().get(0).getId());
			transaction.setCancelledReservation(globals.reservation_cancelFalse);
			transaction.setTransactionStatus(globals.transaction_reservationFalse);
			
			logger.info("fill up reservation bean");
			rb = new ReservationsBean();
			rb.setHotelName(selectbean.getHotel().getName());
			rb.setReservation(reservation);
			rb.setTransaction(transaction);
			rb.setRoomType(selectbean.getRoom().getRoomType());
			rb.setUser(user);
			
			logger.info("Throw the bean into session");
			session.setAttribute(globals.session_customerReservationBean, rb);
			System.out.println(rb.getHotelName());
			System.out.println(rb.getUser().getUsername());
			
			logger.info("throw select bean also into session");
			session.setAttribute(globals.session_customerSelectBean, selectbean);
			
			logger.info("also user object into session");
			session.setAttribute(globals.session_customerReserveTransUser, user);
			
			
			
			logger.info("redirect");
			response.sendRedirect("ReservationTransaction.jsp");
		}
		catch(Exception ex)
		{
			logger.fatal("unable to make reservation object" + ex.getMessage());
			throw ex;
		}
        finally
        {
        }
	}

}
