package com.moonlite.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.moonlite.model.Review;
import com.moonlite.service.ReviewService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5175") 
@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    // Dependency Injection via constructor
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    /**
     * Handles POST request to create a new review with manual validation.
     * Maps to: POST /api/reviews
     */
    @PostMapping
    public ResponseEntity<?> createReview(@RequestBody Review review) { 
        
        // 1. Validation for essential fields (name and comment)
        if (review.getName() == null || review.getName().trim().isEmpty()) {
            // Use trim() to handle strings consisting only of whitespace
            return ResponseEntity.badRequest().body("Reviewer name cannot be empty.");
        }
        
        if (review.getComment() == null || review.getComment().trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Review comment cannot be empty.");
        }
        
        // 2. Validation for rating
        if (review.getRating() < 1 || review.getRating() > 5) {
            return ResponseEntity.badRequest().body("Rating must be between 1 and 5.");
        }

        try {
            Review saved = reviewService.saveReview(review);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch (Exception e) {
            // Catch unexpected database errors
            System.err.println("Error saving review: " + e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("A server error occurred while saving the review.");
        }
    }

    /**
     * Handles GET request to retrieve all reviews.
     * Maps to: GET /api/reviews
     */
    @GetMapping
    public ResponseEntity<List<Review>> getReviews() {
        return ResponseEntity.ok(reviewService.getAllReviews());
    }

    /**
     * Handles DELETE request to remove all reviews from the database.
     * Maps to: DELETE /api/reviews
     */
    @DeleteMapping
    public ResponseEntity<String> deleteAllReviews() {
        try {
            reviewService.deleteAllReviews();
            return ResponseEntity.ok("Successfully deleted all reviews from the database.");
        } catch (Exception e) {
            System.err.println("Error deleting all reviews: " + e.getMessage());
            return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Failed to delete all reviews due to a server error.");
        }
    }
}