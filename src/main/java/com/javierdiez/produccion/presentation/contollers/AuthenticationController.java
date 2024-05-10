package com.javierdiez.produccion.presentation.contollers;

import com.javierdiez.produccion.application.Authentication.AuthenticationService;
import com.javierdiez.produccion.application.Authentication.LoginResponse;
import com.javierdiez.produccion.application.UsuarioApplication.dtoUsuario.LoginUsuarioDto;
import com.javierdiez.produccion.application.UsuarioApplication.dtoUsuario.RegistroUsuarioDto;
import com.javierdiez.produccion.domian.usuarioDomain.Usuario;
import com.javierdiez.produccion.infrastructure.security.JWTService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final JWTService jwtUtils;

    public AuthenticationController(AuthenticationService authenticationService, JWTService jwtUtils) {
        this.authenticationService = authenticationService;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/register")
    public ResponseEntity<Usuario> register(@RequestBody RegistroUsuarioDto registroUsuarioDto){
        Usuario usuario = authenticationService.signUp(registroUsuarioDto);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUsuarioDto loginUsuarioDto){
        Usuario userAuthenticated = authenticationService.authenticate(loginUsuarioDto);
        String jwtToken = jwtUtils.generateToken(userAuthenticated);

        LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtUtils.getExpirationTime());
        System.out.println(loginResponse);

      return ResponseEntity.ok(loginResponse);
    }
}
