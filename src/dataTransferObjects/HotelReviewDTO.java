package dataTransferObjects;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import utils.dbContextSingleton;
import java.sql.*;

import org.apache.log4j.Logger;

class HotelReviewDTO
{
    String tableName = "HotelReviews";
	int id;
    String reviewerName;
    Date reviewDate;
    int rating;
    String review;
    int hotelId;
    boolean isInitialized;
    
    static Logger logger = Logger.getLogger(UserDTO.class.getName());
	
    public HotelReviewDTO()
    {
    	id = rating = hotelId = -1;
    	reviewerName = review = "";
    	isInitialized = false;
    }
    
    public boolean getHotelReviewById(int id) throws Exception
    {
    	boolean status = false;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try 
		{
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "select Id, ReviewerName, ReviewDate, Rating, " +
					"Review, HotelId " +
					" from " + this.tableName + " Id = ?";
			ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			
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

    public int addHotelReview() throws Exception
    {
    	int insertId = -1;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		
		try 
		{
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "Insert Into " + this.tableName + " (ReviewerName, ReviewDate, " +
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
    
    public boolean updateHotelReview() throws Exception
    {
    	boolean status = false;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		
		try 
		{
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "Update " + this.tableName + " (ReviewerName = ?, ReviewDate = ?, " +
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
    
    public boolean deleteHotelReview() throws Exception
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