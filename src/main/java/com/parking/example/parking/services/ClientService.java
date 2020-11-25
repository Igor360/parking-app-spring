package com.parking.example.parking.services;

import com.parking.example.parking.models.Client;
import com.parking.example.parking.repositories.ClientEntityRepository;
import com.parking.example.parking.services.base.CRUDService;
import org.springframework.stereotype.Service;

@Service
public class ClientService extends CRUDService<ClientEntityRepository, Client> {
}
