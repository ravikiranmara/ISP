package modelObject;

import java.sql.Date;

import utils.globals;

public class ShoppingCartItem {
	int itemid;
	int hotelid;
	int userid;
	int numrooms;
	int roomTypeId;
	Date checkInDate;
	Date checkOutDate;
	float pricePerRoom;
	
	public ShoppingCartItem()
	{
		itemid = hotelid = userid = numrooms = roomTypeId = -1;
		checkInDate = checkOutDate = globals.invalidDate;
		pricePerRoom = 0;
		
		return;
	}


	// getters and setters	
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public float getPricePerRoom() {
		return pricePerRoom;
	}
	public void setPricePerRoom(float pricePerRoom) {
		this.pricePerRoom = pricePerRoom;
	}
	public int getHotelid() {
		return hotelid;
	}
	public void setHotelid(int hotelid) {
		this.hotelid = hotelid;
	}
	public int getNumrooms() {
		return numrooms;
	}
	public void setNumrooms(int numrooms) {
		this.numrooms = numrooms;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(int roomTypeId) {
		this.roomTypeId = roomTypeId;
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
