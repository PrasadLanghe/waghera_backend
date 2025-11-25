package com.moonlite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.moonlite.model.*;
import java.util.Optional;

// JpaRepository provides CRUD operations automatically
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // Custom query method: finds a user by their email, used for login and registration check
    Optional<User> findByEmail(String email);

    // Checks if a user with the given email already exists
    Boolean existsByEmail(String email);
}
