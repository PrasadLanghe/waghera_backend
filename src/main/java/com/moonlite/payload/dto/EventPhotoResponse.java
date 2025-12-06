package com.moonlite.payload.dto;

import java.time.Instant;

public class EventPhotoResponse {
    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private Instant createdAt;

    public EventPhotoResponse() { }

    public EventPhotoResponse(Long id, String title, String description, String imageUrl, Instant createdAt) {
        this.id = id; this.title = title; this.description = description; this.imageUrl = imageUrl; this.createdAt = createdAt;
    }

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

}
