package com.parking.example.parking.services;

import com.parking.example.parking.models.Company;
import com.parking.example.parking.repositories.CompanyEntityRepository;
import com.parking.example.parking.services.base.CRUDService;
import org.springframework.stereotype.Service;

@Service
public class CompanyService extends CRUDService<CompanyEntityRepository, Company> {
}
