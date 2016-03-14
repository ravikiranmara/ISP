package modelObject;

public class Transaction 
{
	int id;
	int customerUserId;
	int ownerUserId;
	int customerCreditCardId;
	int ownerCreditCardId;
	float amount;
	short transactionStatus;
	short cancelledReservation;
	
	public Transaction()
	{
		id = customerUserId = ownerUserId = -1;
		customerCreditCardId = ownerCreditCardId = -1;
		amount = 0;
		transactionStatus = cancelledReservation = 0;
		
		return;
	}
	
	// getter and setter
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
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public short getTransactionStatus() {
		return transactionStatus;
	}
	public void setTransactionStatus(short transactionStatus) {
		this.transactionStatus = transactionStatus;
	}
	public short getCancelledReservation() {
		return cancelledReservation;
	}
	public void setCancelledReservation(short cancelledReservation) {
		this.cancelledReservation = cancelledReservation;
	}
}
