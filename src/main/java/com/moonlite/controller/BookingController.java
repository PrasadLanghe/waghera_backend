package com.moonlite.controller;

import com.moonlite.payload.BookingRequest;
import com.moonlite.model.Booking;
import com.moonlite.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/booking")
@CrossOrigin(origins = "*")
public class BookingController {

    @Autowired
    private BookingService bookingService;

//    @PostMapping("/create")
//    public Booking createBooking(@RequestBody BookingRequest bookingRequest) {
//        return bookingService.createBooking(bookingRequest);
//    }
    
    
    
//    new code for the  pdf 
    
    @PostMapping("/create")
    public ResponseEntity<byte[]> createBookingAndDownload(@RequestBody BookingRequest req) {

        // 1. Create booking
        Booking booking = bookingService.createBooking(req);

        // 2. Generate PDF for the created booking
        byte[] pdfBytes = bookingService.generateBookingPdf(booking);

        // 3. Return PDF as response (auto-download)
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,
                        "attachment; filename=booking_" + booking.getId() + ".pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }

}
