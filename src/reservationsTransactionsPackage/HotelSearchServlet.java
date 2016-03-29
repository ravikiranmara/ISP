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

import org.apache.log4j.Logger;

import utils.globals;

import loginPackage.Registration;
import modelObject.CreditCard;
import modelObject.CustomerHotelSearchBean;
import modelObject.Hotel;
import modelObject.Reservation;
import modelObject.SearchParameter;
import modelObject.User;
import ModelServiceLayer.HotelService;
import ModelServiceLayer.IAuthenticationService;
import ModelServiceLayer.IHotelServiceLayer;

@WebServlet(name = "/HotelSearchServlet", urlPatterns = { "/HotelSearchServlet" })
public class HotelSearchServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(HotelSearchServlet.class.getName());
    
       
    public HotelSearchServlet() 
    {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
			this.handleRequest(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute(globals.session_Exception, e);
			response.sendRedirect("CustomerGenericErrorPage.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try {
			this.handleRequest(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.getSession().setAttribute(globals.session_Exception, e);
			response.sendRedirect("CustomerGenericErrorPage.jsp");
		}
	}

	private boolean IsRequestParametersValid(HttpServletRequest request) throws InvalidParameterException, Exception
	{
		boolean status = false;
		
		try
		{
			// get all the params
			String hotelName = request.getParameter("hotelname");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String checkinDateString = request.getParameter("checkIn");
			String checkoutDateString = request.getParameter("checkOut");
			String numRoom = request.getParameter("numrooms");
			String roomType = request.getParameter("roomtype");
			
			logger.info("Check for null - " + hotelName + "|" + city + "|" + state + "|" + checkinDateString
					 + "|" + checkoutDateString + "|" + numRoom + "|" + roomType);
			
			if(hotelName == null || city == null || null == state || 
					checkinDateString == null || checkoutDateString == null || numRoom == null ||
					roomType == null)
			{
				throw new InvalidParameterException("Some parameter is missing in serach page");
			}
		}
		catch (InvalidParameterException ex)
		{
			logger.fatal(ex.getMessage());
			status = false;
			throw ex;
		}
		catch(Exception ex)
		{
			logger.fatal("unable to validate parameters");
			throw ex;
		}
		
		return status;
	}
	
	private SearchParameter loadSearchParameters(HttpServletRequest request) throws Exception
	{
		SearchParameter sp = new SearchParameter();
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
		String hotelName = request.getParameter("hotelname");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String checkinDateString = request.getParameter("checkIn");
		String checkoutDateString = request.getParameter("checkOut");
		String numRoom = request.getParameter("numrooms");
		String roomType = request.getParameter("roomtype");
		
		try
		{
			if(false == hotelName.isEmpty())
			{
				sp.setHotelname(hotelName);			
			}
			
			if(false == city.isEmpty())
			{
				sp.setCity(city);
			}
			
			if(false == state.isEmpty())
			{
				sp.setState(state);
			}
			
			logger.info("checkin checkout dates : " + checkinDateString + "|" + checkoutDateString);
			if(false == checkinDateString.isEmpty())
			{
				java.util.Date date = sdf1.parse(checkinDateString);
				java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
				sp.setCheckinDate(sqlStartDate);
			}
	
			if(false == checkoutDateString.isEmpty())
			{
				java.util.Date date = sdf1.parse(checkoutDateString);
				java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
				sp.setCheckoutDate(sqlStartDate);
			}
			
			logger.info("rrr date : " + sp.getCheckoutDate() + "|" + sp.getCheckinDate());

			logger.info("get numrooms");
			if(false == numRoom.isEmpty())
			{
				sp.setNumRooms(Integer.parseInt(numRoom));
			}
			
			logger.info("get roomtype");
			if(false == roomType.isEmpty())
			{
				//sp.setRoomType(roomType);
				int rt = Integer.valueOf(roomType);
				if(rt == 1)
					sp.setRoomType("standard");
				else if(rt == 2)
					sp.setRoomType("family");
				else 
					sp.setRoomType("suite");
			}
			
			logger.info("got search parameters");
		}
		catch (Exception ex)
		{
			logger.fatal("unable to get serarch parameters : " + ex.getMessage());
			throw ex;
		}
		
		return sp;
	}
	
	protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
        boolean status = true;
        PrintWriter out = response.getWriter();
        User user = null;
        ArrayList<Hotel> hlist = null;
        IHotelServiceLayer hs = null;
        SearchParameter sp = null;
        HttpSession session = null;
        Reservation reservation = null;
        
        try
        {
        	session = request.getSession();
	        logger.info("validate input");
	        this.IsRequestParametersValid(request);
	        
	        logger.info("get search parameter");
	        sp = this.loadSearchParameters(request);
	        
	        logger.info("get list of hotels");
	        hs = new HotelService();
	        hlist = hs.SearchForHotel(sp);
	        
	        ArrayList<CustomerHotelSearchBean> beanlist = new ArrayList<CustomerHotelSearchBean>();  
	        CustomerHotelSearchBean tempbean = null;
	        for(Hotel h : hlist)
	        {
	        	tempbean = new CustomerHotelSearchBean();
	        	tempbean.setHotel(h);
	        	tempbean.setRoom(hs.getHotelRoomOfRoomType(h, sp.getRoomType()));
	        	
	        	beanlist.add(tempbean);
	        }
	        
	        logger.info("update reservation object");
	        reservation = new Reservation();
	        reservation.setCheckInDate(sp.getCheckinDate());
	        reservation.setCheckOutDate(sp.getCheckoutDate());
	        reservation.setNumberOfRooms(sp.getNumRooms());
	        reservation.setUserId((int)session.getAttribute(globals.session_userid));
	        if(0 != beanlist.size())
	        {
	        	reservation.setRoomTypeId(beanlist.get(0).getRoom().getRoomTypeId());
	        }
	        
	        logger.info("add reservation to session");
	        session.setAttribute(globals.session_customerReservationObject, reservation);
	        
	        logger.info("Push list to session");
	        session.setAttribute(globals.session_customerSearchHotelList, beanlist);
	        
	        logger.info("redirect");
	        response.sendRedirect("ReservationSearchResults.jsp");			
        }
        catch(Exception ex)
		{
			logger.fatal("unable to validate parameters");
			throw ex;
		}
        finally
        {
        }
		
        return;
	}
}
