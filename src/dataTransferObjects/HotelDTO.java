package dataTransferObjects;

class HotelDTO
{
    int id;
    String name;
	String city;
    String state;
    int ownerUserId;
    String description;
    String nearestPoints;
    String address;    
    
    public HotelDTO()
    {
    	id = -1;
    	name = city = state = description = address = "";
    	nearestPoints = "";
    }
    
    public int addHotel()
    {
    	int insertHotelId = -1;
    	
    	return insertHotelId;
    }
    
    public boolean getHotelById(int hotelId)
    {
    	boolean status = false;
    	
    	return status;
    }
    
    public boolean getHotelByNameAndOwner(String hotelName, int ownerId)
    {
    	boolean status = false;
    	
    	return status;
    }
    
    public boolean updateHotel()
    {
    	boolean status = true;
    	
    	return status;
    }
    
    public boolean deleteHotelById(int id)
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public int getOwnerUserId() {
		return ownerUserId;
	}
	public void setOwnerUserId(int ownerUserId) {
		this.ownerUserId = ownerUserId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNearestPoints() {
		return nearestPoints;
	}
	public void setNearestPoints(String nearestPoints) {
		this.nearestPoints = nearestPoints;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
