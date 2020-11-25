package com.parking.example.parking.services.base;

import com.parking.example.parking.exceptions.BadRequestExceptions;
import com.parking.example.parking.exceptions.InvalidRepositoryException;
import com.parking.example.parking.http.requests.auth.RegisterRequest;
import com.parking.example.parking.http.responses.auth.JwtResponse;
import com.parking.example.parking.http.responses.auth.RegisterResponse;
import com.parking.example.parking.http.responses.auth.UserResponse;
import com.parking.example.parking.models.User;
import com.parking.example.parking.security.jwt.JwtUtils;
import com.parking.example.parking.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

abstract public class AuthManager<T extends JpaRepository, E extends Object> extends CRUDService<T, E> {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    PasswordEncoder encoder;

    public JwtResponse auth(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
        UserResponse userResponse = new UserResponse(userPrincipal.getId(), userPrincipal.getUsername(), userPrincipal.getEmail());
        return new JwtResponse(jwt, userResponse);
    }

    public RegisterResponse register(RegisterRequest request) throws InvalidRepositoryException, BadRequestExceptions {
        this.checkRepositoryClass();
        if (((AuthRepository) this.repository).existsByUsername(request.getUsername())) {
            throw new BadRequestExceptions("Error: username is already in use");
        }
        if (((AuthRepository) this.repository).existsByEmail(request.getEmail())) {
            throw new BadRequestExceptions("Errr: email is already in use");
        }
        User user = new User(request.getUsername(), request.getEmail(), encoder.encode(request.getPassword()));
        this.save((E) user);
        return new RegisterResponse("Account successfully created");
    }


    private void checkRepositoryClass() throws InvalidRepositoryException {
        if (!(this.repository instanceof AuthRepository)) {
            throw new InvalidRepositoryException();
        }
    }
}
