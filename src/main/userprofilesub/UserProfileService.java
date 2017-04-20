package main.userprofilesub;

import main.model.User;

import java.util.List;

/**
 * Created by Dora on 4/19/2017.
 */
public interface UserProfileService {

    public User getUser(String userName, String password);
    public User getUserByUserName(String userName);
    public User getUserByUserId(String userId);
    public List<User> getAllUser();
    public boolean updateUser(User user);
    public boolean deleteUser(User user);
    public boolean deleteUserById(String userId);

}
