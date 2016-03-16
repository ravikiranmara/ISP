package modelObject;

import java.sql.Date;
import java.util.ArrayList;

import utils.globals;

public class SearchParameter 
{
	String hotelname;
	String city;
	String state;
	Date checkinDate;
	Date checkoutDate;
	String roomType;
	int numRooms;
	ArrayList<String> amenityNames;
	
	public SearchParameter()
	{
		hotelname = city = state = "";
		checkinDate = checkoutDate = globals.invalidDate;
		numRooms = -1;
		roomType = "";
		amenityNames = null;
	}
	
	// getter and setter
	public String getHotelname() {
		return hotelname;
	}
	public ArrayList<String> getAmenityNames() {
		return amenityNames;
	}
	public void setAmenityNames(ArrayList<String> amenityNames) {
		this.amenityNames = amenityNames;
	}

	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Date getCheckinDate() {
		return checkinDate;
	}
	public void setCheckinDate(Date checkinDate) {
		this.checkinDate = checkinDate;
	}
	public Date getCheckoutDate() {
		return checkoutDate;
	}
	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public int getNumRooms() {
		return numRooms;
	}
	public void setNumRooms(int numRooms) {
		this.numRooms = numRooms;
	}
}
