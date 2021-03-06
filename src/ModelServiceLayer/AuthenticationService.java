package ModelServiceLayer;

import modelObject.User;

public class AuthenticationService implements IAuthenticationService
{

	// check if (user is valid) and (username password is valid)
    @Override
    public boolean authenticateUser(String username, String password) throws Exception
    {
        boolean authenticated = true;
        
        IUserService userService = new UserService();
        User user = userService.getUserByUsername(username);
        
        
        // user not found in file. 
        if(null == user)
        {
            authenticated = false;
        }
        
        if(false != authenticated)
        {
            authenticated = (password.equals(user.getPassword())); 
        }
        
        return authenticated;
    }

    @Override
    public boolean authenticateUser(User user) throws Exception
    {
       return this.authenticateUser(user.getUsername(), user.getPassword());
    }

    @Override
    public boolean IsUserDetailsForRegistrationValid(User user) throws Exception
    {
        boolean status = true;
        
        IUserService userService = new UserService();
        User dbuser = userService.getUserByUsername(user.getUsername());
        
        // check if user already exists in the db
        if(null != dbuser)
        {
            status = false;
        }
        
        // additionally do other type of checking, username length, 
        // password length etc
        
        return status;
    }
}
