package ModelServiceLayer;

import org.apache.log4j.Logger;

import utils.globals;

import dataAccessObject.TransactionDAO;
import modelObject.Transaction;

public class TransactionService implements ITransactionService
{
	static Logger logger = Logger.getLogger(TransactionService.class.getName());
	
	@Override
	public boolean addTransaction(Transaction transaction) throws Exception 
	{
		boolean status = false;
		TransactionDAO tdao = null;
		
		try
		{
			tdao = new TransactionDAO();
			
			tdao.addTransaction(transaction);
			logger.info("tranid " + transaction.getId());
			status = true;
		}
		catch (Exception ex)
		{
			logger.fatal("unable to add transaction");
			throw ex;
		}
		
		return status;
	}

	@Override
	public boolean deleteTransaction(int TransactionId) throws Exception 
	{
		Transaction tr = null;
		TransactionDAO tdao = null;
		boolean status = false;
		
		try
		{
			logger.info("delete transaction by id");
			tdao = new TransactionDAO();
			tr = tdao.getTransactionById(TransactionId);
			status = this.deleteTransaction(tr);
		}
		catch (Exception ex)
		{
			logger.fatal("Unable to delete transaction");
			throw ex;
		}
		
		return status;
	}

	@Override
	public Transaction getTransactionById(int tid) throws Exception 
	{
		Transaction tr = null;
		TransactionDAO tdao = null;
		
		try
		{
			logger.info("get transaction by id");
			tdao = new TransactionDAO();
			tr = tdao.getTransactionById(tid);
		}
		catch (Exception ex)
		{
			logger.fatal("Unable to delete transaction");
			throw ex;
		}
		
		return tr;
	}

	@Override
	public boolean updateTransaction(Transaction transaction) throws Exception 
	{
		boolean status = false;
		Transaction tr = null;
		TransactionDAO tdao = null;
		
		try
		{
			logger.info("get transaction by id");
			tdao = new TransactionDAO();
			status = tdao.updateTransaction(transaction);
		}
		catch (Exception ex)
		{
			logger.fatal("Unable to delete transaction");
			throw ex;
		}
		
		return status;
	}

	@Override
	public boolean deleteTransaction(Transaction transaction) throws Exception 
	{
		boolean status = false;
		TransactionDAO tdao = null;
		IPaymentService paymentService = null;
		
		try
		{
			logger.info("delete transaction by transaction");
			tdao = new TransactionDAO();
			paymentService = new PaymentService();
			
			status = paymentService.makePayment(transaction.getOwnerUserId(), transaction.getOwnerCreditCardId(), 
					transaction.getCustomerUserId(), transaction.getCustomerCreditCardId(), transaction.getAmount());
			
			if(false == status)
			{
				throw new Exception ("Payment not successful. cancelling transaction");
			}
			
			tdao.deleteTransaction(transaction.getId());
			status = true;
		}
		catch (Exception ex)
		{
			logger.fatal("unable to add transaction");
			throw ex;
		}
		
		return status;
	}
	@Override
	public boolean cancelTransaction(Transaction transaction) throws Exception 
	{
		boolean status = false;
		Transaction tr = null;
		TransactionDAO tdao = null;
		
		try
		{
			logger.info("get transaction by id");
			tdao = new TransactionDAO();
			transaction.setTransactionStatus(globals.transaction_cancelTrue);
			transaction.setCancelledReservation(globals.transaction_reservationFalse);
			status = tdao.updateTransaction(transaction);
		}
		catch (Exception ex)
		{
			logger.fatal("Unable to delete transaction");
			throw ex;
		}
		
		return status;
	}

}
