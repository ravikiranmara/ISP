package loginPackage;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelObject.User;
import utils.UserType;
import utils.globals;
import ModelServiceLayer.AuthenticationService;
import ModelServiceLayer.IAuthenticationService;
import ModelServiceLayer.IUserService;
import ModelServiceLayer.UserService;

/**
 * Servlet implementation class Register
 */
@WebServlet(description = "register new users", urlPatterns = { "/Registration" })
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        boolean status = true;
        PrintWriter out = response.getWriter();
        IAuthenticationService authService = null;
        
        // get the parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password2 = request.getParameter("retypepassword");
        String usertype = request.getParameter("usertype");
        UserType userTypeEnum = null;
        User user = null;
        
        out.println("username - " + username + " password - " + password + " password2 - " + password2 + " usertype - " + usertype);
        // sanity check
        if(null == username || null == password || null == password2 || usertype == null)
        {
            status = false;
        }
        
        // check if empty
        if(false != status)
        {
            if(username.isEmpty() || password.isEmpty() || password2.isEmpty() || usertype.isEmpty())
            {
                status = false;
            }
        }
        
        // basic check 
        if(false != status)
        {
            if(!password.equals(password2))
            {
                status = false;
            }
        }
        
        // get usertype
        if (false != status)
        {
            out.println("usertype - " + usertype);
            if(usertype.equalsIgnoreCase("client"))
                userTypeEnum = UserType.Client;
            else if(usertype.equalsIgnoreCase("customer"))
                userTypeEnum = UserType.Customer;
            else
                status = false;
        }
        
        
        // construct our usertype
        if(false != status)
        {
            out.println("New user\n");
            user = new User();
        }
        
        // check if this is a valid user
        if(false != status)
        {
            authService = new AuthenticationService();
            status = authService.IsUserDetailsForRegistrationValid(user);
            out.println("auth result = " + (status==true?"true":"false"));
        }
        
        // if the user is valid for registration, lets register
        if(false != status)
        {
            IUserService userService = new UserService();
            status = userService.putUser(user);
        }
        
        // if registration is successful, acknowledge
        if(false != status)
        {
            //out.println("redirect to login page");
            response.sendRedirect("Login.jsp");
        }
        else
        {
            //out.println("redirect to itself with error message?");
            // need to show some error message
            response.sendRedirect("RegisterErrorDisplay.jsp");        
        }
        
        // redirect to login page
    }
}
