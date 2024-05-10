package com.javierdiez.produccion.application.Authentication;

import com.javierdiez.produccion.application.UsuarioApplication.dtoUsuario.LoginUsuarioDto;
import com.javierdiez.produccion.application.UsuarioApplication.dtoUsuario.RegistroUsuarioDto;
import com.javierdiez.produccion.domian.usuarioDomain.Rol;
import com.javierdiez.produccion.domian.usuarioDomain.Usuario;
import com.javierdiez.produccion.infrastructure.UsuarioInfrastructure.UsuarioRepository;
import com.javierdiez.produccion.infrastructure.security.JWTService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager auth;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    public AuthenticationService(
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder,
            AuthenticationManager auth,
            AuthenticationManager authenticationManager,
            JWTService jwtService){
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.auth = auth;
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

    public Usuario authenticate(LoginUsuarioDto input){
       authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(
               input.getEmail(),
               input.getPassword()
       ));
        /* hacer que el return printee el usuario en consola. */
        UserDetails user = usuarioRepository.findByEmail(input.getEmail()).orElseThrow();
        String toke = jwtService.generateToken(user);
        return usuarioRepository.findByEmail(input.getEmail()).orElseThrow();
    }
}
