



package com.moonlite.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "activities")
public class Activity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String imageUrl;

    @Column(columnDefinition = "LONGTEXT")
    private String description;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Activity(Long id, String title, String imageUrl, String description) {
		super();
		this.id = id;
		this.title = title;
		this.imageUrl = imageUrl;
		this.description = description;
	}

	public Activity() {
		super();
	}
	
	

}
