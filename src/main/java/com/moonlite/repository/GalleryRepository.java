package com.moonlite.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.moonlite.model.GalleryImage;

import java.util.List;

public interface GalleryRepository extends JpaRepository<GalleryImage, Long> {
    List<GalleryImage> findByCategory(String category);
}
