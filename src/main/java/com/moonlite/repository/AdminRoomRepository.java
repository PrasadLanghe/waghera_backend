package com.moonlite.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.moonlite.model.AdminRoom;

@Repository
public interface AdminRoomRepository extends JpaRepository<AdminRoom, Long> {

//    Optional<AdminRoom> findByRoomName(String roomName);
	List<AdminRoom> findByStatus(String status);
}
