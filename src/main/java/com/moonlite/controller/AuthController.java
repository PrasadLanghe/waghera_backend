	package com.moonlite.controller;
	
	
	
	import jakarta.validation.Valid;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;
	
	import com.moonlite.model.User;
	import com.moonlite.payload.LoginRequest;
	import com.moonlite.payload.SignUpRequest;
	import com.moonlite.service.UserService;

import java.util.Map;
import java.util.Optional;
	
	// Base path for all authentication related endpoints
	@RestController
	@RequestMapping("/api/auth")
	public class AuthController {
	
	    private final UserService userService;
	
	    @Autowired
	    public AuthController(UserService userService) {
	        this.userService = userService;
	    }
	
	    /**
	     * Endpoint to handle user registration (Sign Up).
	     * The front-end POSTs to this endpoint with name, email, and password.
	     */
	    @PostMapping("/signup")
	    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
	        try {
	            User newUser = userService.registerNewUser(signUpRequest);
	            // Return a success response with the ID of the new user (or a simple success message)
	            return new ResponseEntity<>("User registered successfully! ID: " + newUser.getId(), HttpStatus.CREATED);
	        } catch (IllegalStateException e) {
	            // Handle case where email is already in use
	            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	        } catch (Exception e) {
	            // General error handling
	            return new ResponseEntity<>("Registration failed due to an internal error.", HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	
	    /**
	     * Endpoint to handle user login (Sign In).
	     * Note: This is a basic implementation. In a real app, successful login would generate a JWT or a Session.
	     */
//	    @PostMapping("/signin")
//	    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
//	        // 1. Find the user by email
//	        Optional<User> userOptional = userService.findByEmail(loginRequest.getEmail());
//	
//	        if (userOptional.isEmpty()) {
//	            return new ResponseEntity<>("Login failed: Invalid email or password.", HttpStatus.UNAUTHORIZED);
//	        }
//	
//	        User user = userOptional.get();
//	
//	        // 2. Verify the password
//	        if (userService.verifyPassword(loginRequest.getPassword(), user.getPassword())) {
//	            // Successful login
//	            // TODO: For a full solution, generate and return a JWT here
//	            return new ResponseEntity<>("Login successful! Welcome, " + user.getName(), HttpStatus.OK);
//	        } else {
//	            // Password verification failed
//	            return new ResponseEntity<>("Login failed: Invalid email or password.", HttpStatus.UNAUTHORIZED);
//	        }
//	    }
	    
	    @PostMapping("/signin")
	    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

	        Optional<User> userOptional = userService.findByEmail(loginRequest.getEmail());

	        if (userOptional.isEmpty()) {
	            return new ResponseEntity<>(Map.of(
	                    "success", false,
	                    "message", "Invalid email or password"
	            ), HttpStatus.UNAUTHORIZED);
	        }

	        User user = userOptional.get();

	        if (userService.verifyPassword(loginRequest.getPassword(), user.getPassword())) {

	            return ResponseEntity.ok(Map.of(
	                    "success", true,
	                    "id", user.getId(),
	                    "name", user.getName(),
	                    "email", user.getEmail(),
	                    "message", "Login successful!"
	            ));
	        }

	        return new ResponseEntity<>(Map.of(
	                "success", false,
	                "message", "Invalid email or password"
	        ), HttpStatus.UNAUTHORIZED);
	    }

	}