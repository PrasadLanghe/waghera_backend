package com.moonlite.service;

import com.moonlite.payload.BookingRequest;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.moonlite.model.Booking;
import com.moonlite.model.RoomType;
import com.moonlite.model.User;
import com.moonlite.repository.BookingRepository;
import com.moonlite.repository.RoomTypeRepository;
import com.moonlite.repository.UserRepository;

import java.io.ByteArrayOutputStream;

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
    
    
    
    
    public byte[] generateBookingPdf(Booking booking) {

        try {

            Document document = new Document();
            ByteArrayOutputStream out = new ByteArrayOutputStream();

            PdfWriter.getInstance(document, out);
            document.open();

            // Title
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD);
            Paragraph title = new Paragraph("Booking Confirmation", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);

            document.add(new Paragraph(" "));
            document.add(new Paragraph("Booking ID: " + booking.getId()));
            document.add(new Paragraph("User Name: " + booking.getUser().getName()));
            document.add(new Paragraph("User ID: " + booking.getUser().getId()));
            document.add(new Paragraph("Room Type: " + booking.getRoomType().getTypeName()));
            document.add(new Paragraph("Check-In: " + booking.getCheckIn()));
            document.add(new Paragraph("Check-Out: " + booking.getCheckOut()));
            document.add(new Paragraph("Adults: " + booking.getAdults()));
            document.add(new Paragraph("Children: " + booking.getChildren()));
            document.add(new Paragraph("Extra Bed: " + booking.getExtraBed()));
            document.add(new Paragraph("Extra Services: " + booking.getExtraServices()));
            document.add(new Paragraph("Total Price: ₹" + booking.getTotalPrice()));
            document.add(new Paragraph("\n\n \n Waghera Agro Tourism "));

            document.close();
            return out.toByteArray();

        } catch (Exception e) {
            throw new RuntimeException("Error generating PDF: " + e.getMessage());
        }
    }
    
}
