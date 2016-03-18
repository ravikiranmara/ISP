package dataTransferObjects;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Statement;

import utils.dbContextSingleton;

public class TransactionDTO
{
	String tableName = "Transactions";
	int id;
	int customerUserId;
	int ownerUserId;
	int customerCreditCardId;
	int ownerCreditCardId;
	float amount;
	short transactionStatus;
	short cancelledReservations;
	boolean isInitialized;
	
	static Logger logger = Logger.getLogger(TransactionDTO.class.getName());
	
	public TransactionDTO()
	{
		this.initialize();
	}
	
	public void clear()
	{
		this.initialize();
	}
	
	public void initialize()
	{
		customerUserId = ownerUserId = id = -1;
		customerCreditCardId = ownerCreditCardId = -1;
		amount = 0;
		transactionStatus = 0;
		cancelledReservations = 0;
		isInitialized = false;
	}
		
	public ArrayList<Integer> getTransactionForUser(int uid) throws Exception
	{
		ArrayList<Integer> templist = null;
		Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try 
		{
			logger.info("get all transactions for user dto");
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "SELECT Id " +
					" FROM " + this.tableName + 
					" WHERE CustomerUserId = ?";
			
			ps = connection.prepareStatement(query);
			ps.setInt(1, uid);
			rs = ps.executeQuery();
			
			templist = new ArrayList<Integer>();
			while(rs.next())
			{
				templist.add(rs.getInt("Id"));
			}
		}
		catch (Exception e) 
		{
			logger.fatal("unable to get all transactions for user dto: " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally
		{
			ps.close();
		}
		
		return templist;
	}
	
	public boolean getTransactionById(int tid) throws Exception
    {
    	boolean status = false;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try 
		{
			logger.info("get transactoin by id dto");
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "SELECT Id, CustomerUserId, OwnerUserId, " +
					"CustomerCreditCardId, OwnerCreditCardId, Amount, " +
					" CancelledReservation, Status " + 
					" FROM " + this.tableName + 
					" WHERE Id = ?";
			ps = connection.prepareStatement(query);
			ps.setInt(1, tid);
			
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				this.id = rs.getInt("Id");
				this.customerUserId = rs.getInt("CustomerUserId");
				this.ownerUserId = rs.getInt("OwnerUserId");
				this.customerCreditCardId = rs.getInt("CustomerCreditCardId");
				this.ownerCreditCardId = rs.getInt("OwnerCreditCardId");
				this.transactionStatus = rs.getShort("Status");
				this.amount = rs.getFloat("Amount");
				this.cancelledReservations = rs.getShort("CancelledReservation");
				
				this.isInitialized = true;
				status = true;
			}
		} 
		catch (Exception e) 
		{
			logger.fatal("Unable to transaction by id dto: " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally
		{
			ps.close();
		}
			
    	return status;
    }
    
    public int addTransaction() throws Exception
    {
    	int insertId = -1;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		
		try 
		{
			logger.info("add transaction dto");
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "Insert Into " + this.tableName + " (CustomerUserId, OwnerUserId, " +
					"CustomerCreditCardId, OwnerCreditCardId, Amount, Status, CancelledReservation)" +
					" values (?, ?, " +
					"?, ?, ?, ?, ?)";
			
			ps = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			// init
			ps.setInt(1, this.customerUserId);
			ps.setInt(2, this.ownerUserId);
			ps.setInt(3, this.customerCreditCardId);
			ps.setInt(4, this.ownerCreditCardId);
			ps.setFloat(5, this.amount);
			ps.setShort(6, this.transactionStatus);
			ps.setShort(7, this.cancelledReservations);
			
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
			logger.fatal("Unable to to add transaction dto: " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally
		{
			ps.close();
		}
		
    	return insertId;
    }

    public int updateTransaction() throws Exception
    {
    	int insertId = -1;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		
		try 
		{
			logger.info("update transaction dto");
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "Update " + this.tableName + 
					" SET CustomerUserId = ?, OwnerUserId = ?, " +
					"CustomerCreditCardId = ?, OwnerCreditCardId = ?, Amount = ?, Status = ?, CancelledReservation = ?" +
					" WHERE Id = ?";
					
			ps = connection.prepareStatement(query);
			
			// init
			ps.setInt(1, this.customerUserId);
			ps.setInt(2, this.ownerUserId);
			ps.setInt(3, this.customerCreditCardId);
			ps.setInt(4, this.ownerCreditCardId);
			ps.setFloat(5, this.amount);
			ps.setShort(6, this.transactionStatus);
			ps.setShort(7, this.cancelledReservations);
			ps.setInt(8, this.getId());
			
			ps.executeUpdate();
			insertId = this.id;
		} 
		catch (Exception e) 
		{
			logger.fatal("Unable to to udpate transaction dto: " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally
		{
			ps.close();
		}
		
    	return insertId;
    }
    
    public boolean deleteTransaction(int tid) throws Exception
    {
    	boolean status = false;
    	Connection connection = null;
		String query = null;
		PreparedStatement ps = null;
		
		try 
		{
			logger.info("delete transaction dto");
			connection = dbContextSingleton.getSingletonObject().getConnection();
			query = "DELETE FROM " + this.tableName + 
					" WHERE Id = ?";
			
			ps = connection.prepareStatement(query);
			ps.setInt(1, tid);
			
			ps.executeUpdate();
			status = true;
		} 
		catch (Exception e) 
		{
			logger.fatal("Unable to delete transaction dto: " + e.getMessage());
			e.printStackTrace();
			throw e;
		} 
		finally
		{
			ps.close();
		}
	
    	return status;
    }
	
	// getter and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCustomerUserId() {
		return customerUserId;
	}
	public void setCustomerUserId(int customerUserId) {
		this.customerUserId = customerUserId;
	}
	public int getOwnerUserId() {
		return ownerUserId;
	}
	public void setOwnerUserId(int ownerUserId) {
		this.ownerUserId = ownerUserId;
	}
	public int getCustomerCreditCardId() {
		return customerCreditCardId;
	}
	public void setCustomerCreditCardId(int customerCreditCardId) {
		this.customerCreditCardId = customerCreditCardId;
	}
	public int getOwnerCreditCardId() {
		return ownerCreditCardId;
	}
	public void setOwnerCreditCardId(int ownerCreditCardId) {
		this.ownerCreditCardId = ownerCreditCardId;
	}
	public float getAmout() {
		return amount;
	}
	public void setAmout(float amout) {
		this.amount = amout;
	}
	public short getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(short transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public short getCancelledReservations() {
		return cancelledReservations;
	}
	public void setCancelledReservations(short cancelledReservations) {
		this.cancelledReservations = cancelledReservations;
	}
}