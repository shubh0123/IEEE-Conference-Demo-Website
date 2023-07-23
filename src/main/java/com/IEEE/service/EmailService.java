package com.IEEE.service;


import com.IEEE.entity.EmailDetails;

public interface EmailService {
    String sendSimpleMail(EmailDetails details);
}
