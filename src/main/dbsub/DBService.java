package main.dbsub;

import main.model.*;

import java.util.List;

/**
 * Created by Dora on 4/19/2017.
 */
public interface DBService {
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

    //CRUD Reservation
   /* public boolean saveReservation(Reservation reservation);
    public boolean updateReservation(Reservation reservation);
    public boolean deleteReservationById(String reservationId);
    public boolean deleteAllReservation();
    public Reservation getReservationById(String reservationId);
    public List<Reservation> getAllReservations();*/

    //CRUD Guest
    /*public boolean saveGuest(Guest guest);
    public boolean UpdateGuest(Guest guest);
    public boolean deleteGuestById(String guest);
    public boolean deleteAllGuest();
    public Guest getGuestById(String reservationId);
    public List<Guest> getAllGuest();
*/
    //CRUD Address
    /*public boolean saveAddress(Guest guest);
    public boolean updateAddress(Guest guest);
    public Address getAddressById(String address);
    public List<Address> getAllAddress();*/

    //

}
