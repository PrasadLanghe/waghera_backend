package com.moonlite.service.impl;


import org.springframework.stereotype.Service;

import com.moonlite.model.Review;
import com.moonlite.repository.ReviewRepository;
import com.moonlite.service.ReviewService;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public Review saveReview(Review review) {
        // Uses JpaRepository's save()
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getAllReviews() {
        // Uses JpaRepository's findAll()
        return reviewRepository.findAll();
    }

    // --- REQUIRED ADDITION ---
    @Override
    public void deleteAllReviews() {
        // Uses JpaRepository's deleteAll() to remove all records
        reviewRepository.deleteAll();
    }
    // -------------------------
}