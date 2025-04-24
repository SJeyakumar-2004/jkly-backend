package com.example.Link.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Link.repository.UserRepository;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public boolean login(String email, String password) 
    {
        return userRepository.findByEmailAndPassword(email, password).isPresent();
    }
}

