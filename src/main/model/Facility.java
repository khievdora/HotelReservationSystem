package main.model;

/**
 * Created by Gize on 4/19/2017.
 */
public class Facility {
    private  String code;
    private  String description;
    private  String quantity;
    private  String status;
    private  String room;

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    public String getRoom() {
        return room;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRoom(String room) {
        this.room = room;
    }
}

