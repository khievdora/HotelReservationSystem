package main.dbsub;

import main.model.Account;

import java.util.List;

/**
 * Created by Dora on 4/19/2017.
 */
public class DBFacade implements DBService {

    @Override
    public boolean saveAccount(Account account) {
        return false;
    }

    @Override
    public boolean updateAccount(Account account) {
        return false;
    }

    @Override
    public boolean deleteAccount(Account account) {
        return false;
    }

    @Override
    public boolean deleteAccountById(String accountId) {
        return false;
    }

    @Override
    public Account getAccountById(String accountId) {
        return null;
    }

    @Override
    public Account getAccountByUserName(String userName) {
        return null;
    }

    @Override
    public Account getAccountByUserNameAndPassword(String userName, String password) {
        return null;
    }

    @Override
    public List<Account> getAccountByFirstName(String firstName) {
        return null;
    }

    @Override
    public List<Account> getAccountByLastName(String lastName) {
        return null;
    }

    @Override
    public List<Account> getAllAccount() {
        return null;
    }
}
