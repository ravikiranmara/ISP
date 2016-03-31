package modelObject;

public class BankPayment 
{
	int toCreditCardId;
	int toUserId;
	int fromCreditCardId;
	int fromUserId;
	int amount;
	
	// getters and setters
	public int getToCreditCardId() {
		return toCreditCardId;
	}
	public void setToCreditCardId(int toCreditCardId) {
		this.toCreditCardId = toCreditCardId;
	}
	public int getToUserId() {
		return toUserId;
	}
	public void setToUserId(int toUserId) {
		this.toUserId = toUserId;
	}
	public int getFromCreditCardId() {
		return fromCreditCardId;
	}
	public void setFromCreditCardId(int fromCreditCardId) {
		this.fromCreditCardId = fromCreditCardId;
	}
	public int getFromUserId() {
		return fromUserId;
	}
	public void setFromUserId(int fromUserId) {
		this.fromUserId = fromUserId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
