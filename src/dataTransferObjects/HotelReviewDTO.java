package dataTransferObjects;

import java.util.Date;

class HotelReviewDTO
{
    int id;
    String reviewerName;
    Date reviewDate;
    int rating;
    String review;
    int hotelId;
    
    public HotelReviewDTO()
    {
    	id = rating = hotelId = -1;
    	reviewerName = review = "";
    }
    
    public boolean getHotelReviewById(int id)
    {
    	boolean status = false;
    	
    	return status;
    }

    public int addHotelReview()
    {
    	int insertId = -1;
    	
    	return insertId;
    }
    
    public boolean updateHotelReview()
    {
    	boolean status = false;
    	
    	return status;
    }
    
    public boolean deleteHotelReview()
    {
    	boolean status = false;
    	
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