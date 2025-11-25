package com.moonlite.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

// Request body for the /api/auth/signin endpoint
public class LoginRequest {

    @NotBlank
    @Size(max = 150)
    @Email
    private String email;

    @NotBlank
    private String password;

    // Getters and Setters
    public String getEmail() { return email; }
    public void setEmail1(String email) { this.setEmail1(email); }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    // Email is case-insensitive for lookup, so we normalize it
    public void setEmail(String email) { this.email = email.toLowerCase(); }
}