package ModelServiceLayer;

import modelObject.Transaction;

public interface ITransactionService 
{
	public boolean addTransaction(Transaction transaction) throws Exception;
	public boolean deleteTransaction(int TransactionId) throws Exception;
	public boolean deleteTransaction(Transaction transaction) throws Exception;
	public Transaction getTransactionById(int tid) throws Exception;
	public boolean updateTransaction(Transaction transaction) throws Exception;
	boolean cancelTransaction(Transaction transaction) throws Exception;
}
