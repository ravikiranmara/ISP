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
    
    static Logger logger = Logger.getLogger(HotelAmenityDTO.class.getName());
	
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
			logger.info("get list of amenity for hotel by hotelid dto");
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "SELECT Id" +
					" FROM " + this.tableName +
					" WHERE HotelId = ?";
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
			logger.info("unable to get list of amenity for hotel by hotelid dto: " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally
		{
			ps.close();
		}
	
    	return listOfId;
    }
    
    
    public boolean getHotelAmenityById(int hid) throws Exception
    {
    	boolean status = false;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try 
		{
			logger.info("Get hotel amenity by id dto");
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "SELECT Id, HotelId, AmenityId, Value" +
					" FROM " + this.tableName +
					" WHERE Id = ?";
			ps = connection.prepareStatement(query);
			ps.setInt(1, hid);
			
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
			logger.fatal("unable to Get hotel amenity by id dto: " + e.getMessage());
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
			logger.info("add hotel amenity");
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "Insert Into " + this.tableName + " (HotelId, AmenityId, Value)" +
					" values (?, ?, ?)";
			
			ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			// init
			ps.setInt(1, this.hotelId);
			ps.setInt(2, this.amenityId);
			ps.setShort(3, this.value);
			
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next())
			{
			    insertId=rs.getInt(1);
			}
			this.id = insertId;
		} 
		catch (Exception e) 
		{
			logger.fatal("unable to Add hotel amenity dto: " + e.getMessage());
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
			logger.info("Update hotel amenity");
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "Update " + this.tableName + 
					" SET (HotelId = ?, AmenityId = ?, Value = ?)" +
					" WHERE Id = ?";
			
			ps = connection.prepareStatement(query);
			
			// init
			ps.setInt(1, this.hotelId);
			ps.setInt(2, this.amenityId);
			ps.setShort(3, this.value);
			ps.setInt(4, this.id);
			
			ps.executeUpdate();
			status = true;
		} 
		catch (Exception e) 
		{
			logger.fatal("unable to update hotel amenity dto: " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally
		{
			ps.close();
		}
		
    	return status;
    }
    
    public boolean deleteHotelAmenity(int did) throws Exception
    {
    	boolean status = false;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		
		try 
		{
			logger.info("delete hotel amenity dto");
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
			logger.fatal("Unable to delete hotel amenity dto: " + e.getMessage());
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
