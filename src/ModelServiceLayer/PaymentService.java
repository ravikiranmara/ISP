package ModelServiceLayer;

import java.security.InvalidParameterException;
import java.util.ArrayList;

import modelObject.CreditCard;
import modelObject.User;
import org.apache.log4j.Logger;
import dataAccessObject.UserDAO;

public class PaymentService implements IPaymentService 
{
	static Logger logger = Logger.getLogger(PaymentService.class.getName());

	@Override
	public boolean makePayment(int fromUserId, int fromCreditCardId,
			int toUserId, int toCreditCardId, float amount) throws Exception 
	{
		boolean status = false;
		UserDAO userDao = null;
		User fromUser = null;
		User toUser = null;
		CreditCard fromCreditCard = null;
		CreditCard toCreditCard = null;
		ArrayList<CreditCard> fromccList = null;
		ArrayList<CreditCard> toccList = null;
		
		try
		{
			logger.info("make payment");
			userDao = new UserDAO();
			
			logger.info("get users");
			fromUser = userDao.getUserById(fromUserId);
			toUser = userDao.getUserById(toUserId);
			
			if(null == fromUser || null == toUser)
			{
				throw new InvalidParameterException("User Id is not valid, unable to find user");
			}
			
			logger.info("get creditCards");
			fromccList = fromUser.getCreditCard();
			toccList = toUser.getCreditCard();
			
			if(null == fromccList || null == toccList)
			{
				throw new InvalidParameterException("User credit card is not valid, credit card list is null");
			}
			
			for(CreditCard cc : fromccList)
			{
				if(fromCreditCardId == cc.getId())
				{
					fromCreditCard = cc;
				}
			}
			
			for(CreditCard cc : toccList)
			{
				if(toCreditCardId == cc.getId())
				{
					toCreditCard = cc;
				}
			}
			
			if(null == fromccList || null == toccList)
			{
				throw new InvalidParameterException("User credit card id is not valid, unable to find credit card with id");
			}
			
			logger.info("Check for balance");
			if(fromCreditCard.getBalance() < amount)
			{
				throw new IllegalStateException("Not enough balance in credit card");				
			}
			
			logger.info("make the transaction");
			float bal = fromCreditCard.getBalance();
			fromCreditCard.setBalance(bal-amount);
			
			bal = toCreditCard.getBalance();
			toCreditCard.setBalance(bal + amount);
			
			status = true;
		}
		catch (InvalidParameterException ex)
		{
			logger.fatal(ex.getMessage());
			throw ex;
		}
		catch (IllegalStateException ex)
		{
			logger.fatal(ex.getMessage());
			status = false;
		}
		catch (Exception ex)
		{
			logger.fatal(ex.getMessage());
			throw ex;
		}
		finally
		{
		}
		
		return status;
	}
	

}
