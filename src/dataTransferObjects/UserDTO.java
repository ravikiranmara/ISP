package dataTransferObjects;

public class UserDTO 
{
	int id;
	String firstName;
	String lastName;
	String addressLine1;
	String addressLine2;
	String city;
	String state;
	String postalCode;
	int type;
	int status;
	String username;
	String password;
	boolean isInitialized;
	
	public UserDTO()
	{
		isInitialized = false;
		
		id = -1;
		firstName = "";
		lastName = "";
		addressLine1 = "";
		addressLine2 = "";
		city = "";
		postalCode = "";
		type = -1;
		status = -1;
		username = "";
		password = "";
	}
	
	public boolean getUserById(int id)
	{
		boolean status = false;
		
		return status;
	}
	
	public boolean getUserByUsername(int id)
	{
		boolean status = false;
		
		return status;
	}
	
	public int addNewUser()
	{
		int insertUid = -1;
		
		return insertUid;
	}
	
	public boolean updateUser()
	{
		boolean status = false;
		
		return status;
	}
	
	public boolean deleteUserById()
	{
		boolean status = false;
		
		return status;
	}
	
	
	// Getters and setters
	public boolean getIsInitialized()
	{
		return isInitialized;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddressLine1() {
		return addressLine1;
	}
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	public String getAddressLine2() {
		return addressLine2;
	}
	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
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
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
