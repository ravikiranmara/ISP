package dataAccessObject;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import utils.UserType;
import modelObject.User;

public class UserPropertiesDao2 implements IUserDao
{
    String userFile = "users2.properties";
    String userTypeFile = "usertype.properties";
    
    @Override
    public boolean putUser(User user)
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
                user = new User(username, password, UserType.Client);
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

}
