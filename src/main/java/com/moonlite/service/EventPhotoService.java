
package com.moonlite.service;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.moonlite.model.EventPhoto;
import com.moonlite.repository.EventPhotoRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class EventPhotoService {

    private final EventPhotoRepository eventPhotoRepository;
    private final Cloudinary cloudinary;

    public EventPhotoService(EventPhotoRepository eventPhotoRepository, Cloudinary cloudinary) {
        this.eventPhotoRepository = eventPhotoRepository;
        this.cloudinary = cloudinary;
    }

    public EventPhoto uploadAndSave(MultipartFile file, String title, String description) throws IOException {

        Map uploadResult = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());

        String imageUrl = uploadResult.get("url").toString();
        String publicId = uploadResult.get("public_id").toString();

        EventPhoto photo = EventPhoto.builder()
                .title(title)
                .description(description)
                .imageUrl(imageUrl)
                .publicId(publicId)
                .build();

        return eventPhotoRepository.save(photo);
    }

    public List<EventPhoto> getAllPhotos() {
        return eventPhotoRepository.findAll();
    }

    public EventPhoto getPhotoById(Long id) {
        return eventPhotoRepository.findById(id).orElse(null);
    }

    public void deletePhoto(Long id) throws IOException {
        EventPhoto photo = eventPhotoRepository.findById(id).orElse(null);

        if (photo == null) return;

        cloudinary.uploader().destroy(photo.getPublicId(), ObjectUtils.emptyMap());

        eventPhotoRepository.deleteById(id);
    }
}
