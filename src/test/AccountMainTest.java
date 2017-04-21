package test;

import main.accountsub.AccountFacade;
import main.accountsub.AccountService;
import main.model.Account;
import main.statusenums.AccountStatus;
import main.statusenums.Status;
import main.statusenums.UserRole;

import java.util.List;

/**
 * Created by Dora on 4/21/2017.
 */
public class AccountMainTest {

    public static void main(String[] args) {

        AccountMainTest mainTest = new AccountMainTest();

        AccountService accountService = new AccountFacade();

        // List all account in the db
        List<Account> accountList = accountService.getAllAccount();
        mainTest.displayAllAccount(accountList);

        // Add new account
<<<<<<< HEAD


=======
        Account account = new Account();
        account.setCode(accountList.size() + 1);
        account.setUserName("dora");
        account.setPassword("dora");
        account.setStatus(Status.ENABLE.toString());
        account.setUserRole(UserRole.USER.toString());
        account.setAccountStatus(AccountStatus.ACTIVE.toString());
        accountService.saveAccount(account);
>>>>>>> 670ff0e8aab01467cdda734989a1a382b191f794
        // List all account again
        accountList = accountService.getAllAccount();
        mainTest.displayAllAccount(accountList);

        // Edit account

        // Load account that has been updated


    }
    public void addAccount(){

    }
    public void displayAllAccount(List<Account> accountList) {
        printTitle("Account List");
        for (Account item : accountList) {
            System.out.println(item.toString());
        }
    }

    public void printTitle(String message) {
        System.out.println("***********************************");
        System.out.println(message);
        System.out.println("***********************************");
    }

}
