package reservationsTransactionsPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelObject.Hotel;
import modelObject.Reservation;
import modelObject.ReservationsBean;
import modelObject.Transaction;
import modelObject.User;

import org.apache.log4j.Logger;

import utils.globals;

import ModelServiceLayer.HotelService;
import ModelServiceLayer.IHotelServiceLayer;
import ModelServiceLayer.IReservationService;
import ModelServiceLayer.IUserService;
import ModelServiceLayer.ReservationService;
import ModelServiceLayer.TransactionService;
import ModelServiceLayer.UserService;

/**
 * Servlet implementation class ManageReservationsCustomer
 */
@WebServlet(name = "/ManageReservationsCustomer", urlPatterns = { "/ManageReservationsCustomer" })
public class ManageReservationsCustomer extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(ManageReservationsCustomer.class.getName());
	   

	public ManageReservationsCustomer() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.handleRequest(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		ArrayList<ReservationsBean> rbeanlist = null;
		ReservationsBean rbean = null;

		HttpSession session = null;
		TransactionService transactionService = null;
		
		ReservationService reservationService = null;
		ArrayList<Reservation> masterResList = null;
		
		IHotelServiceLayer hotelService = null;
		
		IUserService userService = null;
		User user = null;
		
		String username = null;
		int userid = -1;
		
		try
		{
			logger.info("mange reservations customer servlet");
			session = request.getSession();
			username = (String)session.getAttribute(globals.session_username);
			userid = (int)session.getAttribute(globals.session_userid);
			
			if(username == null)
			{
				throw new IllegalStateException("User is not logged in");
			}
			
			logger.info("Get all reservations for customer");
			reservationService = new ReservationService();
			masterResList = reservationService.getReservationForUser(userid);
			
			if(null == masterResList)
			{
				masterResList = new ArrayList<Reservation>();
			}
			
			logger.info("for the list of reservations, get transaction");
			logger.info("foreach reservation get details and add to bean");
			userService = new UserService();
			hotelService = new HotelService();
			HashMap<Integer, String[]> roomTypes = hotelService.getAllRoomTypes();
			
			for(Integer i : roomTypes.keySet())
			{
				String[] values = roomTypes.get(i);
				logger.info("name" + values[0]);
				logger.info("desc" + values[1]);
			}
			
			rbeanlist = new ArrayList<ReservationsBean>();
			transactionService = new TransactionService();
			for(Reservation r : masterResList)
			{
				rbean = new ReservationsBean();
				String hotelName = hotelService.getHotelById(r.getHotelId()).getName();
				
				user = userService.getUserById(r.getUserId());
				rbean.setUser(user);
				
				rbean.setHotelName(hotelName);
				
				if(r.getRoomTypeId() != -1)
				{
					String[] rooms = roomTypes.get(r.getRoomTypeId());
					rbean.setRoomType(rooms[0]);
				}
				
				rbean.setReservation(r);
				logger.info(r.getTransactionId());
				
				Transaction tr = transactionService.getTransactionById(r.getTransactionId());
				rbean.setTransaction(tr);
				
				rbeanlist.add(rbean);
			}
			
			
			logger.info("attach reservation list to session");
			session.setAttribute(globals.session_customerReservationsList, rbeanlist);
			
			logger.info("redirect");
			response.sendRedirect("ManageReservations.jsp");
				
		}
		catch(IllegalStateException ex)
		{
			logger.fatal(ex.getMessage());
			response.sendRedirect("Login.jsp");
		}
		catch(Exception ex)
		{
			logger.fatal("Unable to get reservation list");
			throw ex;
		}
	    finally 
	    {}
		
		return;
	}
}
