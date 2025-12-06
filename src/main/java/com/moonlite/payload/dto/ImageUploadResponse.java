package com.moonlite.payload.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
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
