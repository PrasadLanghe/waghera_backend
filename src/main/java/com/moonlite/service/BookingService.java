package com.moonlite.service;

import com.moonlite.payload.BookingRequest;
import com.moonlite.model.Booking;
import com.moonlite.model.RoomType;
import com.moonlite.model.User;
import com.moonlite.repository.BookingRepository;
import com.moonlite.repository.RoomTypeRepository;
import com.moonlite.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private RoomTypeRepository roomTypeRepo;

    @Autowired
    private UserRepository userRepo;

    public Booking createBooking(BookingRequest req) {

        RoomType roomType = roomTypeRepo.findById(req.getRoomTypeId())
                .orElseThrow(() -> new RuntimeException("Room Type not found"));

        User user = userRepo.findById(req.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Booking booking = new Booking();
        booking.setCheckIn(req.getCheckIn());
        booking.setCheckOut(req.getCheckOut());
        booking.setAdults(req.getAdults());
        booking.setChildren(req.getChildren());
        booking.setExtraBed(req.getExtraBed());
        booking.setExtraServices(req.getExtraServices());
        booking.setTotalPrice(req.getTotalPrice());

        booking.setRoomType(roomType);
        booking.setUser(user);

        return bookingRepo.save(booking);
    }
}
