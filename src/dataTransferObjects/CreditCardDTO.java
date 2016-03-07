package dataTransferObjects;

class CreditCardDTO
{
    int id;
    String cardHolderName;
    String creditCardNumber;
    float balance;
    String cardNickName;
    String cvv;
    int userId;
    
    public CreditCardDTO()
    {
    	userId = id = -1;
    	cardHolderName = creditCardNumber = 
    			cardNickName = cvv = "";
    	balance = -1;
    	
    	return;
    }
    
    public boolean getCreditCardByUserId(int userId)
    {
    	boolean status = false;
    	
    	return status;
    }
    
    public boolean getCreditCardByCreditCardNumber(String cardNumber)
    {
    	boolean status = false;
    	
    	return status;
    }
    
    public int addCreditCard()
    {
    	int insertId = -1;
    	
    	return insertId;
    }
    
    public boolean updateCreditCard()
    {
    	boolean status = false;
    	
    	return status;
    }
    
    public boolean deleteCreditCard()
    {
    	boolean status = false;
    	
    	return status;
    }
    
    
    
    // getter and setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public String getCardNickName() {
		return cardNickName;
	}
	public void setCardNickName(String cardNickName) {
		this.cardNickName = cardNickName;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
    
}
