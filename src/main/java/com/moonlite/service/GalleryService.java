package com.moonlite.service;

import org.springframework.web.multipart.MultipartFile;

public interface GalleryService {
    String uploadImage(String category, MultipartFile file) throws Exception;
}
