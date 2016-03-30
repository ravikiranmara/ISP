package modelObject;

import java.util.ArrayList;
import org.apache.log4j.Logger;

import com.google.gson.Gson;

public class ShoppingCartBean 
{
	ArrayList<ShoppingCartItem> cart;
	int itemid;
	static Logger logger = Logger.getLogger(ShoppingCartBean.class.getName());

	// constructor
	public ShoppingCartBean()
	{
		itemid = 0;
		cart = new ArrayList<ShoppingCartItem>();
	}
	
	public boolean addToCart(ShoppingCartItem item)
	{
		boolean status = false;
		try
		{
			itemid++;
			logger.info("set item id and add to cart");
			item.setItemid(itemid);
			cart.add(item);
			status = true;
		}
		catch (Exception ex)
		{
			logger.fatal("Exception adding item to cart:" + ex.getMessage());
			throw ex;
		}
		finally 
		{ }
	
		logger.info("added item to cart");
		return status;
	}

	public String getCartItemsAsJson()
	{
		String jsonString = null;
		
		try
		{
			Gson gson = new Gson();
			jsonString = gson.toJson(cart);
			System.out.println(jsonString);
		}
		catch (Exception ex)
		{
			
		}
		
		return jsonString;
	}
	
	// getter and setter 
	public ArrayList<ShoppingCartItem> getCart() {
		return cart;
	}

	public void setCart(ArrayList<ShoppingCartItem> cart) {
		this.cart = cart;
	}
}
