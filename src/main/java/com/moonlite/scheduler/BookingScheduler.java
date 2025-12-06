//package com.moonlite.scheduler;
//
//import com.moonlite.service.BookingService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class BookingScheduler {
//	
//    private final BookingService bookingService;
//    
//    public   BookingScheduler(BookingService bookingService)
//    {
//    	this.bookingService=bookingService;
//    }
//    
//
//    @Scheduled(cron = "0 0 * * * ?") // Every hour
//    public void autoCheckoutTask() {
//        bookingService.autoCheckout();
//    }
//}
