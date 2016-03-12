// an additional layer to prevent servlet from touching db objects directly
package ModelServiceLayer;

import dataAccessObject.IUserDao;
import dataAccessObject.UserPropertiesDao;
import modelObject.User;

public class UserService implements IUserService
{

    @Override
    public User getUserByUsername(String username) throws Exception
    {
        // this class needs no special processing.
        IUserDao userDao = new UserPropertiesDao();
        return userDao.getUserByUsername(username);
    }

    @Override
    public boolean putUser(User user) throws Exception
    {
	    try 
	    {
			IUserDao userDao = new UserPropertiesDao();
		    return userDao.addUser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    return true;
    }
    
}
