package dataTransferObjects;

class HotelRoomTypeDTO
{
    int id;
    String roomType;
    String description;
    
    public HotelRoomTypeDTO()
    {
    	id = -1;
    	
    	roomType = description = "";
    }
    
    public boolean getHotelRoomTypeByRoomType(String roomType)
    {
    	boolean status = false;
    	
    	return status;
    }
    
    public boolean getHotelRoomTypeById(int id)
    {
    	boolean status = false;
    	
    	return status;
    }
    
    public int addHotelRoomType()
    {
    	int insertId = -1;
    	
    	return insertId;
    }
    
    public boolean updateHotelRoomType()
    {
    	boolean status = false;
    	
    	return status;
    }
    
    public boolean deleteHotelRoomType()
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
