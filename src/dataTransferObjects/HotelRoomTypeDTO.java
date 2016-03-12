package dataTransferObjects;

import utils.dbContextSingleton;
import java.sql.*;
import java.util.HashMap;

import org.apache.log4j.Logger;

public class HotelRoomTypeDTO
{
    String tableName = "HotelRoomType";
	int id;
    String roomType;
    String description;
    boolean isInitialized;
    
    static Logger logger = Logger.getLogger(UserDTO.class.getName());
	
    public HotelRoomTypeDTO()
    {
    	this.initialize();
    }

    public void initialize(Integer id, String[] roomDesc)
    {
    	this.id = id;
    	this.roomType = roomDesc[0];
    	this.description = roomDesc[1];
    	
    	return;
    }
    		
    
    public void clear()
    {
    	this.initialize();
    }
    
    private void initialize()
    {
    	id = -1;
    	isInitialized = false;
    	roomType = description = "";
    }
    
    public HashMap<Integer, String[]> getAllHotelRoomType() throws Exception
    {
    	HashMap<Integer, String[]> maplist = null;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try 
		{
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "select Id, roomType, Description" +
					" from " + this.tableName;
			ps = connection.prepareStatement(query);
			rs = ps.executeQuery();
			
			int tempId;
			String tempRoomType, tempDescription;
			maplist = new HashMap<Integer, String[]>();
			while(rs.next())
			{
				tempId = rs.getInt("Id");
				tempRoomType = rs.getString("RoomType");
				tempDescription = rs.getString("Description");

				maplist.put(tempId, new String[]{tempRoomType, tempDescription});
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
		
    	return maplist;
    }
    
    public boolean getHotelRoomTypeById(int id) throws Exception
    {
    	boolean status = false;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try 
		{
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "select Id, roomType, Description" +
					" from " + this.tableName + 
					" WHERE Id = ?";
			ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				this.id = rs.getInt("Id");
				this.roomType = rs.getString("RoomType");
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
    
    public int addHotelRoomType() throws Exception
    {
    	int insertId = -1;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		
		try 
		{
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "Insert Into " + this.tableName + " (RoomType, Description)" +
					" values (?, ?)";
			
			ps = connection.prepareStatement(query);
			
			// init
			ps.setString(1, this.roomType);
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
    
    public boolean updateHotelRoomType() throws Exception
    {
    	boolean status = false;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		
		try 
		{
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "UPDATE " + this.tableName + " (RoomType = ?, Description = ?)" +
					" WHERE Id = ?";
			
			ps = connection.prepareStatement(query);
			
			// init
			ps.setString(1, this.roomType);
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
    
    public boolean deleteHotelRoomType(int id) throws Exception
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
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
    
}
