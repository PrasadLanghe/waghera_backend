	package com.moonlite.model;
	
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;
	
	@Entity
	@Table(name = "combo_menus")
	public class ComboMenu {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	
	    private String name;
	    private String description;
	    private Double price;
	    private String imageUrl;
	
	//    private boolean isBestseller;
	//    private boolean isChefPick;
	    private Boolean isDeal;
	
	    public ComboMenu() {}
	
	    public ComboMenu(String name, String description, Double price, String imageUrl,
	                      Boolean isDeal) {
	        this.name = name;
	        this.description = description;
	        this.price = price;
	        this.imageUrl = imageUrl;
	//        this.isBestseller = isBestseller;
	//        this.isChefPick = isChefPick;
	        this.isDeal = isDeal;
	    }
	
	    // ---------- Getters & Setters ----------
	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }
	
	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }
	
	    public String getDescription() { return description; }
	    public void setDescription(String description) { this.description = description; }
	
	    public Double getPrice() { return price; }
	    public void setPrice(Double price) { this.price = price; }
	
	    public String getImageUrl() { return imageUrl; }
	    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
	
	//    public boolean isBestseller() { return isBestseller; }
	//    public void setBestseller(boolean bestseller) { isBestseller = bestseller; }
	//
	//    public boolean isChefPick() { return isChefPick; }
	//    public void setChefPick(boolean chefPick) { isChefPick = chefPick; }
	
	    public Boolean getIsDeal() { return isDeal; }
	    public void setIsDeal(Boolean isDeal) { this.isDeal = isDeal; }
	}
