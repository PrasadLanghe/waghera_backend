package com.moonlite.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String checkIn;
    private String checkOut;

    private int adults;
    private int children;
    private int extraBed;

    private String extraServices; // comma separated
    private Double totalPrice;

    // ⭐ MANY BOOKINGS → ONE ROOM TYPE
    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private RoomType roomType;

    // ⭐ MANY BOOKINGS → ONE USER
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	private Booking(Long id, String checkIn, String checkOut, int adults, int children, int extraBed,
			String extraServices, Double totalPrice, RoomType roomType, User user) {
		super();
		this.id = id;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.adults = adults;
		this.children = children;
		this.extraBed = extraBed;
		this.extraServices = extraServices;
		this.totalPrice = totalPrice;
		this.roomType = roomType;
		this.user = user;
	}

	public Booking() {
		super();
	}
    
    
}
