package com.moonlite.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageUploadService {
    
    /**
     * Handles the file upload process and returns the permanent URL of the image.
     * @param file The image file received from the client.
     * @return The secure URL of the uploaded image on Cloudinary.
     * @throws IOException If file handling fails.
     */
    String uploadImage(MultipartFile file) throws IOException;
}