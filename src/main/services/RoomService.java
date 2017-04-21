package main.services;

import main.model.Room;

import java.util.List;

/**
 * Created by gebre on 4/20/2017.
 */
public class RoomService implements IRoomServices{
    @Override
    public boolean saveRoom(Room room) {
        return false;
    }

    @Override
    public boolean updateRoom(Room room) {
        return false;
    }

    @Override
    public boolean deleteRoomById(String roomId) {
        return false;
    }

    @Override
    public boolean deleteAllRooms() {
        return false;
    }

    @Override
    public Room getRoomById(String roomId) {
        return null;
    }

    @Override
    public List<Room> getAllRooms() {
        return null;
    }
}
