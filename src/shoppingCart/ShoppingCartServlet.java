package shoppingCart;

import java.io.IOException;
import java.lang.reflect.Type;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.google.gson.Gson;
import reservationsTransactionsPackage.CustomerCreateHotelReservation;
import modelObject.ShoppingCartBean;

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

	protected void handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("application/json");       
        Gson gson = new Gson();
        ShoppingCartBean scb = new ShoppingCartBean();
        
        try 
        {
            StringBuilder sb = new StringBuilder();
            String s;
            while ((s = request.getReader().readLine()) != null) 
            {
                sb.append(s);
            }
            
            System.out.println(sb.toString());
            
            
            //String jsonString = "{\"hotelid\" : \"1\", \"numrooms\" : \"1\"}";
            //System.out.println(jsonString);
            scb = gson.fromJson(sb.toString(), ShoppingCartBean.class);
            
            System.out.println(scb.getHotelid());
        }
        catch (Exception ex)
        {
        	throw new ServletException("exception : " + ex.getMessage());
        }
	}
}
