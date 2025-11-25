package com.moonlite.payload;

import lombok.Data;

@Data
public class BookingRequest {

    private Long userId;
    private Long roomTypeId;

    private String checkIn;
    private String checkOut;

    private int adults;
    private int children;
    private int extraBed;

    private String extraServices;
    private Double totalPrice;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getRoomTypeId() {
		return roomTypeId;
	}
	public void setRoomTypeId(Long roomTypeId) {
		this.roomTypeId = roomTypeId;
	}
	public String getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	public String getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
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
	public String getExtraServices() {
		return extraServices;
	}
	public void setExtraServices(String extraServices) {
		this.extraServices = extraServices;
	}
	public Double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
}
