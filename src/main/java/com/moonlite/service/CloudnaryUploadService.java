package com.moonlite.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Service
public class CloudnaryUploadService implements ImageUploadService {

    // Spring will automatically inject the Cloudinary bean configured in CloudinaryConfig
    private final Cloudinary cloudinary;

    @Autowired
    public CloudnaryUploadService(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public String uploadImage(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IOException("File must not be empty.");
        }

        File uploadedFile = null;
        try {
            // 1. Convert Spring's MultipartFile to java.io.File (required by Cloudinary SDK)
            uploadedFile = convertMultiPartToFile(file);

            // 2. Upload to Cloudinary using the secure client
            Map uploadResult = cloudinary.uploader().upload(
                    uploadedFile,
                    ObjectUtils.asMap(
                        "folder", "combo-menu",       // Organizes files in Cloudinary
                        "resource_type", "auto"       // Auto-detect resource type
                    )
            );

            // 3. Extract the secure URL and return it
            return (String) uploadResult.get("secure_url");

        } catch (Exception e) {
            // Log the error for debugging purposes
            System.err.println("Cloudinary upload failed: " + e.getMessage());
            throw new IOException("Failed to communicate with Cloudinary or process upload.", e);
        } finally {
            // 4. Clean up the temporary file created on the server
            if (uploadedFile != null && uploadedFile.exists()) {
                uploadedFile.delete();
            }
        }
    }

    /**
     * Helper method to convert MultipartFile to File
     */
    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        // Creates a new file instance in the system's default temporary directory
        File convFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        try (FileOutputStream fos = new FileOutputStream(convFile)) {
            fos.write(file.getBytes());
        }
        return convFile;
    }
}