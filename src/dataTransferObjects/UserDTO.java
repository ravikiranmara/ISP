package dataTransferObjects;

import utils.dbContextSingleton;
import java.sql.*;

import org.apache.log4j.Logger;

public class UserDTO 
{
	String tableName; 
	int id;
	String firstName;
	String lastName;
	String addressLine1;
	String addressLine2;
	String city;
	String state;
	String postalCode;
	int type;
	int userStatus;
	String username;
	String password;
	boolean isInitialized;

	static Logger logger = Logger.getLogger(UserDTO.class.getName());
	
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
		userStatus = -1;
		username = "";
		password = "";
		tableName = "Users";
	}
	
	public boolean getUserById(int id) throws Exception
	{
		boolean status = false;
		Connection connection = null;
		String query = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try 
		{
			logger.info("get user by id dto");
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "select Id, FirstName, LastName, AddressLine1, AddressLine2, City, State, PostalCode, " +
					"Status, Type, UserName, Password" +
					" from " + this.tableName + 
					" WHERE Id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				System.out.println("got result");
				this.id = resultSet.getInt("Id");
				this.firstName = resultSet.getString("FirstName");
				this.lastName = resultSet.getString("LastName");
				this.addressLine1 = resultSet.getString("AddressLine1");
				this.addressLine2 = resultSet.getString("AddressLine2");
				this.city = resultSet.getString("City");
				this.state = resultSet.getString("State");
				this.postalCode = resultSet.getString("PostalCode");
				this.type = resultSet.getInt("Type");
				this.userStatus = resultSet.getInt("Status");
				this.username = resultSet.getString("UserName");
				this.password = resultSet.getString("Password");
				this.isInitialized = true;
				status = true;
			}
		} 
		catch (Exception e) 
		{
			logger.fatal("Unable to get User details : " + e.getMessage());
			System.out.println("exception");
			e.printStackTrace();
			throw e;
		} 
		finally
		{
			preparedStatement.close();
		}
		
		return status;
	}
	
	public boolean getUserByUsername(String username) throws Exception
	{
		boolean status = false;
		Connection connection = null;
		String query = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		try 
		{
			logger.info("get user by username dto");
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "SELECT Id, FirstName, LastName, AddressLine1, AddressLine2, City, State, PostalCode, " +
					"Status, Type, UserName, Password" +
					" FROM " + this.tableName +
					" WHERE UserName = ?";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				this.id = resultSet.getInt("Id");
				this.firstName = resultSet.getString("FirstName");
				this.lastName = resultSet.getString("LastName");
				this.addressLine1 = resultSet.getString("AddressLine1");
				this.addressLine2 = resultSet.getString("AddressLine2");
				this.city = resultSet.getString("City");
				this.state = resultSet.getString("State");
				this.postalCode = resultSet.getString("PostalCode");
				this.type = resultSet.getInt("Type");
				this.userStatus = resultSet.getInt("Status");
				this.username = resultSet.getString("UserName");
				this.password = resultSet.getString("Password");
				this.isInitialized = true;
				status = true;
			}
		} 
		catch (Exception e) 
		{
			logger.fatal("Unable to get User details by username dto : " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally
		{
			preparedStatement.close();
		}
		
		return status;
	}
	
	public int addNewUser() throws Exception
	{
		int insertId = -1;
		Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		
		try 
		{
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "Insert Into " + this.tableName + " (FirstName, LastName, " +
					"AddressLine1, AddressLine2, City, State, PostalCode, " +
					"Status, Type, Username, Password)" +
					" values (?, ?, " +
					"?, ?, ?, ?, ?, " +
					"?, ?, ?, ?)";
			ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			// init
			ps.setString(1, this.firstName);
			ps.setString(2, this.lastName);
			ps.setString(3, this.addressLine1);
			ps.setString(4, this.addressLine2);
			ps.setString(5, this.city);
			ps.setString(6, this.state);
			ps.setString(7, this.postalCode);
			ps.setInt(8, this.userStatus);
			ps.setInt(9, this.type);
			ps.setString(10, username);
			ps.setString(11, this.password);
			
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next())
			{
			    insertId=rs.getInt(1);
			}
			this.id = insertId;
		} 
		catch (Exception e) 
		{
			logger.fatal("Unable to get User details : " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally
		{
			ps.close();
		}
		
		return insertId;
	}
	
	public boolean updateUser() throws Exception
	{
		boolean status = false;
		Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		
		try 
		{
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "UPDATE " + this.tableName + 
					" SET FirstName = ?, LastName = ?, " +
					"AddressLine1 = ?, AddressLine2 = ?, City = ?, State = ?, PostalCode = ?, " +
					"Status = ?, Type = ?, Username = ?, Password = ?" +
					" WHERE Id = ?";
			
			ps = connection.prepareStatement(query);
			
			// init
			ps.setString(1, this.firstName);
			ps.setString(2, this.lastName);
			ps.setString(3, this.addressLine1);
			ps.setString(4, this.addressLine2);
			ps.setString(5, this.city);
			ps.setString(6, this.state);
			ps.setString(7, this.postalCode);
			ps.setInt(8, this.userStatus);
			ps.setInt(9, this.type);
			ps.setString(10, username);
			ps.setString(11, this.password);
			ps.setInt(12, this.id);
			
			ps.executeUpdate();
			status = true;
		} 
		catch (Exception e) 
		{
			logger.fatal("Unable to get User details : " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally
		{
			ps.close();
		}
	
		return status;
	}
	
	public boolean deleteUserById(int did) throws Exception
	{
		boolean status = false;
		Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		
		try 
		{
			logger.info("delete user by id dto");
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "DELETE FROM " + this.tableName + " WHERE Id = ?";
			
			ps = connection.prepareStatement(query);
			ps.setInt(1, did);
			
			
			ps.executeUpdate();
			status = true;
		} 
		catch (Exception e) 
		{
			logger.fatal("Unable to delete User dto: " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally
		{
			ps.close();
		}
	
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
		return userStatus;
	}
	public void setStatus(int status) {
		this.userStatus = status;
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
