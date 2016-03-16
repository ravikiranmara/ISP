package reservationsTransactionsPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidParameterException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import loginPackage.Registration;
import modelObject.CreditCard;
import modelObject.User;
import ModelServiceLayer.IAuthenticationService;

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
		this.handleRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		this.handleRequest(request, response);
	}

	private boolean IsRequestParametersValid(HttpServletRequest request) throws InvalidParameterException, Exception
	{
		boolean status = false;
		
		try
		{
			// get all the params
			String username = request.getParameter("username");
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
	
	protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
        boolean status = true;
        PrintWriter out = response.getWriter();
        IAuthenticationService authService = null;
        ArrayList<CreditCard> creditCardlist = null;
        User user = null;
        
        try
        {
	        // validate input
	        this.IsRequestParametersValid(request);
	        

	}
}
