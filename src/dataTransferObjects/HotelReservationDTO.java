package dataTransferObjects;

import utils.dbContextSingleton;
import java.sql.*;
import org.apache.log4j.Logger;
import java.sql.Date;

class HotelReservationDTO
{
	String tableName = "HotelReservations"; 
	int id;
    int hotelId;
    Date checkInDate;
    Date checkOutDate;
    int numberOfRooms;
    int userId;
    int res_status;
    String notes;
    String reservationNumber;
    int roomTypeId;
    boolean isInitialized;
    
    static Logger logger = Logger.getLogger(UserDTO.class.getName());
	
    public HotelReservationDTO()
    {
    	id = hotelId = numberOfRooms = userId = res_status = roomTypeId = -1;
    	reservationNumber = notes = "";
    	isInitialized = false;
    }
    
    public boolean getHotelReservationById(int id) throws Exception
    {
    	boolean status = false;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try 
		{
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "select Id, HotelId, CheckInDate, CheckOutDate, " +
					"NumberOfRooms, ReservationNumber, UserId, Status, " +
					"Notes, RoomTypeId" +
					" from " + this.tableName + " WHERE Id = ?";
			ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				this.id = rs.getInt("Id");
				this.hotelId = rs.getInt("HotelId");
				this.checkInDate = rs.getDate("CheckInDate");
				this.checkOutDate = rs.getDate("CheckOutDate");
				this.numberOfRooms = rs.getInt("NumberOfRooms");
				this.res_status = rs.getInt("ReservationStatus");
				this.userId = rs.getInt("UserId");
				this.notes = rs.getString("Notes");
				this.roomTypeId = rs.getInt("RoomTypeId");
				this.reservationNumber = rs.getString("ReservationNumber");this.isInitialized = true;
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

    public int addHotelReservation() throws Exception
    {
    	int insertId = -1;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		
		try 
		{
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "Insert Into " + this.tableName + " (HotelId, CheckInDate, CheckOutDate, " +
					"NumberOfRooms, ReservationNumber, UserId, Status, " +
					"Notes, RoomTypeId)" +
					" values (?, ?, ?, " +
					"?, ?, ?, ?,  " +
					"?, ?)";
			ps = connection.prepareStatement(query);
			
			// init
			ps.setInt(1, this.hotelId);
			ps.setDate(2, this.checkInDate);
			ps.setDate(3, this.checkOutDate);
			ps.setInt(4, this.numberOfRooms);
			ps.setString(5, this.reservationNumber);
			ps.setInt(6, this.userId);
			ps.setInt(7, this.res_status);
			ps.setString(8, this.notes);
			ps.setInt(9, this.roomTypeId);

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
    
    public boolean updateHotelReservation(int id) throws Exception
    {
    	boolean status = false;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		
		try 
		{
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "Update " + this.tableName + " (HotelId = ?, CheckInDate = ?, CheckOutDate = ?, " +
					"NumberOfRooms = ?, ReservationNumber = ?, UserId = ?, Status = ?, " +
					"Notes = ?, RoomTypeId = ?)" +
					" WHERE ID = ?";
			
			ps = connection.prepareStatement(query);
			
			// init
			ps.setInt(1, this.hotelId);
			ps.setDate(2, this.checkInDate);
			ps.setDate(3, this.checkOutDate);
			ps.setInt(4, this.numberOfRooms);
			ps.setString(5, this.reservationNumber);
			ps.setInt(6, this.userId);
			ps.setInt(7, this.res_status);
			ps.setString(8, this.notes);
			ps.setInt(9, this.roomTypeId);
			ps.setInt(10, id);
			
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
    
    public boolean deleteHotelReservation() throws Exception
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
	public Date getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}
	public Date getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public int getNumberOfRooms() {
		return numberOfRooms;
	}
	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userid) {
		this.userId = userid;
	}
	public int getStatus() {
		return res_status;
	}
	public void setStatus(int status) {
		this.res_status = status;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public int getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(int roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
}
