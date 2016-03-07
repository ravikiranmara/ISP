package dataTransferObjects;

import java.util.Date;

class HotelReservationDTO
{
    int id;
    int hotelId;
    Date checkInDate;
    Date checkOutDate;
    int numberOfRooms;
    int userId;
    int res_status;
    String notes;
    int roomTypeId;
    
    public HotelReservationDTO()
    {
    	id = hotelId = numberOfRooms = userId = res_status = roomTypeId = -1;
    }
    
    public boolean getHotelReservationById(int id)
    {
    	boolean status = false;
    	
    	return status;
    }

    public boolean getHotelReservationByHotelId(int hotelId)
    {
    	boolean status = false;
    	
    	return status;
    }
    
    public boolean getHotelReservationByUserId(int userId)
    {
    	boolean status = false;
    	
    	return status;
    }
    
    public boolean getHotelReservationByHotelAndUserId(int hotelId, int userId)
    {
    	boolean status = false;
    	
    	return status;
    }
    
    public int addHotelReservation()
    {
    	int insertId = -1;
    	
    	return insertId;
    }
    
    public boolean updateHotelReservation()
    {
    	boolean status = false;
    	
    	return status;
    }
    
    public boolean deleteHotelReservation()
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
