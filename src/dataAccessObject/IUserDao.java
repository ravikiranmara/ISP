package dataAccessObject;

import modelObject.User;

public interface IUserDao 
{
	boolean putUser(User user);
	
	User getUserByUsername(String username);
	// Boolean removeUser(User user);
	
}
