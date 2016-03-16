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

import org.apache.log4j.Logger;

import loginPackage.Registration;
import modelObject.CreditCard;
import modelObject.Hotel;
import modelObject.SearchParameter;
import modelObject.User;
import ModelServiceLayer.HotelService;
import ModelServiceLayer.IAuthenticationService;
import ModelServiceLayer.IHotelServiceLayer;

@WebServlet("/HotelSearchServlet")
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

	private boolean IsRequestParametersValid(HttpServletRequest request) throws InvalidParameterException, Exception
	{
		boolean status = false;
		
		try
		{
			// get all the params
			String hotelName = request.getParameter("hotelName");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String checkinDateString = request.getParameter("checkInDate");
			String checkoutDateString = request.getParameter("checkOutDate");
			String numRoom = request.getParameter("numroom");
			String roomType = request.getParameter("roomtype");
			
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
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
		String hotelName = request.getParameter("hotelName");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String checkinDateString = request.getParameter("checkInDate");
		String checkoutDateString = request.getParameter("checkOutDate");
		String numRoom = request.getParameter("numroom");
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
			
			if(false == checkinDateString.isEmpty())
			{
				java.util.Date date = sdf1.parse(checkinDateString);
				java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
				sp.setCheckinDate(sqlStartDate);
			}
	
			if(false == checkoutDateString.isEmpty())
			{
				java.util.Date date = sdf1.parse(checkinDateString);
				java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
				sp.setCheckoutDate(sqlStartDate);
			}
	
			if(false == numRoom.isEmpty())
			{
				sp.setNumRooms(Integer.parseInt(numRoom));
			}
			
			if(false == roomType.isEmpty())
			{
				sp.setRoomType(roomType);
			}
		}
		catch (Exception ex)
		{
			logger.fatal("unable to get serarch parameters");
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
        
        try
        {
	        // validate input
	        this.IsRequestParametersValid(request);
	        
	        // get search parameter
	        this.loadSearchParameters(request);
	        
	        // now send it off to 
	        hs = new HotelService();
	        
        }
        catch(Exception ex)
		{
			logger.fatal("unable to validate parameters");
			throw ex;
		}
		
		return;
	}
}
