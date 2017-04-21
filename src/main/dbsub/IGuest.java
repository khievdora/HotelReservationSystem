package main.dbsub;

import main.model.Guest;

import java.util.List;

/**
 * Created by Dora on 4/21/2017.
 */
public interface IGuest {
    public int saveGuest(Guest guest);
    public boolean updateGuest(Guest guest);
    public boolean deleteGuestById(String guestId);
    public boolean deleteAllGuest();
    public Guest getGuestById(String guestId);
    public List<Guest> getAllGuest();

}
