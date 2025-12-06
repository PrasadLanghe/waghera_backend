package com.moonlite.service;

import com.moonlite.model.AdminRoom;
import java.util.List;

public interface AdminRoomService {
    AdminRoom addRoom(AdminRoom room);
    AdminRoom updateRoom(Long id, AdminRoom room);
    void deleteRoom(Long id);
    AdminRoom getRoom(Long id);
    List<AdminRoom> getAllRooms();
}
