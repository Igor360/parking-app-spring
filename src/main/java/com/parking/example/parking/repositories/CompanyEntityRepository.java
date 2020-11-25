package com.parking.example.parking.repositories;

import com.parking.example.parking.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyEntityRepository extends JpaRepository<Company, Long> {
}
