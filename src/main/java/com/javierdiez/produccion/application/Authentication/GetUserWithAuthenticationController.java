package com.javierdiez.produccion.application.Authentication;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class GetUserWithAuthenticationController {

    @GetMapping(value = "/username")
    public String currentUserName(Authentication authentication) {
        return authentication.getName();
    }
}
