package dataTransferObjects;

class AmenityDTO
{
    int id;
    String name;
    String description;
    
    public AmenityDTO()
    {
    	id = -1;
    	name = description = "";
	}
    
    public boolean getAmenitybyId(int id)
    {
    	boolean status = false;
    	
    	return status;
    }
    
    public boolean getAmenityByName(int id)
    {
    	boolean status = false;
    	
    	return status;
    }
    
    public int addAmenity()
    {
    	int insertId = -1;
    	
    	return insertId;
    }
    
    public boolean updateAmenity()
    {
    	boolean status = false;
    	
    	return status;	
    }
    
    public boolean deleteAmenity()
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
