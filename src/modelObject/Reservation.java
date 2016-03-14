package modelObject;

import java.util.Date;

public class Reservation 
{
	int id;
	int hotelId;
	int userId;
	int reservationStatus;
	String notes;
	int roomTypeId;
	int numberOfRooms;
	Date checkInDate;
	Date checkOutDate;
	int transactionId;
	
	public Reservation()
	{
		hotelId = userId = 
				roomTypeId = numberOfRooms = -1;
		
		notes = "";
	}
	
	//  getters and setters
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getReservationStatus() {
		return reservationStatus;
	}
	public void setReservationStatus(int reservationStatus) {
		this.reservationStatus = reservationStatus;
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
	public int getNumberOfRooms() {
		return numberOfRooms;
	}
	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
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
}
