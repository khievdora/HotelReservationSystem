package main.dbsub;

import main.model.*;

import java.util.List;

/**
 * Created by Dora on 4/19/2017.
 */
public class DBFacade implements DBService {

    private IAccount account = null;
    private IGuest guest = null;
    private IRoomType roomType = null;
    private IRoom room = null;
    private IAddress address = null;

    public DBFacade() {
        //Geneate Database
        IGenerateDB generateDB = new GenerateDBImpl();
        generateDB.generateDB();

        account = new AccountImpl();
        guest = new GuestImpl();
        roomType = new RoomTypeImpl();
        room = new RoomImpl();
        address = new AddressImpl();
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

    @Override
    public int saveRoomType(RoomType roomType) {
        return this.roomType.saveRoomType(roomType);
    }

    @Override
    public int updateRoomType(RoomType roomType) {
        return this.roomType.updateRoomType(roomType);
    }

    @Override
    public int deleteRoomType(RoomType roomType) {
        return this.roomType.deleteRoomType(roomType);
    }

    @Override
    public int deleteRoomTypeById(int roomTypeId) {
        return this.roomType.deleteRoomTypeById(roomTypeId);
    }

    @Override
    public RoomType getRoomTypeById(int roomTypeId) {
        return this.roomType.getRoomTypeById(roomTypeId);
    }

    @Override
    public List<RoomType> getAllRoomType() {
        return this.roomType.getAllRoomType();
    }

    @Override
    public int saveRoom(Room room) {
        return this.room.saveRoom(room);
    }

    @Override
    public int updateRoom(Room room) {
        return this.room.updateRoom(room);
    }

    @Override
    public int deleteRoom(Room room) {
        return this.room.deleteRoom(room);
    }

    @Override
    public int deleteRoomById(int roomId) {
        return this.room.deleteRoomById(roomId);
    }

    @Override
    public Room getRoomById(int roomId) {
        return this.room.getRoomById(roomId);
    }

    @Override
    public List<Room> getAllRoom() {
        return this.room.getAllRoom();
    }

    @Override
    public int saveAddress(Address address) {
        return this.address.saveAddress(address);
    }

    @Override
    public int updateAddress(Address address) {
        return this.address.updateAddress(address);
    }

    @Override
    public int deleteAddress(Address address) {
        return this.address.deleteAddress(address);
    }

    @Override
    public int deleteAddressById(int addressId) {
        return this.address.deleteAddressById(addressId);
    }

    @Override
    public Address getAddressById(int addressId) {
        return this.address.getAddressById(addressId);
    }

    @Override
    public List<Address> getAllAddress() {
        return this.address.getAllAddress();
    }
}
