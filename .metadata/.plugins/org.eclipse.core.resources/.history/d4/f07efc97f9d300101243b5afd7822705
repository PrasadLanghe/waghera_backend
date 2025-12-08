package com.moonlite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.moonlite.model.User;
import com.moonlite.payload.SignUpRequest;
import com.moonlite.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {
	
	@Autowired
	private EmailService emailService;
	
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Registers a new user.
     * @param signUpRequest The sign up data.
     * @return The newly created User object.
     * @throws IllegalStateException if a user with the given email already exists.
     */
   
    @Transactional
    public User registerNewUser(SignUpRequest signUpRequest) {

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            throw new IllegalStateException("Email " + signUpRequest.getEmail() + " is already in use.");
        }

        String hashedPassword = passwordEncoder.encode(signUpRequest.getPassword());

        User newUser = new User();
        newUser.setName(signUpRequest.getName());
        newUser.setEmail(signUpRequest.getEmail());
        newUser.setPassword(hashedPassword);
        newUser.setContact(signUpRequest.getContact());

        // Save user
        User savedUser = userRepository.save(newUser);

        // 📩 SEND EMAIL AFTER REGISTRATION
        try {
            emailService.sendRegistrationEmail(
                    savedUser.getEmail(),
                    savedUser.getName()
            );
        } catch (Exception ex) {
            System.out.println("Email sending failed: " + ex.getMessage());
        }

        return savedUser;
    }

    /**
     * Finds a user by email for authentication purposes.
     * @param email The user's email.
     * @return An Optional containing the User if found.
     */
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    /**
     * Verifies the provided password against the stored hashed password.
     * @param rawPassword The password entered by the user.
     * @param encodedPassword The stored hashed password.
     * @return true if passwords match, false otherwise.
     */
    public boolean verifyPassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}