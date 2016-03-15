// an additional layer to prevent servlet from touching db objects directly
package ModelServiceLayer;

import org.apache.log4j.Logger;

import dataAccessObject.IUserDao;
import dataAccessObject.UserDAO;
import dataAccessObject.UserPropertiesDao;
import loginPackage.Login;
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
}
