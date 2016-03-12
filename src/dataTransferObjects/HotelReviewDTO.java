package dataTransferObjects;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import utils.dbContextSingleton;
import java.sql.*;
import java.util.ArrayList;

import org.apache.log4j.Logger;

public class HotelReviewDTO
{
    String tableName = "HotelReviews";
	int id;
    String reviewerName;
    Date reviewDate;
    int rating;
    String review;
    int hotelId;
    boolean isInitialized;
    
    static Logger logger = Logger.getLogger(HotelReviewDTO.class.getName());
	
    public HotelReviewDTO()
    {
    	this.initialize();
    }
    
    public void clear()
    {
    	this.initialize();
    }

    private void initialize()
    {
    	id = rating = hotelId = -1;
    	reviewerName = review = "";
    	isInitialized = false;
    }
    
    public ArrayList<Integer> getHotelReviewsForHotel(int hotelId) throws Exception
    {
    	ArrayList<Integer> tempList = null;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try 
		{
			logger.info("get hotel review list by hotelid dto");
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "select Id" +
					" from " + this.tableName +
					" WHERE HotelId = ?";
			ps = connection.prepareStatement(query);
			ps.setInt(1, hotelId);
			
			rs = ps.executeQuery();
			
			tempList = new ArrayList<Integer>();
			while(rs.next())
			{
				tempList.add(rs.getInt("Id"));
			}
		} 
		catch (Exception e) 
		{
			logger.fatal("unable to get hotel review list by hotelid dto: " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally
		{
			ps.close();
		}
	
		return tempList;
    }
    
    public boolean getHotelReviewById(int hid) throws Exception
    {
    	boolean status = false;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try 
		{
			logger.info("get hotel reviews by id dto");
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "select Id, ReviewerName, ReviewDate, Rating, " +
					"Review, HotelId " +
					" from " + this.tableName + 
					" WHERE Id = ?";
			ps = connection.prepareStatement(query);
			ps.setInt(1, hid);
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				this.id = rs.getInt("Id");
				this.reviewerName = rs.getString("ReviewerName");
				this.reviewDate = rs.getDate("ReviewDate");
				this.rating = rs.getInt("Rating");
				this.review = rs.getString("Review");
				this.hotelId = rs.getInt("HotelId");
				
				this.isInitialized = true;
				status = true;
			}
		} 
		catch (Exception e) 
		{
			logger.fatal("unable to get hotel reviews by id dto: " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally
		{
			ps.close();
		}
	
    	return status;
    }

    public int addHotelReview() throws Exception
    {
    	int insertId = -1;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		
		try 
		{
			logger.info("Add hotel review dto");
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "Insert Into " + this.tableName + 
					" (ReviewerName, ReviewDate, " +
					"Rating, Review, HotelId)" +
					" values (?, ?, " +
					"?, ?, ?)";
			
			ps = connection.prepareStatement(query);
			
			// init
			ps.setString(1, this.reviewerName);
			ps.setDate(2, this.reviewDate);
			ps.setInt(3, this.rating);
			ps.setString(4, this.review);
			ps.setInt(5, this.hotelId);
			
			this.id = ps.executeUpdate();
			insertId = this.id;
		} 
		catch (Exception e) 
		{
			logger.fatal("Unable to Add hotel review dto: " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally
		{
			ps.close();
		}
		
    	return insertId;
    }
    
    public boolean updateHotelReview() throws Exception
    {
    	boolean status = false;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		
		try 
		{
			logger.info("Update hotel review dto");
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "Update " + this.tableName + "" +
					" SET (ReviewerName = ?, ReviewDate = ?, " +
					"Rating = ?, Review = ?, HotelId = ?)" +
					" WHERE Id = ?";
			
			ps = connection.prepareStatement(query);
			
			// init
			ps.setString(1, this.reviewerName);
			ps.setDate(2, this.reviewDate);
			ps.setInt(3, this.rating);
			ps.setString(4, this.review);
			ps.setInt(5, this.hotelId);
			ps.setInt(6, this.id);
			
			this.id = ps.executeUpdate();
			isInitialized = true;
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
    
    public boolean deleteHotelReview(int hid) throws Exception
    {
    	boolean status = false;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		
		try 
		{
			logger.info("delte hotel review by id dto");
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "DELETE FROM " + this.tableName +
					" WHERE Id = ?";
			
			ps = connection.prepareStatement(query);
			ps.setInt(1, hid);
			
			ps.executeUpdate();
			status = true;
		} 
		catch (Exception e) 
		{
			logger.fatal("Unable to delte hotel review by id dto: " + e.getMessage());
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
	public String getReviewerName() {
		return reviewerName;
	}
	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
    
}