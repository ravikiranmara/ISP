package ModelServiceLayer;

import modelObject.User;

public interface IAuthenticationService
{
    boolean authenticateUser(String username, String password) throws Exception;
    boolean authenticateUser(User user) throws Exception;
    boolean IsUserDetailsForRegistrationValid(User user);
    
    // moving this to IUserService get and put user.
    // boolean registerUser(User user);
    // boolean removeUser(User user);  
    
}
