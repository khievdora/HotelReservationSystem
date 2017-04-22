package main.dbsub;

import main.model.Account;
import main.model.Guest;

import java.util.List;

/**
 * Created by Dora on 4/19/2017.
 */
public class DBFacade implements DBService {

    private IAccount account = null;
    private IGuest guest = null;

    public DBFacade() {
        //Geneate Database
        IGenerateDB generateDB = new GeneateDBImpl();
        generateDB.generateDB();

        account = new AccountImpl();
        guest = new GuestImpl();
    }

    @Override
    public boolean saveAccount(Account account) {
        return this.account.saveAccount(account);
    }

    @Override
    public boolean updateAccount(Account account) {
        return this.account.updateAccount(account);
    }

    @Override
    public boolean deleteAccount(Account account) {
        return this.account.deleteAccount(account);
    }


    @Override
    public boolean deleteAccountById(String accountId) {
        return this.account.deleteAccountById(accountId);
    }

    @Override
    public Account getAccountById(String accountId) {
        return this.account.getAccountById(accountId);
    }

    @Override
    public Account getAccountByUserName(String userName) {
        return this.account.getAccountByUserName(userName);
    }

    @Override
    public Account getAccountByUserNameAndPassword(String userName, String password) {
        return this.account.getAccountByUserNameAndPassword(userName, password);
    }

    @Override
    public List<Account> getAccountByFirstName(String firstName) {
        return this.account.getAccountByFirstName(firstName);
    }

    @Override
    public List<Account> getAccountByLastName(String lastName) {
        return this.account.getAccountByLastName(lastName);
    }

    @Override
    public List<Account> getAllAccount() {
        return this.account.getAllAccount();
    }

    @Override
    public int saveGuest(Guest guest) {
        return this.guest.saveGuest(guest);
    }

    @Override
    public boolean updateGuest(Guest guest) {
        return this.guest.updateGuest(guest);
    }

    @Override
    public boolean deleteGuestById(String guestId) {
        return this.guest.deleteGuestById(guestId);
    }

    @Override
    public boolean deleteAllGuest() {
        return this.guest.deleteAllGuest();
    }

    @Override
    public Guest getGuestById(String guestId) {
        return this.guest.getGuestById(guestId);
    }

    @Override
    public List<Guest> getAllGuest() {
        return this.guest.getAllGuest();
    }
}
