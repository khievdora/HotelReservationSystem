package main.model;

import javafx.beans.property.*;

import java.sql.Date;

/**
 * Created by Gize on 4/19/2017.
 */
public class Room {
    private  StringProperty code;
    private  StringProperty roomName;
    private  IntegerProperty roomNumber;
    private  StringProperty roomStatus;
    private  IntegerProperty floor;
    private  StringProperty description;
    private  StringProperty roomType;
    private  IntegerProperty maxQuest;
    private  StringProperty status;
    private  DoubleProperty price;

    public Room(String code, String roomName, Integer roomNumber, String roomStatus, Integer floor, String description, String roomType, Integer maxQuest, String status, Double price) {
        this.code = new SimpleStringProperty(code);
        this.roomName = new SimpleStringProperty(roomName);
        this.roomNumber = new SimpleIntegerProperty(roomNumber);
        this.roomStatus = new SimpleStringProperty(roomStatus);
        this.floor = new SimpleIntegerProperty(floor);
        this.description = new SimpleStringProperty(description);
        this.roomType = new SimpleStringProperty(roomType);
        this.maxQuest = new SimpleIntegerProperty(maxQuest);
        this.status = new SimpleStringProperty(status);
        this.price = new SimpleDoubleProperty(price);
    }

    public String getCode() {
        return code.get();
    }

    public StringProperty codeProperty() {
        return code;
    }

    public void setCode(String code) {
        this.code.set(code);
    }

    public String getRoomName() {
        return roomName.get();
    }

    public StringProperty roomNameProperty() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName.set(roomName);
    }

    public int getRoomNumber() {
        return roomNumber.get();
    }

    public IntegerProperty roomNumberProperty() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber.set(roomNumber);
    }

    public String getRoomStatus() {
        return roomStatus.get();
    }

    public StringProperty roomStatusProperty() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus.set(roomStatus);
    }

    public int getFloor() {
        return floor.get();
    }

    public IntegerProperty floorProperty() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor.set(floor);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public String getRoomType() {
        return roomType.get();
    }

    public StringProperty roomTypeProperty() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType.set(roomType);
    }

    public int getMaxQuest() {
        return maxQuest.get();
    }

    public IntegerProperty maxQuestProperty() {
        return maxQuest;
    }

    public void setMaxQuest(int maxQuest) {
        this.maxQuest.set(maxQuest);
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set(status);
    }

    public double getPrice() {
        return price.get();
    }

    public DoubleProperty priceProperty() {
        return price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }
}
