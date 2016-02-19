package ModelServiceLayer;

import modelObject.User;

public interface IUserService
{
    User getUserByUsername(String username);
    boolean putUser(User user);
    // User getUserByUserId(int id);
}
