package dataTransferObjects;

import utils.dbContextSingleton;
import java.sql.*;
import java.util.ArrayList;

import org.apache.log4j.Logger;

public class HotelAmenityDTO
{
	String tableName = "HotelAmenities";
	int id;
    int hotelId;
    int amenityId;
    short value;
    boolean isInitialized;
    
    static Logger logger = Logger.getLogger(UserDTO.class.getName());
	
    public HotelAmenityDTO()
    {
    	this.initialize();
    }
    
    public void clear()
    {
    	this.initialize();
    }
    
    private void initialize()
    {
    	id = hotelId = amenityId = value = -1;
    	isInitialized = false;
    }
    
    public ArrayList<Integer> getHotelAmenityByHotelId(int hotelId) throws Exception
    {
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Integer> listOfId = null; 
		
		try 
		{
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "select Id" +
					" from " + this.tableName + " HotelId = ?";
			ps = connection.prepareStatement(query);
			ps.setInt(1, hotelId);
			
			rs = ps.executeQuery();
		
			listOfId = new ArrayList<Integer>();
			while(rs.next())
			{
				listOfId.add(rs.getInt("Id"));
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
	
    	return listOfId;
    }
    
    
    public boolean getHotelAmenityById(int id) throws Exception
    {
    	boolean status = false;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try 
		{
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "select Id, HotelId, AmenityId, Value" +
					" from " + this.tableName + " Id = ?";
			ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				this.id = rs.getInt("Id");
				this.amenityId = rs.getInt("AmenityId");
				this.hotelId = rs.getInt("HotelId");
				this.value = rs.getShort("Value");
				
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
    
    public int addHotelAmenity() throws Exception
    {
    	int insertId = -1;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		
		try 
		{
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "Insert Into " + this.tableName + " (HotelId, AmenityId, Value)" +
					" values (?, ?, ?)";
			
			ps = connection.prepareStatement(query);
			
			// init
			ps.setInt(1, this.hotelId);
			ps.setInt(2, this.amenityId);
			ps.setInt(3, this.value);
			
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
    
    public boolean updateHotelAmenity() throws Exception
    {
    	boolean status = false;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		
		try 
		{
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "Update " + this.tableName + " (HotelId = ?, AmenityId = ?, Value = ?)" +
					" WHERE Id = ?";
			
			ps = connection.prepareStatement(query);
			
			// init
			ps.setInt(1, this.hotelId);
			ps.setInt(2, this.amenityId);
			ps.setShort(3, this.value);
			ps.setInt(4, this.id);
			
			this.id = ps.executeUpdate();
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
    
    public boolean deleteHotelAmenity(int id) throws Exception
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
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public int getAmenityId() {
		return amenityId;
	}
	public void setAmenityId(int amenityId) {
		this.amenityId = amenityId;
	}
	public short getValue() {
		return value;
	}
	public void setValue(short value) {
		this.value = value;
	}
    
    
}
