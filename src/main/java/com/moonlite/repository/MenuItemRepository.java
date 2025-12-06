package com.moonlite.repository; // Using existing repository package

// Import the new MenuItem entity
import org.springframework.data.jpa.repository.JpaRepository;

import com.moonlite.model.MenuItem;

import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
    
    // Custom method: Spring Data JPA automatically creates the query for this.
    List<MenuItem> findByCategory(String category);
}