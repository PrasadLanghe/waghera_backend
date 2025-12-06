

//
//package com.moonlite.model;
//
//import jakarta.persistence.*;
//import lombok.*;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//public class EventPhoto {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    private String title;
//
//    @Column(length = 1000)
//    private String description;
//
//    private String imageUrl;
//
//    private String publicId;
//
////	public Long getId() {
////		return id;
////	}
////
////	public void setId(Long id) {
////		this.id = id;
////	}
////
////	public String getTitle() {
////		return title;
////	}
////
////	public void setTitle(String title) {
////		this.title = title;
////	}
////
////	public String getDescription() {
////		return description;
////	}
////
////	public void setDescription(String description) {
////		this.description = description;
////	}
////
////	public String getImageUrl() {
////		return imageUrl;
////	}
////
////	public void setImageUrl(String imageUrl) {
////		this.imageUrl = imageUrl;
////	}
////
////	public String getPublicId() {
////		return publicId;
////	}
////
////	public void setPublicId(String publicId) {
////		this.publicId = publicId;
////	}
//
//	
////	public EventPhoto(Long id, String title, String description, String imageUrl, String publicId) {
////		super();
////		this.id = id;
////		this.title = title;
////		this.description = description;
////		this.imageUrl = imageUrl;
////		this.publicId = publicId;
////	}
////
////	public EventPhoto() {
////		super();
////	}
//
//	
//    
//    
//    
//    
//}




package com.moonlite.model;

import jakarta.persistence.*;

@Entity
@Table(name = "event_photos")
public class EventPhoto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Column(length = 1000)
    private String description;

    private String imageUrl;

    private String publicId;

    public EventPhoto() {}

    public EventPhoto(Long id, String title, String description, String imageUrl, String publicId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.publicId = publicId;
    }

    // -------------------------
    //      MANUAL BUILDER
    // -------------------------
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String title;
        private String description;
        private String imageUrl;
        private String publicId;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder imageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Builder publicId(String publicId) {
            this.publicId = publicId;
            return this;
        }

        public EventPhoto build() {
            return new EventPhoto(id, title, description, imageUrl, publicId);
        }
    }

    // ---------------------
    // Getters & Setters
    // ---------------------
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public String getPublicId() { return publicId; }
    public void setPublicId(String publicId) { this.publicId = publicId; }
}

