package main.dbsub;

import main.model.Account;

import java.util.List;

/**
 * Created by Dora on 4/21/2017.
 */
public interface IAccount {
    // CRUD User
    public boolean saveAccount(Account account);
    public boolean updateAccount(Account account);
    public boolean deleteAccount(Account account);
    public boolean deleteAccountById(String accountId);
    public Account getAccountById(String accountId);
    public Account getAccountByUserName(String userName);
    public Account getAccountByUserNameAndPassword(String userName, String password);
    public List<Account> getAccountByFirstName(String firstName);
    public List<Account> getAccountByLastName(String lastName);
    public List<Account> getAllAccount();

}
