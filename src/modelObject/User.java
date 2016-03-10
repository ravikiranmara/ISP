package modelObject;

import java.util.ArrayList;

import utils.UserType;

public class User
{
	int userId; 
	String username;
	String password;
	UserType userType;
	String firstName;
	String lastName;
	String addressLine1;
	String addressLine2;
	String city;
	String state;
	String postalCode;
	int userStatus;
	boolean isInitialized;
	ArrayList<CreditCard> creditCard;
	
	public User()
	{
		isInitialized = false;
		userId = -1;
		username = password = "";
		firstName = lastName = "";
		addressLine1 = addressLine2 = "";
		city = state = postalCode = "";
		userStatus = -1;
		
		creditCard = null;
	}

	// getters and settes
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
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

	public int getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}

	public boolean isInitialized() {
		return isInitialized;
	}

	public void setInitialized(boolean isInitialized) {
		this.isInitialized = isInitialized;
	}

	public ArrayList<CreditCard> getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(ArrayList<CreditCard> creditCard) {
		this.creditCard = creditCard;
	}
	
}
