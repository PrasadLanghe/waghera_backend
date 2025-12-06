package com.moonlite.model;

import jakarta.persistence.*;

@Entity
@Table(name = "packages")
public class PackageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String packageName;
    private String description;
    private Double price;
    private String imageUrl;   // ✅ Added field

    public PackageEntity() {
    }

    public PackageEntity(Long id, String packageName, String description, Double price, String imageUrl) {
        this.id = id;
        this.packageName = packageName;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;   // ✅ Set field
    }

    // =============================
    // MANUAL BUILDER
    // =============================
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String packageName;
        private String description;
        private Double price;
        private String imageUrl;   // ✅ Builder field

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder packageName(String packageName) {
            this.packageName = packageName;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder price(Double price) {
            this.price = price;
            return this;
        }

        public Builder imageUrl(String imageUrl) {   // ✅ Builder method
            this.imageUrl = imageUrl;
            return this;
        }

        public PackageEntity build() {
            return new PackageEntity(id, packageName, description, price, imageUrl);
        }
    }

    // =============================
    // GETTERS & SETTERS
    // =============================
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPackageName() { return packageName; }
    public void setPackageName(String packageName) { this.packageName = packageName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getImageUrl() { return imageUrl; }  // ✅ Getter
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }  // ✅ Setter
}
