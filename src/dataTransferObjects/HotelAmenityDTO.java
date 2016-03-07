package dataTransferObjects;

class HotelAmenityDTO
{
    int id;
    int hotelId;
    int amenityId;
    int value;
    
    public HotelAmenityDTO()
    {
    	id = hotelId = amenityId = value = -1;
    }

    public boolean getHotelAmenityByHotelId(int hotelId)
    {
    	boolean status = false;
    	
    	return status;
    }
    
    public boolean getHotelAmenityById(int id)
    {
    	boolean status = false;
    	
    	return status;
    }
    
    public int addHotelAmenity()
    {
    	int insertId = -1;
    	
    	return insertId;
    }
    
    public boolean updateHotelAmenity()
    {
    	boolean status = false;
    	
    	return status;
    }
    
    public boolean deleteHotelAmenity()
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
	public int getAmenityId() {
		return amenityId;
	}
	public void setAmenityId(int amenityId) {
		this.amenityId = amenityId;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
    
    
}
