package com.moonlite.controller;

import java.util.HashMap;
import java.util.Map;


import com.moonlite.repository.AdminRoomRepository;
import com.moonlite.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin(origins = "*")
<<<<<<< HEAD
@RequiredArgsConstructor
=======

>>>>>>> ee8c5a4 (Save local changes before pulling)
public class DashboardController {

    private final BookingRepository bookingRepository;
    private final AdminRoomRepository roomRepository;

    
    public DashboardController(BookingRepository bookingRepository,AdminRoomRepository roomRepository)
    {
    	this.bookingRepository=bookingRepository;
    	this.roomRepository=roomRepository;
    }
    @GetMapping("/room-stats")
    public Map<String, Long> getStats() {

        Long totalRooms = roomRepository.count();
        Long bookedToday = bookingRepository.countCurrentBookings();
        Long available = totalRooms - bookedToday;
        Long totalBookings = bookingRepository.count();

        Map<String, Long> data = new HashMap<>();
        data.put("totalRooms", totalRooms);
        data.put("bookedToday", bookedToday);
        data.put("availableRooms", available);
        data.put("totalBookings", totalBookings);

        return data;
    }
    
    
    @GetMapping("/monthly-bookings")
    public List<Map<String, Object>> getMonthlyBookings() {
        List<Map<String, Object>> result = new ArrayList<>();

        for (int month = 1; month <= 12; month++) {
            Long count = bookingRepository.countBookingsByMonth(month);

            Map<String, Object> row = new HashMap<>();
            row.put("month", getMonthName(month));
            row.put("Booked", count);

            result.add(row);
        }
        return result;
    }


    private String getMonthName(int month) {
        return new java.text.DateFormatSymbols().getShortMonths()[month - 1];
    }

}
