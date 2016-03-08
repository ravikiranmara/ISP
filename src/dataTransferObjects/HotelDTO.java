package dataTransferObjects;

import utils.dbContextSingleton;
import java.sql.*;

import org.apache.log4j.Logger;

class HotelDTO
{
	String tableName = "Hotels";
    int id;
    String name;
	String city;
    String state;
    int ownerUserId;
    String description;
    String nearestPoints;
    String address; 
    boolean isInitialized;
    
    static Logger logger = Logger.getLogger(UserDTO.class.getName());
	
    
    public HotelDTO()
    {
    	id = -1;
    	name = city = state = description = address = "";
    	nearestPoints = "";
    	isInitialized = false;
    }
    
    public int addHotel() throws Exception
    {
    	int insertHotelId = -1;
    	
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		
		try 
		{
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "Insert Into " + this.tableName + " (Name, City, " +
					"State, OwnerUserId, Description, NearestPoints, Address)" +
					" values (?, ?, " +
					"?, ?, ?, ?, ?)";
			
			ps = connection.prepareStatement(query);
		
			ps.setString(1, this.name);
			ps.setString(2, this.city);
			ps.setString(3, this.state);
			ps.setInt(4, this.ownerUserId);
			ps.setString(5, this.description);
			ps.setString(6, this.nearestPoints);
			ps.setString(7, this.address);

			this.id = ps.executeUpdate();
			insertHotelId = this.id;
		} 
		catch (Exception e) 
		{
			logger.fatal("Unable to insert Hotel details : " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally
		{
			ps.close();
		}
			
    	return insertHotelId;
    }
    
    public boolean getHotelById(int hotelId) throws Exception
    {
    	boolean status = false;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try 
		{
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "select Id, Name, City, State, " +
					"OwnerUserId, Description, NearestPoints, Address" +
					" from " + this.tableName + 
					" WHERE Id = ?";
			
			ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				this.id = rs.getInt("Id");
				this.name = rs.getString("Name");
				this.city = rs.getString("City");
				this.state = rs.getString("State");
				this.description = rs.getString("Description");
				this.nearestPoints = rs.getString("NearestPoints");
				this.address = rs.getString("Address");
				this.ownerUserId = rs.getInt("OwnerUserId");
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
    
    public boolean updateHotel(int id) throws Exception
    {
    	boolean status = false;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		
		try 
		{
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "Insert " + this.tableName + " (Name = ?, City= ?, " +
					"State= ?, OwnerUserId= ?, Description= ?, NearestPoints= ?, Address= ?)" +
					" WHERE Id = ?";
			
			ps = connection.prepareStatement(query);
		
			ps.setString(1, this.name);
			ps.setString(2, this.city);
			ps.setString(3, this.state);
			ps.setInt(4, this.ownerUserId);
			ps.setString(5, this.description);
			ps.setString(6, this.nearestPoints);
			ps.setString(7, this.address);
			ps.setInt(8, id);
			
			this.id = ps.executeUpdate();
			status = true;
		} 
		catch (Exception e) 
		{
			logger.fatal("Unable to insert Hotel details : " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally
		{
			ps.close();
		}
		
    	
    	return status;
    }
    
    public boolean deleteHotelById(int id) throws Exception
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getOwnerUserId() {
		return ownerUserId;
	}
	public void setOwnerUserId(int ownerUserId) {
		this.ownerUserId = ownerUserId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNearestPoints() {
		return nearestPoints;
	}
	public void setNearestPoints(String nearestPoints) {
		this.nearestPoints = nearestPoints;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
