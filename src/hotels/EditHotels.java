package hotels;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelObject.Hotel;

import org.apache.log4j.Logger;

import ModelServiceLayer.HotelService;
import ModelServiceLayer.IHotelServiceLayer;
import ModelServiceLayer.IUserService;

import reservationsTransactionsPackage.ClientCurrentReservation;
import utils.globals;

/**
 * Servlet implementation class EditHotels
 */
@WebServlet(name = "/EditHotels", urlPatterns = { "/EditHotels" })
public class EditHotels extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(EditHotels.class.getName());
	
    public EditHotels() 
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
		String hotelId = request.getParameter("id"); 
		PrintWriter out = response.getWriter();
		IHotelServiceLayer hotelService = null;
		Hotel hotel = null;
		HttpSession session = null;
		
		try
		{
			logger.info("get hotel and populate for edit");
			session = request.getSession();
			
			if(hotelId == null)
			{
				throw new IllegalArgumentException("Id is null");
			}
			
			if(true == hotelId.isEmpty())
			{
				throw new IllegalArgumentException("Id is empty");
			}
			
			int id = Integer.parseInt(hotelId);
			
			logger.info("get hotel from id");
			hotelService = new HotelService();
			hotel = hotelService.getHotelById(id);
			
			if(null == hotel)
			{
				throw new Exception("Hotel not found");
			}
			
			logger.info("attach it to session");
			session.setAttribute(globals.session_editHotelObject, hotel);
			
			response.sendRedirect("EditHotelDetails.jsp");
		}
		catch(Exception ex)
		{
			logger.fatal("Unable to get hotel for edit: " + ex.getMessage());
			throw ex;
		}
	    finally 
	    {}
		
		return;
	}
}
