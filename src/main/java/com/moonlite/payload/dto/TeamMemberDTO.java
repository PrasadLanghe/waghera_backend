package com.moonlite.payload.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
@Data
@AllArgsConstructor
@NoArgsConstructor
=======
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
>>>>>>> ee8c5a4 (Save local changes before pulling)
public class TeamMemberDTO {
    private Long id;
    private String name;
    private String role;
    private String imageUrl;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public TeamMemberDTO(Long id, String name, String role, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
		this.imageUrl = imageUrl;
	}
	public TeamMemberDTO() {
		super();
	}
    
    
}
