package dataAccessObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import utils.UserType;
import modelObject.CreditCard;
import modelObject.User;

public class UserPropertiesDao2 implements IUserDao
{
    String userFile = "users2.properties";
    String userTypeFile = "usertype.properties";
    
    @Override
    public boolean addUser(User user)
    {
        boolean status = true;
        
        Properties prop = new Properties();

        try 
        {
            // enter user details
            OutputStream output = new FileOutputStream(userFile);
            
            prop.setProperty(user.getUsername(), user.getPassword());
            prop.store(output, null);
            output.close();
        } 
        catch (IOException ex) 
        {
            // ex.printStackTrace();
            status = false;
        }
        
        return status;
    }

    @Override
    public User getUserByUsername(String username)
    {
        User user = null;
        Properties prop = new Properties();
        
        // get input stream
        try
        {
            InputStream input = Thread.currentThread().getClass().getClassLoader().getResourceAsStream(userFile);
            
            prop.load(input);
            
            String password = prop.getProperty(username);
            if(null != password)
            {
                user = new User();
            }
        } 
        catch (Exception ex)
        {
            // I should be doing something useful here
            ex.printStackTrace();
        }
        
        return user;
    }

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(User user) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addCreditCard(User user, CreditCard creditCard)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeCreditCard(User user, CreditCard creditCard)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateCreditCard(User user, CreditCard creditCard)
			throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

}
