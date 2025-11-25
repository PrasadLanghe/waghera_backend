package com.moonlite.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// Request body for the /api/auth/signup endpoint
public class SignUpRequest {

    @NotBlank
    @Size(min = 3, max = 100)
    private String name;

    @NotBlank
    @Size(max = 150)
    @Email
    private String email;

    @NotBlank
    @Size(min = 6, max = 40) // Passwords longer than 40 chars might exceed DB limit after hashing
    private String password;
      
   

	@NotBlank
    @Size(min = 10, max = 10) // Passwords longer than 40 chars might exceed DB limit after hashing
    private String contact;
    

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getEmail() { return email; }
    public void setEmail1(String email) { this.setEmail1(email); }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
    public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
    // Email is case-insensitive for uniqueness checks, so we normalize it
    public void setEmail(String email) { this.email = email.toLowerCase(); }
}