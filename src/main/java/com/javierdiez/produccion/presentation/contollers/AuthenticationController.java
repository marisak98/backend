package com.javierdiez.produccion.presentation.contollers;

import com.javierdiez.produccion.application.Authentication.AuthenticationService;
import com.javierdiez.produccion.application.Authentication.LoginResponse;
import com.javierdiez.produccion.application.UsuarioApplication.dtoUsuario.LoginUsuarioDto;
import com.javierdiez.produccion.application.UsuarioApplication.dtoUsuario.RegistroUsuarioDto;
import com.javierdiez.produccion.domian.usuarioDomain.Usuario;
import com.javierdiez.produccion.infrastructure.security.JWTService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
      return  ResponseEntity.ok(authenticationService.authenticate(loginUsuarioDto));
    }
}
