package test;

import main.dbsub.DBFacade;
import main.dbsub.DBService;
import main.model.Address;
import main.model.Guest;

import java.util.List;

/**
 * Created by Dora on 4/21/2017.
 */
public class GuestMainTest {
    public static void main(String[] args) {
        DBService dbService = new DBFacade();

        // Add new guest
        Guest guest = new Guest("1",
                "Dora",
                "",
                "Khiev",
                "12345678",
                "294837372",
                "001",
                "0984747363");
        System.out.println(guest.toString());
        dbService.saveGuest(guest);

        // Display List
        List<Guest> guestList = dbService.getAllGuest();
        guestList.forEach(System.out::print);
    }
}
