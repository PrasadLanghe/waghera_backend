package com.moonlite.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "extra_services")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExtraService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // price per night
    private double pricePerNight;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	public ExtraService(Long id, String name, double pricePerNight) {
		super();
		this.id = id;
		this.name = name;
		this.pricePerNight = pricePerNight;
	}

	public ExtraService() {
		super();
	}
	
	
}
