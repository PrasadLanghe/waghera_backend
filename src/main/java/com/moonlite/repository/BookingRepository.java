//package com.moonlite.repository;
//
//
//import com.moonlite.model.Booking;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.time.LocalDate;
//import java.util.List;
//
//public interface BookingRepository extends JpaRepository<Booking, Long> {
//
//    @Query("SELECT b FROM Booking b WHERE b.room.id = :roomId AND " +
//            "(b.checkInDate < :checkOutDate AND b.checkOutDate > :checkInDate)")
//    List<Booking> findOverlappingBookings(Long roomId, LocalDate checkInDate, LocalDate checkOutDate);
//}
//


package com.moonlite.repository;

import com.moonlite.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    @Query("SELECT b FROM Booking b WHERE b.room.id = :roomId AND " +
            "(b.checkInDate < :checkOutDate AND b.checkOutDate > :checkInDate)")
    List<Booking> findOverlappingBookings(Long roomId, LocalDate checkInDate, LocalDate checkOutDate);
    
//    
//    
//    
//    @Query("""
//    	    SELECT b FROM Booking b
//    	    WHERE b.room.id = :roomId
//    	      AND b.id <> :bookingId
//    	      AND b.checkInDate < :checkOut
//    	      AND b.checkOutDate > :checkIn
//    	""")
//    	List<Booking> findOverlappingBookings(
//    	        @Param("roomId") Long roomId,
//    	        @Param("checkIn") LocalDate checkIn,
//    	        @Param("checkOut") LocalDate checkOut,
//    	        @Param("bookingId") Long bookingId
//    	);

    
//    Long countByStatus(String status);
    
    
    long count();

    // Rooms that are booked today
    @Query("SELECT COUNT(b) FROM Booking b WHERE b.checkInDate <= CURRENT_DATE AND b.checkOutDate >= CURRENT_DATE")
    Long countCurrentBookings();
    List<Booking> findAll(); 
    
//    
//    @Query("SELECT COUNT(b) FROM Booking b WHERE MONTH(b.checkIn) = :month")
//    Long countBookingsByMonth(int month);
//    
//    @Query("SELECT COUNT(b) FROM Booking b WHERE MONTH(b.checkInDate) = :month")
//    Long countByMonth(@Param("month") int month);
    
    @Query("SELECT COUNT(b) FROM Booking b WHERE MONTH(b.checkInDate) = :month")
    long countBookingsByMonth(@Param("month") int month);

    // You can also do the same for checkOutDate if needed
    @Query("SELECT COUNT(b) FROM Booking b WHERE MONTH(b.checkOutDate) = :month")
    long countCheckOutsByMonth(@Param("month") int month);


}

