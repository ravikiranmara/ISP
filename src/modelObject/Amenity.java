package modelObject;

public class Amenity 
{
	int linkId;
	int amenityId;
	int hotelId;
	String name;
	String description;
	short amenityValue;
	
	public Amenity()
	{
		amenityId = 1;
		name = "";
		amenityValue = -1;
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
	public short getValue() {
		return amenityValue;
	}
	public void setValue(short value) {
		this.amenityValue = value;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
