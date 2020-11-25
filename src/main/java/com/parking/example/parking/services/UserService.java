package com.parking.example.parking.services;

import com.parking.example.parking.models.User;
import com.parking.example.parking.repositories.UserEntityRepository;
import com.parking.example.parking.services.base.AuthManager;
import org.springframework.stereotype.Service;

@Service
public class UserService extends AuthManager<UserEntityRepository, User> {

    public User findByEmail(String email) {
        return this.repository.findByEmail(email);
    }
}
