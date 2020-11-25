package com.parking.example.parking.services.base;

import java.util.Optional;

public interface AuthRepository<T> {

    Optional<T> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
