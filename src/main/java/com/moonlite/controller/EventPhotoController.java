//// EventPhotoController.java
//
//package com.moonlite.WagheraAgro.controller;
//
//import com.moonlite.WagheraAgro.model.EventPhoto;
//import com.moonlite.WagheraAgro.service.EventPhotoService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import java.io.IOException;
//
//@RestController
//@RequestMapping("/api/events/photos")
//public class EventPhotoController {
//
//    private final EventPhotoService eventPhotoService;
//
//    public EventPhotoController(EventPhotoService eventPhotoService) {
//        this.eventPhotoService = eventPhotoService;
//    }
//
//    @PostMapping(
//            // This explicitly tells Spring this method handles multipart/form-data
//            // which is what your client is sending for the file upload.
//            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
//            // This explicitly tells Spring this method produces application/json
//            // which is what your client is requesting with Accept: application/json.
//            produces = MediaType.APPLICATION_JSON_VALUE
//    )
//    public ResponseEntity<EventPhoto> uploadPhoto(
//            // The file field in your form-data (Key: 'file')
//            @RequestParam("file") MultipartFile file,
//            // The text fields in your form-data (Keys: 'title', 'description')
//            @RequestParam("title") String title,
//            @RequestParam("description") String description)
//            throws IOException {
//
//        // Use the service you already wrote
//        EventPhoto newPhoto = eventPhotoService.uploadAndSave(file, title, description);
//
//        return new ResponseEntity<>(newPhoto, HttpStatus.CREATED);
//    }
//
//    // You'd also add GET, DELETE methods here...
//}

package com.moonlite.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import com.moonlite.model.EventPhoto;
import com.moonlite.service.EventPhotoService;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/events/photos")
@CrossOrigin(origins = "*")
public class EventPhotoController {

    private final EventPhotoService eventPhotoService;

    public EventPhotoController(EventPhotoService eventPhotoService) {
        this.eventPhotoService = eventPhotoService;
    }

    // -------------------- POST (UPLOAD PHOTO) --------------------
    @PostMapping(
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<EventPhoto> uploadPhoto(
            @RequestParam("file") MultipartFile file,
            @RequestParam("title") String title,
            @RequestParam("description") String description
    ) throws IOException {

        EventPhoto newPhoto = eventPhotoService.uploadAndSave(file, title, description);
        return new ResponseEntity<>(newPhoto, HttpStatus.CREATED);
    }

    // -------------------- GET ALL --------------------
    @GetMapping
    public ResponseEntity<List<EventPhoto>> getAll() {
        return ResponseEntity.ok(eventPhotoService.getAllPhotos());
    }

    // -------------------- GET BY ID --------------------
    @GetMapping("/{id}")
    public ResponseEntity<EventPhoto> getById(@PathVariable Long id) {
        EventPhoto photo = eventPhotoService.getPhotoById(id);
        if (photo == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(photo);
    }

    // -------------------- DELETE --------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) throws IOException {
        eventPhotoService.deletePhoto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
