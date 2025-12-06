package com.moonlite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.moonlite.model.AdminRoom;

@Repository
public interface RoomRepository extends JpaRepository<AdminRoom, Long> {
    // Optional: custom query method
     List<AdminRoom> findByStatus(String status);
}
