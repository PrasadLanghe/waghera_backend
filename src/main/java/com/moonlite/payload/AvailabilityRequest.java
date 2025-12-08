package com.moonlite.payload;


import lombok.Data;
import java.time.LocalDate;

<<<<<<< HEAD
@Data
=======
//@Data
>>>>>>> ee8c5a4 (Save local changes before pulling)
public class AvailabilityRequest {

    private LocalDate checkInDate;
    private LocalDate checkOutDate;
	public LocalDate getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}
	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public AvailabilityRequest(LocalDate checkInDate, LocalDate checkOutDate) {
		super();
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
	}
	public AvailabilityRequest() {
		super();
	}
    
    
}

