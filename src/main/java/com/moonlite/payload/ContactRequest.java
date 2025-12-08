package com.moonlite.payload;


import lombok.Data;

<<<<<<< HEAD
@Data
=======
//@Data
>>>>>>> ee8c5a4 (Save local changes before pulling)
public class    ContactRequest {
    private String name;
    private String email;
    private String message;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
