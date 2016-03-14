package ModelServiceLayer;

import modelObject.User;

public interface IUserService
{
    User getUserByUsername(String username) throws Exception;
    boolean putUser(User user) throws Exception;
    boolean isUserExists(String username) throws Exception;
    // User getUserByUserId(int id);
}
