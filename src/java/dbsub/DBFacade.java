package java.dbsub;

import java.model.User;
import java.util.List;

/**
 * Created by Dora on 4/19/2017.
 */
public class DBFacade implements DBService {

    @Override
    public boolean saveUser(User user) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUserById(String userId) {
        return false;
    }

    @Override
    public User getUserById(String userId) {
        return null;
    }

    @Override
    public User getUserByUserName(String userName) {
        return null;
    }

    @Override
    public User getUserByUserNameAndPassword(String userName, String password) {
        return null;
    }

    @Override
    public List<User> getUserByFirstName(String firstName) {
        return null;
    }

    @Override
    public List<User> getUserByLastName(String lastName) {
        return null;
    }

    @Override
    public List<User> getAllUser() {
        return null;
    }
}
