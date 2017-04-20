package main.accountsub;

import main.model.Account;

import java.util.List;

/**
 * Created by Dora on 4/19/2017.
 */
public interface AccountService {

    public Account getAccount(String userName, String password);
    public Account getAccountByUserName(String userName);
    public Account getAccountByUserId(String userId);
    public List<Account> getAllAccount();
    public boolean updateAccount(Account account);
    public boolean deleteAccount(Account account);
    public boolean deleteAccountById(String accountId);

}
