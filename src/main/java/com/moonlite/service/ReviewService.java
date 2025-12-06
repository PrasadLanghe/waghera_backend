package com.moonlite.service;


import java.util.List;

import com.moonlite.model.Review;

public interface ReviewService {
    Review saveReview(Review review);
    List<Review> getAllReviews();
	void deleteAllReviews();
}
