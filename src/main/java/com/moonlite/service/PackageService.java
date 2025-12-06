package com.moonlite.service;


import org.springframework.web.multipart.MultipartFile;

import com.moonlite.model.PackageEntity;
import com.moonlite.payload.dto.PackageRequest;

import java.util.List;

public interface PackageService {

    PackageEntity createPackage(PackageRequest request, MultipartFile image);

    List<PackageEntity> getAllPackages();

    PackageEntity getPackage(Long id);

    PackageEntity updatePackage(Long id, PackageRequest request, MultipartFile image);

    void deletePackage(Long id);
}
