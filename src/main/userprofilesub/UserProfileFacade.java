package main.userprofilesub;

import main.dbsub.DBFacade;
import main.dbsub.DBService;
import main.model.User;

import java.util.List;

/**
 * Created by Dora on 4/19/2017.
 */
public class UserProfileFacade implements UserProfileService {

    private DBService dbService;

    public UserProfileFacade() {
        this.dbService = new DBFacade();
    }

    @Override
    public User getUser(String userName, String password) {
        return this.dbService.getUserByUserNameAndPassword(userName, password);
    }

    @Override
    public User getUserByUserName(String userName) {
        return this.dbService.getUserByUserName(userName);
    }

    @Override
    public User getUserByUserId(String userId) {
        return this.dbService.getUserById(userId);
    }

    @Override
    public List<User> getAllUser() {
        return this.dbService.getAllUser();
    }

    @Override
    public boolean updateUser(User user) {
        return this.dbService.updateUser(user);
    }

    @Override
    public boolean deleteUser(User user) {
        return this.dbService.deleteUser(user);
    }

    @Override
    public boolean deleteUserById(String userId) {
        return this.dbService.deleteUserById(userId);
    }
}
