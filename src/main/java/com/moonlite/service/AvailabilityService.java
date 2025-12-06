package com.moonlite.service;


import com.moonlite.model.AdminRoom;
import com.moonlite.payload.AvailabilityRequest;
import com.moonlite.repository.AdminRoomRepository;
import com.moonlite.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AvailabilityService {

    private final AdminRoomRepository roomRepo;
    private final BookingRepository bookingRepo;

    public AvailabilityService(AdminRoomRepository roomRepo, BookingRepository bookingRepo)
    {
    	this.roomRepo=roomRepo;
    	this.bookingRepo=bookingRepo;
    }
    public List<AdminRoom> checkAvailability(AvailabilityRequest request) {

        List<AdminRoom> allRooms = roomRepo.findAll();
        List<AdminRoom> availableRooms = new ArrayList<>();

        for (AdminRoom room : allRooms) {

            // CONDITION 1: room must be AVAILABLE
            if (!room.getStatus().name().equals("AVAILABLE")) {
                continue;
            }

            // CONDITION 2: no overlapping bookings
            boolean hasOverlap = !bookingRepo
                    .findOverlappingBookings(room.getId(),
                            request.getCheckInDate(),
                            request.getCheckOutDate())
                    .isEmpty();

            if (!hasOverlap) {
                availableRooms.add(room);
            }
        }

        return availableRooms;
    }
}
