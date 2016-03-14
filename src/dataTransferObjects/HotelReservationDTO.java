package dataTransferObjects;

import utils.dbContextSingleton;
import java.sql.*;
import org.apache.log4j.Logger;
import java.sql.Date;
import java.util.ArrayList;

public class HotelReservationDTO
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
    
    static Logger logger = Logger.getLogger(HotelReservationDTO.class.getName());
	
    public HotelReservationDTO()
    {
    	this.initialize();
    }

    private void initialize()
    {
    	id = hotelId = numberOfRooms = userId = res_status = roomTypeId = -1;
    	reservationNumber = notes = "";
    	isInitialized = false;

    	return;
    }
    
    public ArrayList<Integer> getHotelReservationByUserId(int uid) throws Exception
    {
    	ArrayList<Integer> templist = null;
		Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try 
		{
			logger.info("get hotel reservation by id dto");
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "SELECT Id" +
					" FROM " + this.tableName +
					" WHERE UserId = ?";
			ps = connection.prepareStatement(query);
			ps.setInt(1, uid);
			rs = ps.executeQuery();
	
			templist = new ArrayList<Integer>();
			while(rs.next())
			{
				templist.add(rs.getInt("Id"));
			}
		}
		catch (Exception e) 
		{
			logger.fatal("unable to get reservations for user dto: " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally
		{
			ps.close();
		}
		
		return templist;
	}
	
    public ArrayList<Integer> getHotelReservationByHotelId(int hid) throws Exception
    {
    	ArrayList<Integer> templist = null;
		Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try 
		{
			logger.info("get hotel reservation by id dto");
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "SELECT Id" +
					" FROM " + this.tableName +
					" WHERE HotelId = ?";
			ps = connection.prepareStatement(query);
			ps.setInt(1, hid);
			rs = ps.executeQuery();
	
			templist = new ArrayList<Integer>();
			while(rs.next())
			{
				templist.add(rs.getInt("Id"));
			}
		}
		catch (Exception e) 
		{
			logger.fatal("unable to get reservations for user dto: " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally
		{
			ps.close();
		}
		
		return templist;
	}
	
	public boolean getHotelReservationById(int hid) throws Exception
    {
    	boolean status = false;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try 
		{
			logger.info("get hotel reservation by id dto");
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "SELECT Id, HotelId, CheckInDate, CheckOutDate, " +
					"NumberOfRooms, ReservationNumber, UserId, Status, " +
					"Notes, RoomTypeId" +
					" FROM " + this.tableName +
					" WHERE Id = ?";
			ps = connection.prepareStatement(query);
			ps.setInt(1, hid);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				this.id = rs.getInt("Id");
				this.hotelId = rs.getInt("HotelId");
				this.checkInDate = rs.getDate("CheckInDate");
				this.checkOutDate = rs.getDate("CheckOutDate");
				this.numberOfRooms = rs.getInt("NumberOfRooms");
				this.res_status = rs.getInt("Status");
				this.userId = rs.getInt("UserId");
				this.notes = rs.getString("Notes");
				this.roomTypeId = rs.getInt("RoomTypeId");
				this.reservationNumber = rs.getString("ReservationNumber");
				this.isInitialized = true;
				status = true;
			}
		} 
		catch (Exception e) 
		{
			logger.fatal("Unable to get hotel reservation by id dto: " + e.getMessage());
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
			logger.info("add hotel reservation dto");
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
			logger.fatal("Unable to add hotel reservation dto: " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally
		{
			ps.close();
		}
		
    	return insertId;
    }
    
    public boolean updateHotelReservation() throws Exception
    {
    	boolean status = false;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		
		try 
		{
			logger.info("update hotel reservation dto");
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "Update " + this.tableName + 
					" SET (HotelId = ?, CheckInDate = ?, CheckOutDate = ?, " +
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
			logger.fatal("Unable to update hotel reservation dto: " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally
		{
			ps.close();
		}
		
    	return status;
    }
    
    public boolean deleteHotelReservation(int did) throws Exception
    {
    	boolean status = false;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		
		try 
		{
			logger.info("delete hotel reservation");
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "DELETE FROM " + this.tableName +
					" WHERE Id = ?";
			
			ps = connection.prepareStatement(query);
			ps.setInt(1, did);
			
			ps.executeUpdate();
			status = true;
		} 
		catch (Exception e) 
		{
			logger.fatal("Unable to delete hotel reservation: " + e.getMessage());
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
