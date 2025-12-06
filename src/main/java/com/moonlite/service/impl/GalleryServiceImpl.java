package com.moonlite.service.impl;

import com.cloudinary.Cloudinary;
import com.moonlite.model.GalleryImage;
import com.moonlite.repository.GalleryRepository;
import com.moonlite.service.GalleryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class GalleryServiceImpl implements GalleryService {

    private final GalleryRepository galleryRepository;
    private final Cloudinary cloudinary; // if using cloudinary
    
    public GalleryServiceImpl(GalleryRepository galleryRepository,Cloudinary cloudinary )
    {
    	this.galleryRepository=galleryRepository;
    	this.cloudinary=cloudinary;
    }

    @Override
    public String uploadImage(String category, MultipartFile file) throws Exception {

        // Upload to cloudinary
        var uploadResult = cloudinary.uploader().upload(file.getBytes(), Map.of());
        String imageUrl = uploadResult.get("secure_url").toString();

        // Save to DB
        GalleryImage image = new GalleryImage();
        image.setUrl(imageUrl);
        image.setCategory(category);

        galleryRepository.save(image);

        return imageUrl;
    }
}
