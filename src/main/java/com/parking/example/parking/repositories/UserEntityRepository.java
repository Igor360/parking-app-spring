package com.parking.example.parking.repositories;

import com.parking.example.parking.models.User;
import com.parking.example.parking.services.base.AuthRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends JpaRepository<User, Long>, AuthRepository<User> {

    User findByEmail(String email);
}
