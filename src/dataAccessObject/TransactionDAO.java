package dataAccessObject;

import java.util.ArrayList;

import org.apache.log4j.Logger;

import modelObject.CreditCard;
import modelObject.Transaction;
import modelObject.User;
import dataTransferObjects.CreditCardDTO;
import dataTransferObjects.HotelReviewDTO;
import dataTransferObjects.TransactionDTO;
import dataTransferObjects.UserDTO;

public class TransactionDAO 
{
	static Logger logger = Logger.getLogger(TransactionDAO.class.getName());
	
	private void initializeDTOFromTransaction(TransactionDTO trdto, Transaction tr)
	{
		trdto.setId(tr.getId());
		trdto.setAmout(tr.getAmount());
		trdto.setCancelledReservations(tr.getCancelledReservation());
		trdto.setCustomerCreditCardId(tr.getCustomerCreditCardId());
		trdto.setCustomerUserId(tr.getCustomerUserId());
		trdto.setOwnerCreditCardId(tr.getOwnerCreditCardId());
		trdto.setOwnerUserId(tr.getOwnerUserId());
		trdto.setTransactionStatus(tr.getTransactionStatus());
		
		return;
	}
	
	private void initializeTransactionFromDTO(Transaction tr, TransactionDTO trdto)
	{
		tr.setId(trdto.getId());
		tr.setAmount(trdto.getAmout());
		tr.setCancelledReservation(trdto.getCancelledReservations());
		tr.setCustomerCreditCardId(trdto.getCustomerCreditCardId());
		tr.setCustomerUserId(trdto.getCustomerUserId());
		tr.setOwnerCreditCardId(trdto.getOwnerCreditCardId());
		tr.setOwnerUserId(trdto.getOwnerUserId());
		tr.setTransactionStatus(trdto.getTransactionStatus());
		
		return;
	}
	
	public boolean addTransaction(Transaction transaction) throws Exception 
	{
		boolean status = false;
		TransactionDTO transactionDto = null;
		
		try
		{
			transactionDto = new TransactionDTO();
			
			// fetch user details
			logger.info("add transaction dao");
			this.initializeDTOFromTransaction(transactionDto, transaction);
			transactionDto.addTransaction();
			
			status = true;
		}
		catch (Exception e)
		{
			logger.fatal("Unable to add transaction: ");
			throw e;
		}
		finally
		{
		}
		
		return status;
	}

	public Transaction getTransactionById(int tid) throws Exception 
	{
		TransactionDTO transactionDto = null;
		Transaction transaction = null;
		
		try
		{
			transactionDto = new TransactionDTO();
			
			// fetch user details
			logger.info("add transaction dao");
			transactionDto.getTransactionById(tid);
			transaction = new Transaction();
			this.initializeTransactionFromDTO(transaction, transactionDto);
			
		}
		catch (Exception e)
		{
			logger.fatal("Unable to get transaction: ");
			throw e;
		}
		finally
		{
		}
		
		return transaction;
	}

	public boolean updateTransaction(Transaction transaction) throws Exception 
	{
		boolean status = false;
		TransactionDTO transactionDto = null;
		
		try
		{
			transactionDto = new TransactionDTO();
			
			// fetch user details
			logger.info("update transaction dao");
			this.initializeDTOFromTransaction(transactionDto, transaction);
			transactionDto.updateTransaction();
			
			status = true;
		}
		catch (Exception e)
		{
			logger.fatal("Unable to update transaction: ");
			throw e;
		}
		finally
		{
		}
		
		return status;
	}
	
	public boolean deleteTransaction(int tid) throws Exception 
	{
		boolean status = false;
		TransactionDTO transactionDto = null;
		
		try
		{
			transactionDto = new TransactionDTO();
			
			// fetch user details
			logger.info("delete transaction dao");
			transactionDto.deleteTransaction(tid);
			
			status = true;
		}
		catch (Exception e)
		{
			logger.fatal("Unable to delete transaction: ");
			throw e;
		}
		finally
		{
		}
		
		return status;
	}
	
}
