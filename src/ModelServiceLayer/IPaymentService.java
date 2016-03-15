package ModelServiceLayer;

public interface IPaymentService 
{
	public boolean makePayment(int fromUserId, int fromCreditCardId, 
			int toUserId, int toCreditCardId, float amount) 
					throws Exception;
}
