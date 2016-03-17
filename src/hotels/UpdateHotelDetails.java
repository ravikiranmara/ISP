package hotels;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import utils.globals;

import modelObject.Hotel;
import modelObject.Room;
import ModelServiceLayer.IHotelServiceLayer;

/**
 * Servlet implementation class UpdateHotelDetails
 */
@WebServlet(name = "/UpdateHotelDetails", urlPatterns = { "/UpdateHotelDetails" })
public class UpdateHotelDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(UpdateHotelDetails.class.getName());
       
    public UpdateHotelDetails() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		this.handleRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		this.handleRequest(request, response);
	}
	
	private void getAndUpdateHotel(HttpServletRequest request, Hotel hotel)
	{
		String hotelname = request.getParameter("hotelname");
		String description = request.getParameter("description");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String roomtype = request.getParameter("roomtype");
		String numrooms = request.getParameter("numrooms");
		String price = request.getParameter("price");
		String id = request.getParameter("id");
		String bathtub = request.getParameter("bathtub");
		String breakfast = request.getParameter("breakfast");
		String wifi = request.getParameter("wifi");
		String gym = request.getParameter("gym");
		String internet = request.getParameter("internet");
		String pool = request.getParameter("pool");
		String pet = request.getParameter("pet");
		
		try
		{
			logger.info("update values");
			if(null == hotelname || null == description || null == city || 
					null == state || null == roomtype || null == numrooms ||
					null == price || null == id || null == bathtub ||
					null == breakfast || null == breakfast || null == wifi ||
					null == wifi || null == gym || null == internet || 
					null == pool || null == pet)
			{
				throw new Exception("some of the parameter is null");
			}
			
			if(false == hotelname.isEmpty())
			{
				hotel.setName(hotelname);
			}
			if(false == description.isEmpty())
			{
				hotel.setDescription(description);
			}
			if(false == city.isEmpty())
			{
				hotel.setCity(city);
			}
			if(false == state.isEmpty())
			{
				hotel.setState(state);
			}
			if(false == price.isEmpty() || false == numrooms.isEmpty())
			{
				Room room = null;
				ArrayList<Room> roomlist = hotel.getRoom();
				String roomname = null;
				int rid = Integer.parseInt(roomtype);
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
				
				for(Room r : roomlist)
				{
					if(r.getRoomType().equalsIgnoreCase(roomname))
					{
						room = r;
						break;
					}
				}
				
				if(false == price.isEmpty())
				{
					room.setPricePerNight(Float.valueOf(price));
				}
				if(false == numrooms.isEmpty())
				{
					room.setAvailableNumber(Integer.valueOf(numrooms));
				}
			}
		}
		catch (Exception ex)
		{
			logger.fatal("unable to udate hotel object:" + ex.getMessage());
		}
		finally
		{ }
		
		return;
	}

	protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		IHotelServiceLayer hotelService = null;
		Hotel hotel = null;
		HttpSession session = null;
		
		try
		{
			logger.info("update hotel");
			session = request.getSession();
			
			logger.info("get hotel");
			hotel = (Hotel)session.getAttribute(globals.session_editHotelObject);
			
			this.getAndUpdateHotel(request, hotel);
			
		}
		catch (Exception ex)
		{
			logger.fatal("unable to update hotel details : " + ex.getMessage());
			throw ex;
		}
		finally
		{ }
		
		return;
	}
}
