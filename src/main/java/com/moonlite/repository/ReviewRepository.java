package com.moonlite.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moonlite.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    // you can add custom queries if needed
}
