package reservationsTransactionsPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelObject.Hotel;
import modelObject.Reservation;
import modelObject.User;

import org.apache.log4j.Logger;

import utils.globals;
import ModelServiceLayer.HotelService;
import ModelServiceLayer.IHotelServiceLayer;
import ModelServiceLayer.IReservationService;
import ModelServiceLayer.IUserService;
import ModelServiceLayer.UserService;

/**
 * Servlet implementation class ClientReservationServlet
 */
@WebServlet(name = "/ClientReservationServlet", urlPatterns = { "/ClientReservationServlet" })
public class ClientReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(ManageHotels.class.getName());


    public ClientReservationServlet() {
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
		IUserService userService = null;
		IHotelServiceLayer hotelService = null;
		User owner = null;
		HttpSession session = null;
		String username = null;
		ArrayList<Hotel> hotelList;
		
		// get this from session object
		ArrayList<Reservation> reservationList = null;
		IReservationService reservationService = null;
		
		try
		{
			logger.info("Create reservation servlet");
			session = request.getSession();
			username = (String)session.getAttribute(globals.session_username);
			
			if(username == null)
			{
				throw new IllegalStateException("User is not logged in");
			}
			
			logger.info("get user id");
			userService = new UserService();
			owner = userService.getUserByUsername(username);
			
			logger.info("Get all hotels for the owner");
			hotelService = new HotelService();
			hotelList = hotelService.getHotelForOwnerId(owner.getUserId());
			
			logger.info("attach hotel to session");
			session.setAttribute(globals.session_CreateReshotelsByOwner, hotelList);
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

		response.sendRedirect("ClientCreateReservation.jsp");
	}
	
}
