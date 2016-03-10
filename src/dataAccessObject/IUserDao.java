package dataAccessObject;

import modelObject.CreditCard;
import modelObject.User;
import org.apache.log4j.Logger;


public interface IUserDao 
{
	boolean addUser(User user) throws Exception;
	
	User getUserByUsername(String username) throws Exception;
	
	User getUserById(int id) throws Exception;
	
	boolean removeUser(User user) throws Exception;
	
	boolean updateUser(User user) throws Exception;
	
	boolean addCreditCard(User user, CreditCard creditCard) throws Exception;
	
	boolean removeCreditCard(User user, CreditCard creditCard) throws Exception;
	
	boolean updateCreditCard(User user, CreditCard creditCard) throws Exception;
	
	// Logger
	static Logger logger = Logger.getLogger(IUserDao.class.getName());
}
