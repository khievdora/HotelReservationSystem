package main.services;

import main.model.Room;

import java.util.List;

/**
 * Created by gebre on 4/20/2017.
 */
public interface IRoomServices {
    // CRUD Room    save = add
    public boolean saveRoom(Room room);
    public boolean updateRoom(Room room);
    public boolean deleteRoomById(String roomId);
    public boolean deleteAllRooms();
    public Room getRoomById(String roomId);
    public List<Room> getAllRooms();

}
