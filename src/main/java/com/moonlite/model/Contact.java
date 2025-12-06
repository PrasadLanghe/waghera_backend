package com.moonlite.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data

@Builder

public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @Column(length = 1000)
    private String message;

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

	public Contact(Long id, String name, String email, String message) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.message = message;
	}

	public Contact() {
		super();
	}
    
	
	
	 public static Builder builder() {
	        return new Builder();
	    }

	    public static class Builder {

	        private Long id;
	        private String name;
	        private String email;
	        private String message;

	        public Builder id(Long id) {
	            this.id = id;
	            return this;
	        }

	        public Builder name(String name) {
	            this.name = name;
	            return this;
	        }

	        public Builder email(String email) {
	            this.email = email;
	            return this;
	        }

	        public Builder message(String message) {
	            this.message = message;
	            return this;
	        }

	        public Contact build() {
	            return new Contact(id, name, email, message);
	        }
	    }
    
}

