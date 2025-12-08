package com.moonlite.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.moonlite.model.AdminRoom;
import com.moonlite.repository.AdminRoomRepository;
import com.moonlite.service.AdminRoomService;
import com.moonlite.exception.ResourceNotFoundException;
import java.util.List;

@Service
<<<<<<< HEAD
@RequiredArgsConstructor
=======

>>>>>>> ee8c5a4 (Save local changes before pulling)
@Transactional
public class AdminRoomServiceImpl implements AdminRoomService {

    private final AdminRoomRepository roomRepository;

    public AdminRoomServiceImpl(AdminRoomRepository roomRepository)
    {
    	this.roomRepository=roomRepository;
    }
    @Override
    public AdminRoom addRoom(AdminRoom room) {
        return roomRepository.save(room);
    }

    @Override
    public AdminRoom updateRoom(Long id, AdminRoom updatedRoom) {
        AdminRoom existing = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with id: " + id));

        existing.setRoomName(updatedRoom.getRoomName());
        existing.setType(updatedRoom.getType());
        existing.setPrice(updatedRoom.getPrice());
        existing.setStatus(updatedRoom.getStatus());
        return roomRepository.save(existing);
    }

    @Override
    public void deleteRoom(Long id) {
        AdminRoom existing = roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with id: " + id));
        roomRepository.delete(existing);
    }

    @Override
    public AdminRoom getRoom(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Room not found with id: " + id));
    }

    @Override
    public List<AdminRoom> getAllRooms() {
        return roomRepository.findAll();
    }
}

