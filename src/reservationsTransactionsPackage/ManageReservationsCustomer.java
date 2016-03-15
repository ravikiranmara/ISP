package reservationsTransactionsPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelObject.Reservation;

import org.apache.log4j.Logger;

import ModelServiceLayer.IReservationService;
import ModelServiceLayer.ReservationService;

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
		this.handleRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.handleRequest(request, response);
	}

	protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		
		// get this from session object
		int userId = 23;
		ArrayList<Reservation> reservationList = null;
		IReservationService reservationService = null;
		
		try
		{
			reservationService = new ReservationService();
			reservationList = reservationService.getReservationForUser(userId);
			
			if(null != reservationList)
			{
				for(Reservation r : reservationList)
				{
					out.println(r.getHotelId() + " " + r.getNumberOfRooms());
				}
			}
		}
		catch(Exception ex)
		{
			logger.fatal("Unable to get reservation list");
			throw ex;
		}
	    finally 
	    {}
		
	}

}
