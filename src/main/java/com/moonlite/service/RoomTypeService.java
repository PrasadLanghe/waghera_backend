
package com.moonlite.service;

import com.moonlite.model.RoomType;
import com.moonlite.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeService {

    private final RoomTypeRepository repo;

    public RoomTypeService(RoomTypeRepository repo) {
        this.repo = repo;
    }

    public RoomType addRoomType(RoomType type) {
        return repo.save(type);
    }

    public List<RoomType> getAllRoomTypes() {
        return repo.findAll();
    }

    public RoomType updateRoomType(Long id, RoomType updated) {
        RoomType rt = repo.findById(id).orElseThrow();
        rt.setTypeName(updated.getTypeName());
        rt.setPrice(updated.getPrice());
        return repo.save(rt);
    }

    public void deleteRoomType(Long id) {
        repo.deleteById(id);
    }
}

