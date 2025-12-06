package com.moonlite.payload.dto;

import lombok.Data;

@Data
public class PackageRequest {
    private String packageName;
    private Double price;
    private String description;
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public PackageRequest(String packageName, Double price, String description) {
		super();
		this.packageName = packageName;
		this.price = price;
		this.description = description;
	}
	public PackageRequest() {
		super();
	}
    
    
}
