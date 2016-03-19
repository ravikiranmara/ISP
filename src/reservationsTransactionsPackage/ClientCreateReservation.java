package reservationsTransactionsPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidParameterException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelObject.Hotel;
import modelObject.Reservation;
import modelObject.Room;
import modelObject.Transaction;
import modelObject.User;

import org.apache.log4j.Logger;

import utils.globals;

import ModelServiceLayer.HotelService;
import ModelServiceLayer.IHotelServiceLayer;
import ModelServiceLayer.IUserService;
import ModelServiceLayer.UserService;

/**
 * Servlet implementation class ClientCreateReservation
 */

@WebServlet(name = "/ClientCreateReservation", urlPatterns = { "/ClientCreateReservation" })
public class ClientCreateReservation extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(ClientCreateReservation.class.getName());
	
    public ClientCreateReservation() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		ArrayList<Room> roomlist = null;
		int rid = 0; 
		float price = 0;
		String roomname = null;
		int available = 0;
		Date checkinUser = null, checkoutUser = null;
		Date checkinAvailable = null, checkoutAvailable = null;
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		Reservation res = null;
		int userNumRooms = 0;
		int numrooms = 0;
		int roomtypeid = 0;
		IUserService userService = null;
		IHotelServiceLayer hotelService = null;
		User user = null;
		int ownerId = 0;
		HttpSession session = null;
		Transaction transaction = null;
		PrintWriter out = response.getWriter();
		Hotel hotel = null;
		int roomid = 0;
		Room room = null;
		
		
		String HotelId = request.getParameter("HotelName");
		String NumRooms = request.getParameter("rooms");
		String Checkin = request.getParameter("checkIn");
		String Checkout = request.getParameter("checkOut");
		String Roomtype = request.getParameter("roomType");
		String Username	=	request.getParameter("username");
		
		try
		{
			logger.info("create reservation");
			if(null == HotelId || null == NumRooms || null == Checkin || 
					null == Checkout || null == Roomtype || null == Username)
			{
				throw new Exception("some of the parameter is null");
			}
			
			logger.info("Get session");
			session = request.getSession();
			
			logger.info("Get rooomtype");
			rid = Integer.valueOf(Roomtype);
			if(rid == 1)
			{
				roomname = "standard";
			}
			else if(2 == rid)
			{
				roomname = "family";
			}
			else
			{
				roomname = "suite";
			}
			
			logger.info("get hotel id");
			int Hid = Integer.parseInt(HotelId);
			
			logger.info("get hotel from db");
			hotelService = new HotelService();
			hotel = hotelService.getHotelById(Hid);
			
			logger.info("get room");
			roomlist = hotel.getRoom();
			for(Room r : roomlist)
			{
				if(r.getRoomType().equalsIgnoreCase(roomname))
				{
					logger.info("Found room");
					available = r.getAvailableNumber();
					checkinAvailable = r.getStartDate();
					checkoutAvailable = r.getEndDate();
					price = r.getPricePerNight();
					numrooms = r.getAvailableNumber();
					roomtypeid = r.getRoomTypeId();
					roomid = r.getId();
					room = r;
					
					logger.info(available + ":" + checkinAvailable +":"+ checkoutAvailable);
				}
			}
			
			logger.info("check checkin and checkout dates");
			java.util.Date date = sdf1.parse(Checkin);
			checkinUser = new java.sql.Date(date.getTime());
			
			date = sdf1.parse(Checkout);
			checkoutUser = new java.sql.Date(date.getTime());
		
			logger.info("Check availaable number of rooms");
			userNumRooms = Integer.valueOf(NumRooms);
			if(checkinAvailable.after(checkinUser) || checkoutAvailable.before(checkoutUser) || 
					numrooms < userNumRooms)
			{
				throw new InvalidParameterException("rooom not available");
			}
			
			logger.info("get customer");
			userService = new UserService();
			user = userService.getUserByUsername(Username);
			
			logger.info("get hotel owner");
			ownerId = hotel.getOwnerUserId();
			
			logger.info("create reservation object");
			res = new Reservation();
			res.setHotelId(hotel.getId());
			res.setNumberOfRooms(userNumRooms);
			res.setCheckInDate(checkinUser);
			res.setCheckOutDate(checkoutUser);
			res.setRoomTypeId(roomtypeid);
			res.setUserId(user.getUserId());
			session.setAttribute(globals.session_clientres, res);
			
			logger.info("Create transaction object");
			transaction = new Transaction();
			transaction.setOwnerUserId(ownerId);
			transaction.setCustomerUserId(user.getUserId());
			transaction.setAmount(price * userNumRooms);
			transaction.setCancelledReservation(globals.transaction_cancelFalse);
			transaction.setTransactionStatus(globals.transaction_reservationFalse);
			session.setAttribute(globals.session_clientResTrans, transaction);
			
			logger.info("goto transaction page");
			out.println(res.getHotelId() + ":" + res.getNumberOfRooms() + ":" + res.getUserId());
			out.println(transaction.getOwnerUserId() + ":" + transaction.getCustomerUserId() + ":" + transaction.getAmount());
			
			logger.info("add customer user object to session");
			user = userService.getUserById(transaction.getCustomerUserId());
			session.setAttribute(globals.session_clientResCust, user);
			
			logger.info("add client user object ot session");
			user = userService.getUserById(transaction.getOwnerUserId());
			session.setAttribute(globals.session_clientResCli, user);
			
			logger.info("add hotel name ot session");
			session.setAttribute(globals.session_clientResHotelname, hotel);
			
			logger.info("Add room type");
			session.setAttribute(globals.session_clientResRoomType, roomname);
			
			logger.info("add room id to session");
			session.setAttribute(globals.session_clientResRoom, room);
			
			response.sendRedirect("ClientReservationTransaction.jsp");
		}
		catch(InvalidParameterException ex)
		{
			logger.fatal(ex.getMessage());
			// redirect
		}
		catch (Exception ex)
		{
			response.sendRedirect("ClientGenericError.jsp?errstr=" + ex.getMessage());
			logger.fatal("unable to udate hotel object:" + ex.getMessage());
			throw ex;
		}
		finally
		{ }
		
		return;
		}
}
