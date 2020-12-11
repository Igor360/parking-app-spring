package com.parking.example.parking.helpers;

import com.parking.example.parking.security.services.UserDetailsImpl;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @class Auth
 */
public final class Auth {

    public static UserDetailsImpl getAuthUser() {
        return (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
    }
}
