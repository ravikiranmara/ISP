package shoppingCart;

import java.io.IOException;
import java.lang.reflect.Type;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import reservationsTransactionsPackage.CustomerCreateHotelReservation;
import utils.globals;
import modelObject.ShoppingCartBean;
import modelObject.ShoppingCartItem;

@WebServlet(name = "/ShoppingCartServlet", urlPatterns = { "/ShoppingCartServlet" })
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(CustomerCreateHotelReservation.class.getName());
	       
    public ShoppingCartServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.handleRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.handleRequest(request, response);
	}

	protected void addTocart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Gson gson = null;
        ShoppingCartItem scb = null;
        StringBuilder sb = null;
        HttpSession session = null;
        
        try 
        {
        	logger.info("add to shopping cart");
        	session = request.getSession();
        	gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        	
        	logger.info("Get json string");
            sb = new StringBuilder();
            String s;
            while ((s = request.getReader().readLine()) != null) 
            {
                sb.append(s);
            }
            logger.info("Json string : " + sb.toString());
            
            System.out.println(sb.toString());
            scb = gson.fromJson(sb.toString(), ShoppingCartItem.class);
            
            logger.info("get shopping cart from session");
            ShoppingCartBean bean = (ShoppingCartBean)session.getAttribute(globals.session_shoppingcart);

            logger.info("Add session to cart");
            bean.addToCart(scb);
            
            response.getWriter().write("successful");
        }
        catch (Exception ex)
        {
        	throw new ServletException("exception : " + ex.getMessage());
        }
        finally
        {   }

        return;
	}
	
	protected void getAllItemsInCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Gson gson = null;
        String jsontext = null;
        HttpSession session = null;
        
        try 
        {
        	logger.info("get all shopping cart item");
        	session = request.getSession();
        	gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
        	
        	logger.info("get shopping cart bean from session");
            ShoppingCartBean bean = (ShoppingCartBean)session.getAttribute(globals.session_shoppingcart);

            logger.info("Convert object to json");
            jsontext = gson.toJson(bean);
            
            logger.info("Write the response back");
            response.getWriter().write(jsontext);
        }
        catch (Exception ex)
        {
        	logger.fatal("Unable to get all elements of shopping cart");
        	throw new ServletException("exception : " + ex.getMessage());
        }
        finally
        {   }

        return;

        
	}
	
	protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("application/json");       
        String method = request.getParameter("method");
		
        logger.info("shopping cart servlet : " + method.equalsIgnoreCase("addToCart"));
        if(method.equalsIgnoreCase("addToCart"))
        {
        	logger.info("Calling add to cart");
        	this.addTocart(request, response);
        }
        else if (method.equalsIgnoreCase("getAllItemsInCart"))
        {
        	this.getAllItemsInCart(request, response);
        }
		
        return;
	}
}
