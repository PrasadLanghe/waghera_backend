package com.moonlite.payload;


import lombok.Data;
import java.time.LocalDate;

@Data
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

