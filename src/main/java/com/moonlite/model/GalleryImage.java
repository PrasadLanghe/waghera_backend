package com.moonlite.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "gallery_images")
public class GalleryImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // ← MISSING BEFORE

    private String url;
    private String category;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public GalleryImage(Long id, String url, String category) {
		super();
		this.id = id;
		this.url = url;
		this.category = category;
	}
	public GalleryImage() {
		super();
	}
    
    
}
