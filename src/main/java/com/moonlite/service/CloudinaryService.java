package com.moonlite.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CloudinaryService {

    private final Cloudinary cloudinary;

    public CloudinaryService(Cloudinary cloudinary)
    {
    	this.cloudinary=cloudinary;
    }
    
    public String uploadImage(MultipartFile file) {
        try {
            Map uploaded = cloudinary.uploader().upload(
                    file.getBytes(),
                    ObjectUtils.asMap("folder", "packages")
            );

            return uploaded.get("secure_url").toString();

        } catch (IOException e) {
            throw new RuntimeException("Image upload failed: " + e.getMessage());
        }
    }
}
