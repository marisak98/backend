package com.javierdiez.produccion.application.Authentication;

import com.javierdiez.produccion.application.UsuarioApplication.dtoUsuario.LoginUsuarioDto;
import com.javierdiez.produccion.application.UsuarioApplication.dtoUsuario.RegistroUsuarioDto;
import com.javierdiez.produccion.domian.usuarioDomain.Rol;
import com.javierdiez.produccion.domian.usuarioDomain.Usuario;
import com.javierdiez.produccion.infrastructure.UsuarioInfrastructure.UsuarioRepository;
import com.javierdiez.produccion.infrastructure.security.JWTService;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    public AuthenticationService(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager authenticationManager,
            JWTService jwtService){
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
    }

    public Usuario signUp(RegistroUsuarioDto input){
      Usuario usuario = new Usuario()
              .setUsername(input.getUsername())
              .setEmail(input.getEmail())
              .setPassword(passwordEncoder.encode(input.getPassword()))
              .setRol(Rol.ADMIN);

        return usuarioRepository.save(usuario);
    }

    public LoginResponse authenticate(LoginUsuarioDto input){
       authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(
               input.getEmail(),
               input.getPassword()
       ));
        UserDetails user = usuarioRepository.findByEmail(input.getEmail()).orElseThrow();
        String toke = jwtService.generateToken(user);
        return LoginResponse.builder()
                .token(toke)
                .expiresIn(jwtService.getExpirationTime())
                .build();
    }

    public Usuario getCurrentUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(!(authentication instanceof AnonymousAuthenticationToken)){
            String currentUserName = authentication.getName();
            return usuarioRepository.findByEmail(currentUserName).orElseThrow();

        }

        return null;
    }
}
