package loginPackage;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.InvalidParameterException;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import modelObject.CreditCard;
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
public class Registration extends HttpServlet 
{
	static Logger logger = Logger.getLogger(Registration.class.getName());
    
	private static final long serialVersionUID = 1L;
       
    public Registration() 
    {
        super();
    }

    public void init(ServletConfig config) throws ServletException 
    {
        if(null == globals.webInfPath)
        {
            globals.webInfPath = config.getServletContext().getRealPath(globals.propertiesPath);
        }
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	    try 
	    {
			this.handleRequest(request, response);
		} 
	    catch (Exception e) 
		{
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try 
		{
			this.handleRequest(request, response);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	private boolean IsRequestParametersValid(HttpServletRequest request) throws InvalidParameterException, Exception
	{
		boolean status = false;
		
		try
		{
			// get all the params
			String username = request.getParameter("username");
	        String password = request.getParameter("password");
	        String password2 = request.getParameter("retypepassword");
	        String usertype = request.getParameter("usertype");
	        String firstName = request.getParameter("firstName");
	        String lastName = request.getParameter("lastName");
	        String address1 = request.getParameter("address1");
	        String address2 = request.getParameter("address2");
	        String city = request.getParameter("city");
	        String state = request.getParameter("state");
	        String postalCode = request.getParameter("postalCode");
	        String creditCardNumber = request.getParameter("creditCardNumber");
	        String creditCardHolderName = request.getParameter("creditCardHolderName");
	        String creditCardNickName = request.getParameter("creditCardNickName");
	        String creditCardCvv = request.getParameter("creditCardCvv");
	        String creditCardBalance = request.getParameter("creditCardBalance");
	        
	        // null check
	        if(null == username || null == password || null == password2 || usertype == null ||
	        	null == firstName || null == lastName || null == address1 || null == address2 ||
	        	null == city || null == state || null == postalCode || 
	        	null == creditCardNumber || null == creditCardHolderName || null == creditCardNickName ||
	        	null == creditCardCvv || null == creditCardBalance)
	        {
	            throw new InvalidParameterException("atleast one of the input parameters are null");
	        }
	        
	        // variables that cannot be empty
	        if(username.isEmpty() || password.isEmpty() || password2.isEmpty() || usertype.isEmpty() ||
	        		firstName.isEmpty() | lastName.isEmpty())
	        {
	            throw new InvalidParameterException("atleast one of the name elements are empty strings"); 
	        }
	        
	        if(null != creditCardNumber && false == creditCardNumber.isEmpty())
	        {
	        	if(creditCardNumber.isEmpty() || creditCardHolderName.isEmpty() || creditCardNickName.isEmpty() ||
	    	        	creditCardCvv.isEmpty() || creditCardBalance.isEmpty())
	        	{
	        		throw new InvalidParameterException("atleast one of the Credit card elements are empty strings");
	        	}
	        	
	        	float temp = Float.valueOf(creditCardBalance);
	        }
	        
	        UserType userTypeEnum;
			if(usertype.equalsIgnoreCase("client"))
	        	userTypeEnum = UserType.Client;
	        else if(usertype.equalsIgnoreCase("customer"))
	            userTypeEnum = UserType.Customer;
	        else
	        	throw new InvalidParameterException("Usertype is not valid");
	        
	        
	        // basic check 
	        if(false != status)
	        {
	            if(!password.equals(password2))
	            {
	                status = false;
	            }
	        }
	        
	        // survived till here, so all tests passed
	        status = true;
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
	
	private boolean LoadUserData(User user, HttpServletRequest request) throws Exception
	{
		boolean status = false;
		
		try
		{
			user.setUsername(request.getParameter("username"));
	        user.setPassword(request.getParameter("password"));
	        user.setFirstName(request.getParameter("firstName"));
	        user.setLastName(request.getParameter("lastName"));
	        user.setAddressLine1(request.getParameter("address1"));
	        user.setAddressLine2(request.getParameter("address2"));
	        user.setCity(request.getParameter("city"));
	        user.setState(request.getParameter("state"));
	        user.setPostalCode(request.getParameter("postalCode"));
	        user.setUserStatus(globals.valid);
	        
	        String usertype = request.getParameter("usertype");
	        UserType userTypeEnum;
			if(usertype.equalsIgnoreCase("client"))
	        	userTypeEnum = UserType.Client;
	        else 
	            userTypeEnum = UserType.Customer;
	        user.setUserType(userTypeEnum);
	        
	        // we survived till here, so
	        status = true;
		}
		catch (Exception e)
		{
			logger.fatal("Exception loading user detials form request object");
			throw e;
		}
		finally
		{
		}
		
		return status;
	}
	
	private boolean LoadCreditCardData(ArrayList<CreditCard> creditCardList, HttpServletRequest request)
	{
		boolean status = false;
		CreditCard tempCard = null;
		
		try
		{
			if(null == creditCardList)
			{
				creditCardList = new ArrayList<CreditCard>();
			}
			
			String cardNumber = request.getParameter("creditCardNumber");
	        String holderName = request.getParameter("creditCardHolderName");
	        String nickName = request.getParameter("creditCardNickName");
	        String cvv = request.getParameter("creditCardCvv");
	        float balance = Float.valueOf(request.getParameter("creditCardBalance"));
	        
			
			// currently we have only one card. figure out how to add more
			if(null != cardNumber && false == cardNumber.isEmpty())
			{
				tempCard = new CreditCard();
				tempCard.setCardNumber(cardNumber);
				tempCard.setHolderName(holderName);
				tempCard.setNickName(nickName);
				tempCard.setCvv(cvv);
				tempCard.setBalance(balance);
				tempCard.setUserId(-1);
				
				creditCardList.add(tempCard);
			}
			
			status = true;
			
		}
		catch (Exception e)
		{
			logger.fatal("Exception loading credit card detials form request object");
			throw e;
		}
		finally
		{
		}
		
		return status;
	}
	
	/**
     * @throws Exception 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception 
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
	        
	        // new user and load arams
	        user = new User();
	        creditCardlist = new ArrayList<CreditCard>();

	        // load user data
	        this.LoadUserData(user, request);
	        
	        // check if this is a valid user
	        authService = new AuthenticationService();
	        if(false == authService.IsUserDetailsForRegistrationValid(user))
	        {
	        	throw new InvalidParameterException("User Data entered for registration is invalid");
	        }

	        // load credit ard details
	        this.LoadCreditCardData(creditCardlist, request);

	        // link credit cards to user
	        user.setCreditCard(creditCardlist);
	        
	        // if the user is valid for registration, lets register
	        IUserService userService = new UserService();
	        if(false == userService.putUser(user))
	        {
	        	throw new Exception("Unable to insert user");
	        }
	        
	        status = true;
        }
        catch (InvalidParameterException ex)
        {
            status = false;
            logger.fatal(ex.getMessage());
        }
        catch (Exception ex)
        {
        	status = false;
        	logger.fatal(ex.getMessage());
        }
        finally
        {	
        }
        
        // if registration is successful, acknowledge
        if(false != status)
        {
            //out.println("redirect to login page");
            response.sendRedirect("Login.jsp");
        }
        else
        {
        	response.sendRedirect("RegisterErrorDisplay.jsp");
        }
    }
}
