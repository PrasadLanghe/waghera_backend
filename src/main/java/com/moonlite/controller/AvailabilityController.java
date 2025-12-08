package com.moonlite.controller;


import com.moonlite.model.AdminRoom;
import com.moonlite.payload.AvailabilityRequest;
import com.moonlite.service.AvailabilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/availability")
@CrossOrigin(origins = "*")
<<<<<<< HEAD
@RequiredArgsConstructor
=======

>>>>>>> ee8c5a4 (Save local changes before pulling)
public class AvailabilityController {

    private final AvailabilityService availabilityService;

    public AvailabilityController(AvailabilityService availabilityService)
    {
    	this.availabilityService=availabilityService;
    }
    @PostMapping
    public ResponseEntity<List<AdminRoom>> checkAvailability(@RequestBody AvailabilityRequest request) {
        return ResponseEntity.ok(availabilityService.checkAvailability(request));
    }
}
