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
		IUserService userService = null;
		User fromUser = null;
		User toUser = null;
		CreditCard fromCreditCard = null;
		CreditCard toCreditCard = null;
		ArrayList<CreditCard> fromccList = null;
		ArrayList<CreditCard> toccList = null;
		
		try
		{
			logger.info("make payment");
			userService = new UserService();
			
			logger.info("get creditCards");
			toCreditCard = userService.getCreditCardForUser(toUserId, toCreditCardId);
			fromCreditCard = userService.getCreditCardForUser(fromUserId, fromCreditCardId);
			
			if(null == toCreditCard || null == fromCreditCard)
			{
				throw new InvalidParameterException("unable to get credit card for users");
			}
			
			logger.info("Check for balance");
			if(fromCreditCard.getBalance() < amount)
			{
				throw new IllegalStateException("Not enough balance in credit card");				
			}
			
			logger.info("make the transaction");
			float bal = fromCreditCard.getBalance();
			fromCreditCard.setBalance(bal-amount);
			userService.updateCreditCard(fromUserId, fromCreditCard);
			
			bal = toCreditCard.getBalance();
			toCreditCard.setBalance(bal + amount);
			userService.updateCreditCard(toUserId, toCreditCard);
			
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
