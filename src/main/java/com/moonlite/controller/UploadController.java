package com.moonlite.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.moonlite.service.ImageUploadService;

import java.util.Map; // Import Map

@RestController
// NOTE: Frontend needs to call this path: /api/images/upload
@RequestMapping("/api/images") 
@CrossOrigin(origins = "http://localhost:5173")
public class UploadController {

    private final ImageUploadService imageUploadService;

    public UploadController(ImageUploadService imageUploadService) {
        this.imageUploadService = imageUploadService;
    }

    @PostMapping("/upload")
    // Change return type to ResponseEntity<?> or ResponseEntity<Map<String, String>>
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            String imageUrl = imageUploadService.uploadImage(file);
            
            // 💡 CRITICAL: Return JSON object with 'url' key, as expected by the React frontend
            return ResponseEntity.ok(Map.of("url", imageUrl)); 
            
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(Map.of("error", "Upload failed: " + e.getMessage()));
        }
    }
}