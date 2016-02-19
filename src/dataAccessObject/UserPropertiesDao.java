package dataAccessObject;

import modelObject.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import utils.UserType;
import utils.globals;


public class UserPropertiesDao implements IUserDao
{
	String userFilename = "users.properties";
	String userFilepath = globals.webInfPath + "\\" + userFilename;
	
	String userTypeFilename = "userType.properties";
	String userTypeFilepath = globals.webInfPath + "\\" + userTypeFilename;
	
	private boolean putProperty(String filepath, String key, String value)
	{
	    boolean status = true;
	    System.out.println("putproperty filepath - " + filepath);
	
	    try
	    {
    	    Properties property = new Properties();
    	    File file = new File(filepath);
    
    	    // read from file
    	    InputStream inStream = new FileInputStream(file);
            property.load(inStream);
    	    
            // append to file contents
            property.setProperty(key, value);
            FileOutputStream outputStream = new FileOutputStream(file);
            
            // write to file
            property.store(outputStream, null);
            outputStream.close();
	    }
	    catch(Exception ex)
	    {
	        ex.printStackTrace();
	        status = false;
	    }
	    
	    return status;
	}
	
	private String getProperty(String filepath, String key)
	{
	    String value = null;
	    System.out.println("getproperty filepath - " + filepath);
	    
	    try 
        {
	        Properties property = new Properties();
	        File file = new File(filepath);
            InputStream inStream = new FileInputStream(file);
        
            property.load(inStream);
            
            value = property.getProperty(key);
            
        } 
	    catch (Exception ex) 
        {
            ex.printStackTrace();
        }
	    
	    return value;
	}
	
	@Override
	public boolean putUser(User user) 
	{
		boolean status = true;
	
		// Write username,password)
	    status = this.putProperty(userFilepath, user.getUsername(), user.getPassword());
            
        // write (username, usertype)
	    if(false != status)
	    {
	        status = this.putProperty(userTypeFilepath, user.getUsername(), user.getUserType().toString());
	    }
	    
        return status;
        
	}

	// null if user is not present 
	// todo : exception if there is some error. catch exception above
	@Override
	public User getUserByUsername(String username) 
	{
		String password = null;
		String usertype = null;
		UserType userTypeEnum = null;
		User user = null;
		boolean status = true;
		
		if(false != status)
		{
		    password = this.getProperty(userFilepath, username);
		    if(null == password)
		    {
		        status = false;
		    }
		}
		
		if(false != status)
		{
		    usertype = this.getProperty(userTypeFilepath, username);
		    if(usertype == null)
		    {
		        status = false;
		    }
		    
		}
		
		if(false != status)
		{
            try
            {
                userTypeEnum = UserType.valueOf(usertype); 
            }
            catch (IllegalArgumentException ex)
            {
                ex.printStackTrace();
                // log specific error
                status = false;
            }
	    }
		if(false != status)
		{
		    user = new User(username, password, userTypeEnum);
		}
		
		return user;
	}

}
