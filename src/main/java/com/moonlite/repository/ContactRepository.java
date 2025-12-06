package com.moonlite.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.moonlite.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}

