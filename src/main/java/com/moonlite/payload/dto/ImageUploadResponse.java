package com.moonlite.payload.dto;

<<<<<<< HEAD
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
=======

import lombok.Data;

//@Data
//@AllArgsConstructor
>>>>>>> ee8c5a4 (Save local changes before pulling)
public class ImageUploadResponse {
    private String url;
    private String category;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public ImageUploadResponse(String url, String category) {
		super();
		this.url = url;
		this.category = category;
	}
	public ImageUploadResponse() {
		super();
	}
    
    
}
