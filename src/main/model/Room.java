package main.model;

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

    public void setCode(String code) {
        this.code = code;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public void setMaxQuest(int maxQuest) {
        this.maxQuest = maxQuest;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPrice(double price) {
        this.price = price;
    }



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
