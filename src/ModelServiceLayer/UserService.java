// an additional layer to prevent servlet from touching db objects directly
package ModelServiceLayer;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import dataAccessObject.IUserDao;
import dataAccessObject.UserDAO;
import dataAccessObject.UserPropertiesDao;
import loginPackage.Login;
import modelObject.CreditCard;
import modelObject.User;

public class UserService implements IUserService
{
	static Logger logger = Logger.getLogger(UserService.class.getName());
    
    @Override
    public User getUserByUsername(String username) throws Exception
    {
    	User user = null;
    	
        // this class needs no special processing.
        IUserDao userDao = new UserDAO();
        try
        {
        	user = userDao.getUserByUsername(username);
        }
        catch (Exception e) 
		{
			logger.fatal("Unable to put user in db");
			e.printStackTrace();
		}
	    
        return user;
    }

    @Override
    public boolean putUser(User user) throws Exception
    {
	    try 
	    {
			IUserDao userDao = new UserDAO();
		    return userDao.addUser(user);
		} 
	    catch (Exception e) 
		{
			logger.fatal("Unable to put user in db");
			e.printStackTrace();
		}
	    
	    return true;
    }

	@Override
	public boolean isUserExists(String username) throws Exception 
	{
		boolean status = false;
		User user = null;
		
		try
		{
			logger.info("Check if user exists");
			IUserDao userDao = new UserDAO();
			user = userDao.getUserByUsername(username);
			
			if(null == user)
			{
				status = false;
			}
			else
			{
				status = true;
			}
		}
		catch (Exception e)
		{
			logger.info("user service unable to check isUserExist :" + e.getMessage());
			throw e;
		}
		finally
		{
		}
		
		return status;
	}

	@Override
	public User getUserById(int userId) throws Exception 
	{
		User user = null;
    	
        // this class needs no special processing.
        IUserDao userDao = new UserDAO();
        try
        {
        	logger.info("get user by user id");
        	user = userDao.getUserById(userId);
        }
        catch (Exception e) 
		{
			logger.fatal("Unable to put user in db");
			e.printStackTrace();
		}
	    
        return user;}

	@Override
	public CreditCard getCreditCardForUser(int userId, int CreditCardId)
			throws Exception 
	{
		boolean status = false;
		UserDAO userDao = null;
		User toUser = null;
		CreditCard toCreditCard = null;
		ArrayList<CreditCard> toccList = null;
		
		try
		{
			logger.info("make payment");
			userDao = new UserDAO();
			
			logger.info("get users");
			toUser = userDao.getUserById(userId);
			
			if(null == toUser)
			{
				throw new InvalidParameterException("User Id is not valid, unable to find user");
			}
			
			logger.info("get creditCards");
			toccList = toUser.getCreditCard();
			
			if(null == toccList)
			{
				throw new InvalidParameterException("User credit card is not valid, credit card list is null");
			}
			
			for(CreditCard cc : toccList)
			{
				if(CreditCardId == cc.getId())
				{
					toCreditCard = cc;
				}
			}
			
			if(null == toccList)
			{
				throw new InvalidParameterException("User credit card id is not valid, unable to find credit card with id");
			}
		}
		catch (InvalidParameterException ex)
		{
			logger.fatal(ex.getMessage());
			throw ex;
		}
		catch (IllegalStateException ex)
		{
			logger.fatal(ex.getMessage());
			status = false;
		}
		catch (Exception ex)
		{
			logger.fatal(ex.getMessage());
			throw ex;
		}
		finally
		{
		}
		
		return toCreditCard;
	}

	@Override
	public boolean addCreditCardToUser(int userId, CreditCard creditCard)
			throws Exception 
	{
		boolean status = false;
		UserDAO userDao = null;
		User toUser = null;
		CreditCard toCreditCard = null;
		ArrayList<CreditCard> toccList = null;
		
		try
		{
			userDao = new UserDAO();
			
			logger.info("get users");
			toUser = userDao.getUserById(userId);
			
			if(null == toUser)
			{
				throw new InvalidParameterException("User Id is not valid, unable to find user");
			}
			
			logger.info("get creditCards");
			toccList = toUser.getCreditCard();
			
			if(null == toccList)
			{
				throw new InvalidParameterException("User credit card is not valid, credit card list is null");
			}
			
			for(CreditCard cc : toccList)
			{
				if(creditCard.getCardNumber().equalsIgnoreCase(cc.getCardNumber()))
				{
					toCreditCard = cc;
				}
			}
			
			if(null != toccList)
			{
				throw new InvalidParameterException("User credit card id is not valid, credit card same id exists");
			}
			
			userDao.addCreditCard(toUser, creditCard);	
			toUser.getCreditCard().add(creditCard);
			status = true;
		}
		catch (InvalidParameterException ex)
		{
			logger.fatal(ex.getMessage());
			throw ex;
		}
		catch (IllegalStateException ex)
		{
			logger.fatal(ex.getMessage());
			status = false;
		}
		catch (Exception ex)
		{
			logger.fatal(ex.getMessage());
			throw ex;
		}
		finally
		{
		}
		
		return status;
	}

	@Override
	public boolean updateCreditCard(int userId, CreditCard creditCard)
			throws Exception 
	{
		boolean status = false;
		UserDAO userDao = null;
		User toUser = null;
		CreditCard toCreditCard = null;
		ArrayList<CreditCard> toccList = null;
		
		try
		{
			userDao = new UserDAO();
			
			logger.info("get users");
			toUser = userDao.getUserById(userId);
			
			userDao.updateCreditCard(toUser, creditCard);
			status = true;
		}
		catch (InvalidParameterException ex)
		{
			logger.fatal(ex.getMessage());
			throw ex;
		}
		catch (IllegalStateException ex)
		{
			logger.fatal(ex.getMessage());
			status = false;
		}
		catch (Exception ex)
		{
			logger.fatal(ex.getMessage());
			throw ex;
		}
		finally
		{
		}
		
		return status;
	}
}
