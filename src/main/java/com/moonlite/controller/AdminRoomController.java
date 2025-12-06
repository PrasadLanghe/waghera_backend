package com.moonlite.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.moonlite.model.AdminRoom;
import com.moonlite.service.AdminRoomService;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/admin/rooms")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class AdminRoomController {

    private final AdminRoomService roomService;
    
    public AdminRoomController(AdminRoomService roomService)
    {
    	this.roomService=roomService;
    }
    @PostMapping
    public ResponseEntity<AdminRoom> createRoom(@RequestBody AdminRoom room) {
        AdminRoom saved = roomService.addRoom(room);
        return ResponseEntity.created(URI.create("/api/admin/rooms/" + saved.getId())).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AdminRoom> updateRoom(@PathVariable Long id, @RequestBody AdminRoom room) {
        AdminRoom updated = roomService.updateRoom(id, room);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Long id) {
        roomService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AdminRoom> getRoom(@PathVariable Long id) {
        return ResponseEntity.ok(roomService.getRoom(id));
    }

    @GetMapping
    public ResponseEntity<List<AdminRoom>> getAllRooms() {
        return ResponseEntity.ok(roomService.getAllRooms());
    }
}
