package utils;

public enum UserType
{
    Customer(0), Client (1);
    
    private final int value;
    private UserType(int value)
    {
    	this.value = value;
    }
    
    public int getValue()
    {
    	return value;
    }
}
