package main.dbsub;

import main.model.Account;

import java.util.List;

/**
 * Created by Dora on 4/19/2017.
 */
public class DBFacade implements DBService {

    private IDatabase iDatabase = null;

    public DBFacade() {
        iDatabase = Database.getInstance();
    }

    @Override
    public boolean saveAccount(Account account) {
        try{
            String query = "INSERT INTO account(idAccount, username, password, status, userRole, accountStatus) VALUES(?,?,?,?,?,?)";
            iDatabase.executeUpdate(query);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public boolean updateAccount(Account account) {
        try{
            String query ="UPDATE account SET idAccount=?, username=?, password=?, status=?, userRole=?, accountStatus=? WHERE idAccount=?";
            iDatabase.executeUpdate(query);
             return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteAccount(Account account) {
        try{
            String query = "DELETE FROM account WHERE idAccount=?";
            iDatabase.executeUpdate(query);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    @Override
    public boolean deleteAccountById(String accountId) {
        try{

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
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
        String query = "SELECT username, password from account";
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
