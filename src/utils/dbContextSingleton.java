package utils;

import java.sql.*;

import org.apache.log4j.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import utils.globals;

/*
 * Currently we are assuming that db is already created 
 * We can add a different class to handle db creation and update, 
 * which can be called from init
 * This class is meant only to manage connections
 */
import javax.naming.NamingException;

public class dbContextSingleton
{
	boolean isInitialized; 
	Connection connection;
	
	static Logger logger = Logger.getLogger(dbContextSingleton.class.getName());
	
    private dbContextSingleton() throws NamingException, ClassNotFoundException, SQLException
    {
    	isInitialized = false;
    	
		Context env;
		try 
		{
			env = (Context)new InitialContext().lookup("java:comp/env");
			String dbName = (String)env.lookup(globals.webConfig_dbname);
			String dbDriver = (String)env.lookup(globals.webConfig_dbdriver);
			String dbUsername = (String)env.lookup(globals.webConfig_username);
			String dbPassword = (String)env.lookup(globals.webConfig_password);
			String driverString = dbDriver + dbName;
			
			logger.info("Loading DB Driver : " + driverString);
			Class.forName(driverString);
			
			logger.info("Creating connection");
			connection = DriverManager.getConnection(driverString, dbUsername, dbPassword);
		} 
		catch (NamingException e) 
		{
			logger.fatal("Unable to load variable from web.xml file");
			e.printStackTrace();
			throw e;
		}
		catch (ClassNotFoundException e)
		{
			logger.fatal("Unable to load Driver Class");
			e.printStackTrace();
			throw e;
		}
		catch (SQLException e)
		{
			logger.fatal("Unable to create sql connection");
			e.printStackTrace();
			throw e;
		}
		
		isInitialized = true;
		
		return;
	}

    public static dbContextSingleton getSingletonObject() throws Exception
    {
      if (ref == null)
      {
		try 
		{
			ref = new dbContextSingleton();
		} 
		catch (ClassNotFoundException | NamingException | SQLException e) 
		{
			logger.fatal("Unable to get dbContext object: " + e.getMessage());
			throw e;
		}
      }
      
      return ref;
    }

    private static dbContextSingleton ref;
    
    public Connection getConnection()
    {
    	if(true == this.isInitialized)
    	{
    		return this.connection;
    	}
    	else return null;
    }
}