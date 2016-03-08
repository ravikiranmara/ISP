package modelObject;

public class Hotel 
{
    int id;
    String name;
    String city;
    String state;
    int ownerUserId;
    String description;
    String nearestPoints;
    String address;
	
    Amenity[] amenity;
    Room[] room;
    Review[] review;
    
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
	public Amenity[] getAmenity() {
		return amenity;
	}
	public void setAmenity(Amenity[] amenity) {
		this.amenity = amenity;
	}
	public Room[] getRoom() {
		return room;
	}
	public void setRoom(Room[] room) {
		this.room = room;
	}
	public Review[] getReview()
	{
		return review;
	}
	public void setReview(Review[] review)
	{
		this.review = review;
	}
}
