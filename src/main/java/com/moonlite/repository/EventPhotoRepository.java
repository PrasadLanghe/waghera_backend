package com.moonlite.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.moonlite.model.EventPhoto;

public interface EventPhotoRepository extends JpaRepository<EventPhoto, Long> {
}
