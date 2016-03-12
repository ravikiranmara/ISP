package dataTransferObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import utils.dbContextSingleton;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;

public class AmenityDTO
{
	String tableName = "Amenities";
    int id;
    String name;
    String description;
    boolean isInitialized;
    
    static Logger logger = Logger.getLogger(UserDTO.class.getName());
	
    public AmenityDTO()
    {
    	this.initialize();
	}

    public void clear()
    {
    	this.initialize();
    }
    
    private void initialize()
    {
    	id = -1;
    	description = name = "";
    	isInitialized = false;
    }
    
    public void initialize(Integer id, String[] nameDesc)
    {
    	this.id = id;
    	this.name = nameDesc[0];
    	this.description = nameDesc[1];
    }
    
	public HashMap<Integer, String[]> getAllAmenity() throws Exception
    {
    	HashMap<Integer, String[]> tempAmenityHash = null;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int tempId;
		String tempName;
		String tempDescription;
		
		try 
		{
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "select Id, Name, Description" +
					" from " + this.tableName;
			
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			tempAmenityHash = new HashMap<Integer, String[]>();
			while(rs.next())
			{
				tempId = rs.getInt("Id");
				tempName = rs.getString("Name");
				tempDescription = rs.getString("Description");
				tempAmenityHash.put(tempId, new String[]{tempName, tempDescription});
				this.isInitialized = true;
			}
		} 
		catch (Exception e) 
		{
			logger.fatal("Unable to get User details : " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally
		{
			ps.close();
		}
			
    	return tempAmenityHash;
    }
    
    public boolean getAmenitybyId(int id) throws Exception
    {
    	boolean status = false;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try 
		{
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "select Id, Name, Description" +
					" from " + this.tableName + " Id = ?";
			ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				this.id = rs.getInt("Id");
				this.name = rs.getString("Name");
				this.description = rs.getString("Description");
				this.isInitialized = true;
				status = true;
			}
		} 
		catch (Exception e) 
		{
			logger.fatal("Unable to get User details : " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally
		{
			ps.close();
		}
	
    	return status;
    }
    
    public int addAmenity() throws Exception
    {
    	int insertId = -1;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		
		try 
		{
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "Insert Into " + this.tableName + " (Name, Description)" +
					" values (?)";
			
			ps = connection.prepareStatement(query);
			
			// init
			ps.setString(1, this.name);
			ps.setString(2, this.description);
			
			this.id = ps.executeUpdate();
			insertId = this.id;
		} 
		catch (Exception e) 
		{
			logger.fatal("Unable to get User details : " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally
		{
			ps.close();
		}
		
    	return insertId;
    }
    
    public boolean updateAmenity() throws Exception
    {
    	boolean status = false;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		
		try 
		{
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "UPDATE " + this.tableName + " (Name = ?, Description = ?)" +
					" WHERE Id = ?";
			
			ps = connection.prepareStatement(query);
			
			// init
			ps.setString(1, this.name);
			ps.setString(2, this.description);
			ps.setInt(3, this.id);
			
			this.id = ps.executeUpdate();
		} 
		catch (Exception e) 
		{
			logger.fatal("Unable to get User details : " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally
		{
			ps.close();
		}
	
    
    	return status;	
    }
    
    public boolean deleteAmenity() throws Exception
    {
    	boolean status = false;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		
		try 
		{
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "DELETE " + this.tableName + " WHERE Id = ?";
			
			ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			
			ps.executeUpdate();
			status = true;
		} 
		catch (Exception e) 
		{
			logger.fatal("Unable to get User details : " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally
		{
			ps.close();
		}
	
    	return status;
    }
    
    // getter and setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isInitialized() {
		return isInitialized;
	}
	public void setInitialized(boolean isInitialized) {
		this.isInitialized = isInitialized;
	}

}
