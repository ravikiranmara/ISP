package modelObject;

public class CreditCard 
{
	int id;
	String holderName;
	String cardNumber;
	float balance;
	String nickName;
	String cvv;
	
	public CreditCard()
	{
		id = -1;
		holderName = cardNumber = nickName = cvv = "";
		balance = 0;
	}
	
	// getter and setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHolderName() {
		return HolderName;
	}
	public void setHolderName(String holderName) {
		HolderName = holderName;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
}
