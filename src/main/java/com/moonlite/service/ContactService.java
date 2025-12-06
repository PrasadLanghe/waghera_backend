package com.moonlite.service;



import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.moonlite.model.Contact;
import com.moonlite.payload.ContactRequest;
import com.moonlite.repository.ContactRepository;

@Service
@RequiredArgsConstructor

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

