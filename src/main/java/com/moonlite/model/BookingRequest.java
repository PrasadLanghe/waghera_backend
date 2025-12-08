//package com.moonlite.model;

//
//import lombok.Data;
//import java.time.LocalDate;
//
//@Data
//public class BookingRequest {
//
//    private Long roomId;
//    private LocalDate checkInDate;
//    private LocalDate checkOutDate;
//	public Long getRoomId() {
//		return roomId;
//	}
//	public void setRoomId(Long roomId) {
//		this.roomId = roomId;
//	}
//	public LocalDate getCheckInDate() {
//		return checkInDate;
//	}
//	public void setCheckInDate(LocalDate checkInDate) {
//		this.checkInDate = checkInDate;
//	}
//	public LocalDate getCheckOutDate() {
//		return checkOutDate;
//	}
//	public void setCheckOutDate(LocalDate checkOutDate) {
//		this.checkOutDate = checkOutDate;
//	}
//	public BookingRequest(Long roomId, LocalDate checkInDate, LocalDate checkOutDate) {
//		super();
//		this.roomId = roomId;
//		this.checkInDate = checkInDate;
//		this.checkOutDate = checkOutDate;
//	}
//	public BookingRequest() {
//		super();
//	}
//	
//	
//}




package com.moonlite.model;

import lombok.Data;
import java.time.LocalDate;
import java.util.List;

<<<<<<< HEAD
@Data
=======

>>>>>>> ee8c5a4 (Save local changes before pulling)
public class BookingRequest {
	
	private String name;      // optional, to update user's name
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	private String email;     // optional, to update user's email
	private String contact; 
    private Long roomId;
    private Long userId;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private int adults;
    private int children;
    private int extraBed;            // number of extra beds
    private List<Long> serviceIds;   // ids of ExtraService
	public Long getRoomId() {
		return roomId;
	}
	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
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
	public int getAdults() {
		return adults;
	}
	public void setAdults(int adults) {
		this.adults = adults;
	}
	public int getChildren() {
		return children;
	}
	public void setChildren(int children) {
		this.children = children;
	}
	public int getExtraBed() {
		return extraBed;
	}
	public void setExtraBed(int extraBed) {
		this.extraBed = extraBed;
	}
	public List<Long> getServiceIds() {
		return serviceIds;
	}
	public void setServiceIds(List<Long> serviceIds) {
		this.serviceIds = serviceIds;
	}
	public BookingRequest(Long roomId, Long userId, LocalDate checkInDate, LocalDate checkOutDate, int adults,
			int children, int extraBed, List<Long> serviceIds , String name, String email, String contact) {
		super();
		this.roomId = roomId;
		this.userId = userId;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.adults = adults;
		this.children = children;
		this.extraBed = extraBed;
		this.serviceIds = serviceIds;
		this.name=name;
		this.email=email;
		this.contact=contact;
	}
	public BookingRequest() {
		super();
	}
    
    
}

