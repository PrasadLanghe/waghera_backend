package com.moonlite.controller;


import com.moonlite.model.RoomType;
import com.moonlite.service.RoomTypeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/roomtype")
public class RoomTypeController {

    private final RoomTypeService service;

    public RoomTypeController(RoomTypeService service) {
        this.service = service;
    }

    // Add new room type
    @PostMapping("/add")
    public RoomType addRoomType(@RequestBody RoomType type) {
        return service.addRoomType(type);
    }

    // Get all room types
    @GetMapping("/all")
    public List<RoomType> getAll() {
        return service.getAllRoomTypes();
    }

    // Update room type
    @PutMapping("/update/{id}")
    public RoomType update(@PathVariable Long id, @RequestBody RoomType type) {
        return service.updateRoomType(id, type);
    }

    // Delete room type
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteRoomType(id);
        return "Room type deleted successfully!";
    }
}

