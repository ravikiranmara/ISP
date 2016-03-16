package ModelServiceLayer;

import modelObject.CreditCard;
import modelObject.User;

public interface IUserService
{
    User getUserByUsername(String username) throws Exception;
    User getUserById(int userId) throws Exception;
    boolean putUser(User user) throws Exception;
    boolean isUserExists(String username) throws Exception;
    CreditCard getCreditCardForUser(int userId, int CreditCardId) throws Exception;
    boolean addCreditCardToUser(int userId, CreditCard creditCard) throws Exception;
    boolean updateCreditCard(int userId, CreditCard creditCard) throws Exception;
}
