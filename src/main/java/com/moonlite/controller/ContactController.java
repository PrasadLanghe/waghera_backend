package com.moonlite.controller;



import com.moonlite.payload.*;
import com.moonlite.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contact")
<<<<<<< HEAD
@RequiredArgsConstructor
=======

>>>>>>> ee8c5a4 (Save local changes before pulling)
@CrossOrigin("*")
public class ContactController {

    private final ContactService contactService;
    
    
    public ContactController(ContactService contactService)
    {
    	this.contactService=contactService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestBody ContactRequest request) {
        String response = contactService.saveMessage(request);
        return ResponseEntity.ok(response);
    }
}

