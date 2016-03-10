package dataTransferObjects;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import utils.dbContextSingleton;
import java.sql.*;

import org.apache.log4j.Logger;

public class HotelRoomDTO
{
	String tableName = "HotelRooms";
	int id;
    int roomTypeId;
    int hotelId;
    int availableNumber;
    float pricePerNight;
    Date startDate;
    Date endDate;
    boolean isInitialized;
    
    static Logger logger = Logger.getLogger(UserDTO.class.getName());
    
    public HotelRoomDTO()
    {
    	id = roomTypeId = hotelId = availableNumber = -1;
    	pricePerNight = 0;
    	isInitialized = false;
    }
    
    public boolean getHotelRoomById(int id) throws Exception
    {
    	boolean status = false;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try 
		{
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "select Id, RoomTypeId, HotelId, " +
					"AvailableNumber, PricePerNight, StartDate, EndDate" +
					" from " + this.tableName + " Id = ?";
			ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				this.id = rs.getInt("Id");
				this.roomTypeId = rs.getInt("RoomTypeId");
				this.hotelId = rs.getInt("HotelId");
				this.availableNumber = rs.getInt("AvailableNumber");
				this.pricePerNight = rs.getFloat("PricePerNight");
				this.startDate = rs.getDate("StartDate");
				this.endDate = rs.getDate("EndDate");

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
        
    public int addHotelRoom() throws Exception
    {
    	int insertId = -1;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		
		try 
		{
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "Insert Into " + this.tableName + " (RoomTypeId, HotelId, " +
					"AvailableNumber, PricePerNight, StartDate, EndDate)" +
					" values (?, ?, " +
					"?, ?, ?, ?)";
			
			ps = connection.prepareStatement(query);
			
			// init
			ps.setInt(1, this.roomTypeId);
			ps.setInt(2, this.hotelId);
			ps.setInt(3, this.availableNumber);
			ps.setFloat(4, this.pricePerNight);
			ps.setDate(5, this.startDate);
			ps.setDate(6, this.endDate);
			
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
    
    public boolean updateHotelRoom() throws Exception
    {
    	boolean status = false;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		
		try 
		{
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "UPDATE " + this.tableName + " (RoomTypeId = ?, HotelId = ?, " +
					"AvailableNumber = ?, PricePerNight = ?, StartDate = ?, EndDate = ?)" +
					" WHERE Id = ?";
			
			ps = connection.prepareStatement(query);
			
			// init
			ps.setInt(1, this.roomTypeId);
			ps.setInt(2, this.hotelId);
			ps.setInt(3, this.availableNumber);
			ps.setFloat(4, this.pricePerNight);
			ps.setDate(5, this.startDate);
			ps.setDate(6, this.endDate);
			ps.setInt(7, this.id);
			
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
    
    public boolean deleteHotelRoom() throws Exception
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
    
    // getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(int roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public int getAvailableNumber() {
		return availableNumber;
	}
	public void setAvailableNumber(int availableNumber) {
		this.availableNumber = availableNumber;
	}
	public float getPricePerNight() {
		return pricePerNight;
	}
	public void setPricePerNight(float pricePerNight) {
		this.pricePerNight = pricePerNight;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
}
