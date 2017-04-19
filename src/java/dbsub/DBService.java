package java.dbsub;

import java.model.User;
import java.util.List;

/**
 * Created by Dora on 4/19/2017.
 */
public interface DBService {
    // CRUD User
    public boolean saveUser(User user);
    public boolean updateUser(User user);
    public boolean deleteUser(User user);
    public boolean deleteUserById(String userId);
    public User getUserById(String userId);
    public User getUserByUserName(String userName);
    public User getUserByUserNameAndPassword(String userName, String password);
    public List<User> getUserByFirstName(String firstName);
    public List<User> getUserByLastName(String lastName);
    public List<User> getAllUser();

    // CRUD Room
}
