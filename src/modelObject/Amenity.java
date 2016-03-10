package modelObject;

public class Amenity 
{
	int linkId;
	int amenityId;
	int hotelId;
	String name;
	boolean value;
	
	public Amenity()
	{
		amenityId = 1;
		name = "";
		value = false;
	}
	
	// getter and setter
	public int getLinkId() {
		return linkId;
	}
	public void setLinkId(int linkId) {
		this.linkId = linkId;
	}
	public int getHotelId() {
		return hotelId;
	}
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	public int getamenityId() {
		return amenityId;
	}
	public void setamenityId(int id) {
		this.amenityId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isValue() {
		return value;
	}
	public void setValue(boolean value) {
		this.value = value;
	}
	
}
