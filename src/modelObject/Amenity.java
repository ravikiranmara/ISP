package modelObject;

public class Amenity 
{
	int id;
	String name;
	String description;
	boolean value;
	
	public Amenity()
	{
		id = 1;
		name = description = "";
		value = false;
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
	public boolean isValue() {
		return value;
	}
	public void setValue(boolean value) {
		this.value = value;
	}
	
}
