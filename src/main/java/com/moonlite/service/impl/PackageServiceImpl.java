package com.moonlite.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.moonlite.model.PackageEntity;
import com.moonlite.payload.dto.PackageRequest;
import com.moonlite.repository.PackageRepository;
import com.moonlite.service.CloudinaryService;
import com.moonlite.service.PackageService;

import java.util.List;

@Service
@RequiredArgsConstructor
public  class PackageServiceImpl implements PackageService{
    private final PackageRepository packageRepository;
    private final CloudinaryService cloudinaryService;
    
    
    public PackageServiceImpl(PackageRepository packageRepository,CloudinaryService cloudinaryService)
    {
    	this.cloudinaryService=cloudinaryService;
    	this.packageRepository=packageRepository;
    }

    @Override
    public PackageEntity createPackage(PackageRequest request, MultipartFile image) {

        String imageUrl = cloudinaryService.uploadImage(image);

        PackageEntity pkg = PackageEntity.builder()
                .packageName(request.getPackageName())
                .price(request.getPrice())
                .description(request.getDescription())
                .imageUrl(imageUrl)
                .build();

        return packageRepository.save(pkg);
    }

    @Override
    public List<PackageEntity> getAllPackages() {
        return packageRepository.findAll();
    }

    @Override
    public PackageEntity getPackage(Long id) {
        return packageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Package not found"));
    }

    @Override
    public PackageEntity updatePackage(Long id, PackageRequest request, MultipartFile image) {
        PackageEntity pkg = getPackage(id);

        pkg.setPackageName(request.getPackageName());
        pkg.setPrice(request.getPrice());
        pkg.setDescription(request.getDescription());

        if (image != null && !image.isEmpty()) {
            String newImage = cloudinaryService.uploadImage(image);
            pkg.setImageUrl(newImage);
        }

        return packageRepository.save(pkg);
    }

    @Override
    public void deletePackage(Long id) {
        packageRepository.deleteById(id);
    }
}
