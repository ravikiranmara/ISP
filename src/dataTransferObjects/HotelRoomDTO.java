package dataTransferObjects;

import java.util.Date;

class HotelRoomDTO
{
    int id;
    int roomTypeId;
    int hotelId;
    int availableNumber;
    float pricePerNight;
    Date startDate;
    Date endDate;
    
    public HotelRoomDTO()
    {
    	id = roomTypeId = hotelId = availableNumber = -1;
    	pricePerNight = 0;
    }
    
    public boolean getHotelRoomById()
    {
    	boolean status = false;
    	
    	return status;
    }
    
    public boolean getHotelRoomByHotelId()
    {
    	boolean status = false;
    	
    	return status;
    }
    
    public int addHotelRoom()
    {
    	int insertId = -1;
    	
    	return insertId;
    }
    
    public boolean updateHotelRoom()
    {
    	boolean status = false;
    	
    	return status;
    }
    
    public boolean deleteHotelRoom()
    {
    	boolean status = false;
    	
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
