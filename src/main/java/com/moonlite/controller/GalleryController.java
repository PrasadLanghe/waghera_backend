package com.moonlite.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.moonlite.model.GalleryImage;
import com.moonlite.payload.dto.ImageUploadResponse;
import com.moonlite.repository.GalleryRepository;
import com.moonlite.service.GalleryService;

import java.util.List;

@RestController
@RequestMapping("/api/gallery")
<<<<<<< HEAD
@RequiredArgsConstructor
=======

>>>>>>> ee8c5a4 (Save local changes before pulling)
@CrossOrigin(origins = "http://localhost:5173")
public class GalleryController {

    private final GalleryService galleryService;
    private final GalleryRepository galleryRepository;
    
    public GalleryController(GalleryService galleryService, GalleryRepository galleryRepository)
    {
    	this.galleryService=galleryService;
    	this.galleryRepository=galleryRepository;
    }

    @PostMapping("/upload")
    public ImageUploadResponse uploadImage(
            @RequestParam("category") String category,
            @RequestParam("file") MultipartFile file) throws Exception {

        String imageUrl = galleryService.uploadImage(category, file);

        return new ImageUploadResponse(imageUrl, category);
    }

    @GetMapping("/all")
    public List<GalleryImage> getAllImages() {
        return galleryRepository.findAll();
    }

    @GetMapping("/category/{category}")
    public List<GalleryImage> getImagesByCategory(@PathVariable String category) {
        return galleryRepository.findByCategory(category);
    }
}
