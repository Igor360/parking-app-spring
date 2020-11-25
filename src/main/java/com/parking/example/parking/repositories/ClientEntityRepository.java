package com.parking.example.parking.repositories;

import com.parking.example.parking.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientEntityRepository extends JpaRepository<Client, Long> {
}
