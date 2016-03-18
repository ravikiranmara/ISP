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
import ModelServiceLayer.IUserService;
import ModelServiceLayer.ReservationService;
import ModelServiceLayer.TransactionService;
import ModelServiceLayer.UserService;

/**
 * Servlet implementation class ClientCurrentReservation
 */

@WebServlet(name = "/ClientCurrentReservation", urlPatterns = { "/ClientCurrentReservation" })
public class ClientCurrentReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(ClientCurrentReservation.class.getName());
	
       
    public ClientCurrentReservation() {
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
		ArrayList<Hotel> hotelList = null;
		int ownerId;
		
		User user = null; 
		IUserService userService = null;
		
		try
		{
			logger.info("get current reservations for client");
			session = request.getSession();
			ownerId = (Integer)session.getAttribute(globals.session_userid);
			
			logger.info("Get hotel list");
			hotelService = new HotelService();
			hotelList = hotelService.getHotelForOwnerId(ownerId);
			
			if(null == hotelList)
			{
				hotelList = new ArrayList<Hotel>();
			}
		
			logger.info("For each hotel, get reservations");
			masterResList = new ArrayList<Reservation>();
			ArrayList<Reservation> tempResList = null;
			reservationService = new ReservationService();
			for(Hotel h : hotelList)
			{
				tempResList = reservationService.getReservationForHotel(h.getId());
				if(null != tempResList)
				{
					masterResList.addAll(tempResList);
				}
			}
			
			logger.info("foreach reservation get details and add to bean");
			userService = new UserService();
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
				
				logger.info("where");
				if(r.getRoomTypeId() != -1)
				{
					String[] rooms = roomTypes.get(r.getRoomTypeId());
					rbean.setRoomType(rooms[0]);
					logger.info("here");
				}
				else
				{
					rbean.setRoomType("Unknown");
				}
				
				rbean.setReservation(r);
				logger.info(r.getTransactionId());
				
				Transaction tr = transactionService.getTransactionById(r.getTransactionId());
				rbean.setTransaction(tr);
				logger.info("here here");
				
				rbeanlist.add(rbean);
			}
			
			logger.info("Put the reservation list in session");
			session.setAttribute(globals.session_clientCurrResList, rbeanlist);
			
			logger.info("redirect to results page");
			response.sendRedirect("ViewCurrentReservations.jsp");
			
			/*ArrayList<ReservationsBean> rlist = (ArrayList<ReservationsBean>)session.getAttribute(globals.session_clientCurrResList);
			for(ReservationsBean rb : rlist)
			{
				out.println(rb.getHotelName());
				out.println(rb.getRoomType());
				out.println(rb.getReservation().getId());
				out.println(rb.getTransaction().getId());
			}
			*/
		}
		catch (Exception ex)
		{
			logger.info("unable to get client hotel reservations : " + ex.getMessage());
			throw ex;
		}
		finally
		{			
		}
		
		return;
	}

}
