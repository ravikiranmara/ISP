package modelObject;

import utils.UserType;

public class User 
{
	// int userid; // when we move to db
	String username;
	String password;
	UserType userType;
	
	public User(String username, String password, UserType userType)
	{
		this.username = username;
		this.password = password;
		this.userType = userType;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

    public UserType getUserType()
    {
        return userType;
    }

    public void setUserType(UserType userType)
    {
        this.userType = userType;
    }
}
