package main.dbsub;

import main.model.Account;

import java.sql.ResultSet;
import java.util.ArrayList;
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
            String query = "INSERT INTO account(idAccount, username, password, status, userRole, accountStatus) VALUES (?,?,?,?,?,?)";
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
            String query = "DELETE FROM account WHERE idAccount='"+accountId+"'";
            iDatabase.executeUpdate(query);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Account getAccountById(String accountId) {
        String query = "SELECT * from account WHERE username='"+ accountId +"'";
        Account account = new Account();
        try{
            ResultSet rs = iDatabase.executeQuery(query);
            while (rs.next()) {
                account.setCode(rs.getInt(1));
                account.setUserName(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setStatus(rs.getString(4));
                account.setUserRole(rs.getString(5));
                account.setAccountStatus(rs.getString(6));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        iDatabase.closeConnection();
        return account;
    }

    @Override
    public Account getAccountByUserName(String userName) {
        String query = "SELECT * from account WHERE username='"+ userName +"'";
        Account account = new Account();
        try{
            ResultSet rs = iDatabase.executeQuery(query);
            while (rs.next()) {
                account.setCode(rs.getInt(1));
                account.setUserName(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setStatus(rs.getString(4));
                account.setUserRole(rs.getString(5));
                account.setAccountStatus(rs.getString(6));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        iDatabase.closeConnection();
        return account;
    }

    @Override
    public Account getAccountByUserNameAndPassword(String userName, String password) {
        String query = "SELECT * from account WHERE username='"+ userName +"' AND password = '" +password+"'";
        Account account = new Account();
        try{
            ResultSet rs = iDatabase.executeQuery(query);
            while (rs.next()) {
                account.setCode(rs.getInt(1));
                account.setUserName(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setStatus(rs.getString(4));
                account.setUserRole(rs.getString(5));
                account.setAccountStatus(rs.getString(6));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        iDatabase.closeConnection();
        return account;
    }

    @Override
    public List<Account> getAccountByFirstName(String firstName) {
        String query = "SELECT *from account WHERE username='"+ firstName +"'";
        List<Account> accounts = new ArrayList<Account>();
        Account account=new Account();
        try{
            ResultSet rs = iDatabase.executeQuery(query);
            while (rs.next()){
                account.setCode(rs.getInt(1));
                account.setUserName(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setStatus(rs.getString(4));
                account.setUserRole(rs.getString(5));
                account.setAccountStatus(rs.getString(6));
                accounts.add(account);


            }

        }catch (Exception e){

        }
        return accounts;
    }

    @Override
    public List<Account> getAccountByLastName(String lastName) {
        String query = "SELECT *from account WHERE username='"+ lastName +"'";
        List<Account> accounts = new ArrayList<Account>();
        Account account=new Account();
        try{
            ResultSet rs = iDatabase.executeQuery(query);
            while (rs.next()){
                account.setCode(rs.getInt(1));
                account.setUserName(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setStatus(rs.getString(4));
                account.setUserRole(rs.getString(5));
                account.setAccountStatus(rs.getString(6));
                accounts.add(account);


            }

        }catch (Exception e){

        }
        return accounts;
    }

    @Override
    public List<Account> getAllAccount() {
        String query = "SELECT *from account";
        List<Account> accounts = new ArrayList<Account>();
        Account account=new Account();
        try{
            ResultSet rs = iDatabase.executeQuery(query);
            while (rs.next()){
                account.setCode(rs.getInt(1));
                account.setUserName(rs.getString(2));
                account.setPassword(rs.getString(3));
                account.setStatus(rs.getString(4));
                account.setUserRole(rs.getString(5));
                account.setAccountStatus(rs.getString(6));
                accounts.add(account);


            }

        }catch (Exception e){

        }
        return accounts;
    }
}
