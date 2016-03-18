package loginPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import org.apache.log4j.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ModelServiceLayer.AuthenticationService;
import ModelServiceLayer.IAuthenticationService;
import ModelServiceLayer.IUserService;
import ModelServiceLayer.UserService;

import utils.UserType;
import utils.globals;

import modelObject.User;
import dataAccessObject.IUserDao;
import dataAccessObject.UserPropertiesDao;
import dataAccessObject.UserPropertiesDao2;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(Login.class.getName());
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	    if(null == globals.webInfPath)
        {
            globals.webInfPath = config.getServletContext().getRealPath(globals.propertiesPath);
        }
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.handleRequest(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.handleRequest(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @throws Exception 
	 * @see HttpServlet#handleRequest(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
	{
	    boolean status = true;
		boolean auth = false;
	    PrintWriter out = response.getWriter();
	    
	    // get the parameters
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// validate the parameters are not null display error if so
		if(username == null || password == null)
		{
		    status = false;
			logger.info("Parameters are invalid. Username - " + username + ", Password - " + password);
			// redirect to same page with error message 
		}
		
		// now check if the user is proper
		if(status != false)
		{
		    IAuthenticationService authService = new AuthenticationService();
		    auth = authService.authenticateUser(username, password);
		    logger.info("Username - " + username + ", Password - " + password + " status - " + (auth?"true":"false"));            
		}
		
		// if no errors and valid user, get user  
		IUserService userService = new UserService();
		User user = null;
		if(false != status && true == auth)
		{
		    user = userService.getUserByUsername(username);
		}
		
		// now redirect them to page
		if(false != status && true == auth)
		{
		    // there should be a better way than if else
			logger.info("Creating session");
			HttpSession session = request.getSession();
			session.setAttribute(globals.session_username, username);
			session.setAttribute(globals.session_userid, user.getUserId());
		    if(UserType.Client == user.getUserType())
		    {
		        response.sendRedirect("ClientHomePage.jsp");
		    }
		    else
		    {
		        response.sendRedirect("CustomerHomePage.jsp");
		        //RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("CustomerHomePage.jsp");
		        //RequetsDispatcherObj.forward(request, response);
		    }
		}
		else
		{
		    response.sendRedirect("Registration.jsp");
		}
	}
}
