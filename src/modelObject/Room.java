package modelObject;

import java.sql.Date;

public class Room 
{
	int id;
	int availableNumber;
	float pricePerNight;
	Date startDate;
	Date endDate;
	int roomTypeId;
	String roomType;
	String description;
	int hotelId;
	
	// getter and setter
	public int getHotelId() {
		return hotelId;
	}
	public int getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(int roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
