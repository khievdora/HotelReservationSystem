package java.model;

import java.sql.Date;

/**
 * Created by Gize on 4/19/2017.
 */
public class Room {
    private String code;
    private  String roomName;
    private  int roomNumber;
    private  String roomStatus;
    private  int floor;
    private  String description;
    private  String roomType;
    private  int maxQuest;
    private  String status;
    private  double price;

    public String getCode() {
        return code;
    }

    public String getRoomName() {
        return roomName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public int getFloor() {
        return floor;
    }

    public String getDescription() {
        return description;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getMaxQuest() {
        return maxQuest;
    }

    public String getStatus() {
        return status;
    }

    public double getPrice() {
        return price;
    }
}
