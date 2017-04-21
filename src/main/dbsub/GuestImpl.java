package main.dbsub;

import main.model.Guest;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dora on 4/21/2017.
 */
public class GuestImpl implements IGuest {

    private IDatabase database = Database.getInstance();

    @Override
    public int saveGuest(Guest guest) {
        int result = 0;
        try{
            String sql = "INSERT INTO guest (idGuest, firstName, middleName, lastName, idCard, passport, address1, " +
                    "phone) VALUES ("+ guest.getCode() +",'"+ guest.getfName() + "','" + guest.getmName()+"','"+
                    guest.getlName() + "','"+ guest.getIdCard() + "','" + guest.getPassport() +"','" + guest.getAddress() +
                    "','" + guest.getPhone() +"')";
            result = this.database.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.database.closeConnection();
        }
        return result;
    }

    @Override
    public boolean updateGuest(Guest guest) {
        boolean result = false;
        try{
            String sql = "UPDATE guest SET firstName = '" + guest.getfName() +"'," +
                    "middleName = '" + guest.getmName() + "'," +
                    "lastName = '" + guest.getlName() + "'," +
                    "idCard = '" + guest.getIdCard() + "'," +
                    "passport = '" + guest.getPassport() + "'," +
                    "address1 = '" + guest.getAddress() + "'," +
                    "phone = '" + guest.getPhone() + "' WHERE idGuest = '" + guest.getCode() + "'";
            this.database.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.database.closeConnection();
        }
        return result;
    }

    @Override
    public boolean deleteGuestById(String guestId) {
        try {
            String sql = "DELETE FROM guest WHERE idGuest = '" + guestId + "'";
            this.database.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.database.closeConnection();
        }
        return false;
    }

    @Override
    public boolean deleteAllGuest() {
        try {
            String sql = "DELETE * FROM guest";
            this.database.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.database.closeConnection();
        }
        return false;
    }

    @Override
    public Guest getGuestById(String guestId) {
        Guest guest = null;
        try {
            String sql = "SELECT * FROM guest WHERE idGuest = '" + guestId + "' LIMIT 1";
            ResultSet rs = this.database.executeQuery(sql);
//            guest = new Guest(String.valueOf(rs.getInt(1)),
//                    rs.getString(2),
//                    rs.getString(3),
//                    rs.getString(3),
//                    rs.getString(5),
//                    rs.getString(6),
//                    rs.getString(7),
//                    rs.getString(8));
        }catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.database.closeConnection();
        }
        return guest;
    }

    @Override
    public List<Guest> getAllGuest() {
        List<Guest> guestList = new ArrayList<>();
        Guest guest = null;
        try {
            String sql = "SELECT * FROM guest";
            ResultSet rs = this.database.executeQuery(sql);
            while(rs.next()) {
//                guest = new Guest(String.valueOf(rs.getInt(1)),
//                        rs.getString(2),
//                        rs.getString(3),
//                        rs.getString(3),
//                        rs.getString(5),
//                        rs.getString(6),
//                        rs.getString(7),
//                        rs.getString(8));
                guestList.add(guest);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.database.closeConnection();
        }
        return guestList;
    }
}
