package com.parking.example.parking.http.controllers;

import com.parking.example.parking.http.requests.client.ClientAccountRequest;
import com.parking.example.parking.http.responses.auth.UserResponse;
import com.parking.example.parking.http.responses.profile.ClientResponse;
import com.parking.example.parking.models.Client;
import com.parking.example.parking.models.User;
import com.parking.example.parking.security.services.UserDetailsImpl;
import com.parking.example.parking.services.ClientService;
import com.parking.example.parking.services.UserService;
import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/profile")
public class ProfileController {

    @Autowired
    UserService userService;

    @Autowired
    ClientService clientService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping
    public ResponseEntity<?> index() {
        UserResponse response = modelMapper.map(this.getAuthUser(), UserResponse.class);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/client/add")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void createClientProfile(@Valid @RequestBody ClientAccountRequest request) {
        Client client = modelMapper.map(request, Client.class);
        client.setUser(userService.findByEmail(this.getAuthUser().getEmail()));
        clientService.save(client);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<?> getClientProfile(@PathVariable("id") Long id) {
        Client client = clientService.get(id);
        ClientResponse response = modelMapper.map(client, ClientResponse.class);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/client/delete/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteClientProfile(@PathVariable("id") Long id) {
        clientService.remove(id);
    }

    @PutMapping("/client/edit/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void updateClientProfile(@PathVariable("id") Long id, @Valid @RequestBody ClientAccountRequest request) {
        Client client = clientService.get(id);
        modelMapper.map(request, client);
        clientService.save(client);
    }

    @GetMapping("/client/all")
    public ResponseEntity<?> getUserClients() {
        User user = userService.findByEmail(this.getAuthUser().getEmail());
        return ResponseEntity.ok(user.getClientProfiles().stream().map(this::convertToClientResponse).collect(Collectors.toList()));
    }

    private ClientResponse convertToClientResponse(Client client) {
        return modelMapper.map(client, ClientResponse.class);
    }

    private UserDetailsImpl getAuthUser() {
        return (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
    }
}
