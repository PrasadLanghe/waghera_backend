package com.moonlite.service;



<<<<<<< HEAD
import lombok.Builder;
=======
>>>>>>> ee8c5a4 (Save local changes before pulling)
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.moonlite.model.Contact;
import com.moonlite.payload.ContactRequest;
import com.moonlite.repository.ContactRepository;

@Service
<<<<<<< HEAD
@RequiredArgsConstructor
=======

>>>>>>> ee8c5a4 (Save local changes before pulling)

public class ContactService {

    private final ContactRepository contactRepository;
    
    
    public ContactService(ContactRepository contactRepository)
    {
    	this.contactRepository=contactRepository;
    }

    public String saveMessage(ContactRequest request) {

        Contact contact = Contact.builder()
                .name(request.getName())
                .email(request.getEmail())
                .message(request.getMessage())
                .build();

        contactRepository.save(contact);

        return "Message sent successfully!";
    }
}

