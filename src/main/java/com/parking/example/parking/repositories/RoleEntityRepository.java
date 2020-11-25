package com.parking.example.parking.repositories;

import com.parking.example.parking.models.enums.ERole;
import com.parking.example.parking.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleEntityRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
