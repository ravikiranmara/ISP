package reservationsTransactionsPackage;

import hotels.EditHotels;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidParameterException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelObject.ReservationsBean;

import org.apache.log4j.Logger;

import utils.globals;

import ModelServiceLayer.IHotelServiceLayer;

/**
 * Servlet implementation class ClientCancelReservationServlet
 */
@WebServlet(name = "/ClientCancelReservationServlet", urlPatterns = { "/ClientCancelReservationServlet" })
public class ClientCancelReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(ClientCancelReservationServlet.class.getName());
	
    public ClientCancelReservationServlet() {
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

	protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String cancelIdStr = request.getParameter("id"); 
		PrintWriter out = response.getWriter();
		HttpSession session = null;
		
		ArrayList<ReservationsBean> rlist = null;
		ReservationsBean cancelBean = null;
		
		int cancelId = 0;
		
		try
		{
			logger.info("cancel request confirmation page");
			session = request.getSession();
			
			cancelIdStr = request.getParameter("id");
			if(null == cancelIdStr)
			{
				throw new InvalidParameterException("reservation id is null");
			}
			
			rlist = (ArrayList<ReservationsBean>)session.getAttribute(globals.session_clientCurrResList);
			if(null == rlist)
			{
				throw new InvalidParameterException("rlist is null");
			}
			
			
			cancelId = Integer.valueOf(cancelIdStr);
			logger.info("get bean for cancel id");
			for(ReservationsBean r : rlist)
			{
				if(cancelId == r.getReservation().getId())
				{
					cancelBean = r;
				}
			}
			
			if(null == cancelBean)
			{
				throw new InvalidParameterException("Unable to find reservation bean for id");
			}
			
			logger.info("put the bean in the session");
			session.setAttribute(globals.session_clientCancelBean, cancelBean);
			
			logger.info("Redirect to cancel");
			response.sendRedirect("ClientCancelReservation.jsp");
		}
		catch (Exception ex)
		{
			logger.fatal("Unable to cancel reservation : " + ex.getMessage());
			throw ex;
		}
		
		return;
	}
}
