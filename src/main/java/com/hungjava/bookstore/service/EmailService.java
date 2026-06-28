package com.hungjava.bookstore.service;

public interface EmailService {
    void sendActivationEmail(String toEmail,String username,String activationLink);
}
