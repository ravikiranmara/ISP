package dataTransferObjects;

import utils.dbContextSingleton;
import java.sql.*;
import java.util.ArrayList;

import org.apache.log4j.Logger;

public class HotelDTO
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
    
    static Logger logger = Logger.getLogger(HotelDTO.class.getName());
	
    public HotelDTO()
    {
    	this.initialize();
    }

    public void clear()
    {
    	this.initialize();
    }
    
    void initialize()
    {
    	id = -1;
    	name = city = state = description = address = "";
    	nearestPoints = "";
    	isInitialized = false;
    	return;
    }
    
    public int addHotel() throws Exception
    {
    	int insertHotelId = -1;
    	
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		
		try 
		{
			logger.info("Insert hotel details");
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
			logger.info("get hotel by id dto");
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "select Id, Name, City, State, " +
					"OwnerUserId, Description, NearestPoints, Address" +
					" from " + this.tableName + 
					" WHERE Id = ?";
			
			ps = connection.prepareStatement(query);
			ps.setInt(1, hotelId);
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
			logger.fatal("Unable to get hotel by id dto: " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally
		{
			ps.close();
		}
		
    	return status;
    }
    
    public ArrayList<Integer> getHotelByOwnerId(int ownerId) throws Exception
    {
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Integer> hlist = null;
		
		try 
		{
			logger.info("get hotel by owner id dto");
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "select Id" +
					" from " + this.tableName + 
					" WHERE OwnerId = ?";
			
			ps = connection.prepareStatement(query);
			ps.setInt(1, ownerId);
			rs = ps.executeQuery();
			
			hlist = new ArrayList<Integer>();
			while(rs.next())
			{
				hlist.add(rs.getInt("Id"));
			}
		} 
		catch (Exception e) 
		{
			logger.fatal("Unable to get hotel by id dto: " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally
		{
			ps.close();
		}
		
    	return hlist;
    }
    

    public ArrayList<Integer> getAllHotel() throws Exception
    {
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Integer> hlist = null;
		
		try 
		{
			logger.info("get hotel by owner id dto");
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "select Id" +
					" from " + this.tableName;
			
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			hlist = new ArrayList<Integer>();
			while(rs.next())
			{
				hlist.add(rs.getInt("Id"));
			}
		} 
		catch (Exception e) 
		{
			logger.fatal("Unable to get hotel by id dto: " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally
		{
			ps.close();
		}
		
    	return hlist;
    }
    
    
    public boolean updateHotel() throws Exception
    {
    	boolean status = false;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		
		try 
		{
			logger.info("update hotel dto");
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "UPDATE " + this.tableName + 
					" SET (Name = ?, City= ?, " +
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
			ps.setInt(8, this.id);
			
			this.id = ps.executeUpdate();
			status = true;
		} 
		catch (Exception e) 
		{
			logger.fatal("Unable to update Hotel details dto: " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally
		{
			ps.close();
		}
		
    	return status;
    }
    
    public boolean deleteHotelById(int did) throws Exception
    {
    	boolean status = false;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		
		try 
		{
			logger.info("Delete by hotel id dto");
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "DELETE  FROM " + this.tableName +
					" WHERE Id = ?";
			
			ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			
			ps.executeUpdate();
			status = true;
		} 
		catch (Exception e) 
		{
			logger.fatal("Unable to delte hotel by id dto: " + e.getMessage());
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
