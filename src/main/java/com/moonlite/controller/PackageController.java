package com.moonlite.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import com.moonlite.model.PackageEntity;
import com.moonlite.payload.dto.PackageRequest;
import com.moonlite.service.PackageService;

import java.util.Map;


@RestController
@RequestMapping("/api/admin/package")
<<<<<<< HEAD
@RequiredArgsConstructor
=======

>>>>>>> ee8c5a4 (Save local changes before pulling)
@PreAuthorize("hasRole('ADMIN')")

public class PackageController {
	
	 private final PackageService packageService;

	public PackageController(PackageService packageService)
	{
		this.packageService=packageService;
	}

   

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> createPackage(
            @RequestParam("packageName") String packageName,
            @RequestParam("price") Double price,
            @RequestParam("description") String description,
            @RequestParam("image") MultipartFile image
    ) {
        PackageRequest request = new PackageRequest();
        request.setPackageName(packageName);
        request.setPrice(price);
        request.setDescription(description);

        PackageEntity pkg = packageService.createPackage(request, image);

        return ResponseEntity.ok(Map.of("success", true, "package", pkg));
    }


//    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    public ResponseEntity<?> createPackage(
//            @RequestPart("data") PackageRequest request,
//            @RequestPart("image") MultipartFile image
//    ) {
//        PackageEntity pkg = packageService.createPackage(request, image);
//        return ResponseEntity.ok(Map.of("success", true, "package", pkg));
//    }

    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(Map.of("success", true, "packages", packageService.getAllPackages()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return ResponseEntity.ok(Map.of("success", true, "package", packageService.getPackage(id)));
    }

    @PutMapping(value = "/update/{id}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> updatePackage(
            @PathVariable Long id,
            @RequestPart("data") PackageRequest request,
            @RequestPart(value = "image", required = false) MultipartFile image
    ) {
        PackageEntity pkg = packageService.updatePackage(id, request, image);
        return ResponseEntity.ok(Map.of("success", true, "package", pkg));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePackage(@PathVariable Long id) {
        packageService.deletePackage(id);
        return ResponseEntity.ok(Map.of("success", true, "message", "Package deleted"));
    }
}
