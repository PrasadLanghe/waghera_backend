package com.moonlite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendRegistrationEmail(String toEmail, String userName) {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Welcome to Waghera Agro!");	
        message.setText("Hello " + userName + ",\n\nYour registration is successful!\n\nThank you.\nWaghera Agro Tourism Team");

        mailSender.send(message);
    }
    
   
    public void sendBookingConfirmation(String toEmail, String subject, String body) {
        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setTo(toEmail);
        msg.setSubject(subject);
        msg.setText(body);

        mailSender.send(msg);
    }

   
}
