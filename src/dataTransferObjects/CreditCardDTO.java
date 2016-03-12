package dataTransferObjects;

import utils.dbContextSingleton;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class CreditCardDTO
{
	String tableName = "CreditCards";
    int id;
    String cardHolderName;
    String creditCardNumber;
    float balance;
    String cardNickName;
    String cvv;
    int userId;
    boolean isInitialized;
    
    static Logger logger = Logger.getLogger(CreditCardDTO.class.getName());
	
    private void initialize()
    {
    	userId = id = -1;
    	cardHolderName = creditCardNumber = 
    			cardNickName = cvv = "";
    	balance = -1;
    	isInitialized  = false;
    	
    	return;
    }
    
    public CreditCardDTO()
    {
    	this.initialize();
    	
    	return;
    }
    
    public void Clear()
    {
    	this.initialize();
    }
    
    public ArrayList<String> getCreditCardNumbersForUser(int userid) throws Exception
    {
    	ArrayList<String> cardNumberList = null;
    	
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try 
		{
			logger.info("get all creditcard numbers for user dto");
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "SELECT CreditCardNumber " +
					" FROM " + this.tableName +
					" WHERE UserId = ?";
			
			ps = connection.prepareStatement(query);
			ps.setInt(1, userId);
			
			rs = ps.executeQuery();
			
			cardNumberList = new ArrayList<String>();
			while (rs.next())
			{
				cardNumberList.add(rs.getString("CreditCardNumber"));
			}
		}
		catch (Exception e) 
		{
			logger.fatal("Unable to get CreditCard details : " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally
		{
			ps.close();
		}

    	return cardNumberList;
    }
    
    public boolean getCreditCardById(int id) throws Exception
    {
    	boolean status = false;
    	
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try 
		{
			logger.info("Get credit card by id dto");
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "SELECT Id, CardholderName, Balance, CardNickName, " +
					"CreditCardNumber, UserId, CVV" +
					" FROM " + this.tableName + 
					" WHERE Id = ?";
					
			ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
		
			while (rs.next())
			{
				this.id = rs.getInt("Id");
				this.cardHolderName = rs.getString("CardholderName");
				this.creditCardNumber = rs.getString("CreditCardNumber");
				this.cardNickName = rs.getString("CardNickName");
				this.userId = rs.getInt("UserId");
				this.cvv = rs.getString("CVV");
				this.balance = rs.getFloat("Balance");
				
				this.isInitialized = true;
				status = true;
			}
		}
		catch (Exception e) 
		{
			logger.fatal("Unable to get CreditCard details dto : " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		
    	return status;
    }
    
    public boolean getCreditCardByCreditCardNumber(String cardNumber) throws Exception
    {
    	boolean status = false;
    	
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try 
		{
			logger.info("Get credit card by card number dto");
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "select Id, CardholderName, Balance, CardNickName," +
					"CreditCardNumber, UserId, CVV " +
					" FROM " + this.tableName + 
					" WHERE CreditCardNumber = ?";
					
			ps = connection.prepareStatement(query);
			ps.setString(1, cardNumber);
			
			rs = ps.executeQuery();
		
			while (rs.next())
			{
				this.id = rs.getInt("Id");
				this.cardHolderName = rs.getString("CardholderName");
				this.creditCardNumber = rs.getString("CreditCardNumber");
				this.cardNickName = rs.getString("CardNickName");
				this.userId = rs.getInt("UserId");
				this.cvv = rs.getString("CVV");
				this.balance = rs.getFloat("Balance");
				
				this.isInitialized = true;
				status = true;
			}
		}
		catch (Exception e) 
		{
			logger.fatal("Unable to get CreditCard by cardnumber dto: " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		
    	return status;
    }
    
    public int addCreditCard() throws Exception
    {
    	int insertId = -1;
    	
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		
		try 
		{
			logger.info("add credit card dto");
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "Insert Into " + this.tableName + " (CardholderName, CreditCardNumber, " +
					"Balance, CardNickName, UserId, CVV" +
					" Values (?, ?, " +
					"?, ?, ?, ?)";
			
			ps = connection.prepareStatement(query);
			
			ps.setString(1, this.cardHolderName);
			ps.setString(2, this.creditCardNumber);
			ps.setFloat(3, this.balance);
			ps.setString(4, this.cardNickName);
			ps.setInt(5, this.userId);
			ps.setString(6, this.cvv);
			
			this.id = ps.executeUpdate();
			insertId = this.id;
		}
		catch (Exception e) 
		{
			logger.fatal("Unable to add Credit card dto: " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally
		{
			ps.close();
		}
    	
    	return insertId;
    }
    
    public boolean updateCreditCard() throws Exception
    {
    	boolean status = false;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		
		try 
		{
			logger.info("update credit card dto");
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "Update " + this.tableName + 
					" SET CardholderName = ?, CreditCardNumber = ?, " +
					"Balance = ?, CardNickName = ?, UserId = ?, CVV = ?" +
					" WHERE Id = ?";
			
			ps = connection.prepareStatement(query);
			
			ps.setString(1, this.cardHolderName);
			ps.setString(2, this.creditCardNumber);
			ps.setFloat(3, this.balance);
			ps.setString(4, this.cardNickName);
			ps.setInt(5, this.userId);
			ps.setString(6, this.cvv);
			ps.setInt(7, id);
			
			this.id = ps.executeUpdate();
			status = true;
		}
		catch (Exception e) 
		{
			logger.fatal("Unable to Update Credit card dto : " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally
		{
			ps.close();
		}
    	
    	return status;
    }
    
    public boolean deleteCreditCard(int did) throws Exception
    {
    	boolean status = false;
    	
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		
		try 
		{
			logger.info("delete from credit card dto");
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "DELETE FROM " + this.tableName + 
					" WHERE Id = ?";
			
			ps = connection.prepareStatement(query);
			ps.setInt(1, did);
			
			ps.executeUpdate();
			status = true;
		} 
		catch (Exception e) 
		{
			logger.fatal("Unable to delete credit card details dto : " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally
		{
			ps.close();
		}
    	
    	return status;
    }
    
    
    // getter and setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public String getCardNickName() {
		return cardNickName;
	}
	public void setCardNickName(String cardNickName) {
		this.cardNickName = cardNickName;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
