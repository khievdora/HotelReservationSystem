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
    public int saveGuest(Guest guest);
    public boolean updateGuest(Guest guest);
    public boolean deleteGuestById(String guestId);
    public boolean deleteAllGuest();
    public Guest getGuestById(String guestId);
    public List<Guest> getAllGuest();

    // CRUD Room Type
    public int saveRoomType(RoomType roomType);
    public int updateRoomType(RoomType roomType);
    public int deleteRoomType(RoomType roomType);
    public int deleteRoomTypeById(int roomTypeId);
    public RoomType getRoomTypeById(int roomTypeId);
    public List<RoomType> getAllRoomType();

    // CRUD Room
    public int saveRoom(Room room);
    public int updateRoom(Room room);
    public int deleteRoom(Room room);
    public int deleteRoomById(int roomId);
    public Room getRoomById(int roomId);
    public List<Room> getAllRoom();

    //CRUD Address
    public int saveAddress(Address address);
    public int updateAddress(Address address);
    public int deleteAddress(Address address);
    public int deleteAddressById(int addressId);
    public Address getAddressById(int addressId);
    public List<Address> getAllAddress();


}
