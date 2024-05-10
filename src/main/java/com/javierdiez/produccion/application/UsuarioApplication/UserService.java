package com.javierdiez.produccion.application.UsuarioApplication;

import com.javierdiez.produccion.domian.usuarioDomain.Usuario;
import com.javierdiez.produccion.infrastructure.UsuarioInfrastructure.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UsuarioRepository userRepository;

    public UserService(UsuarioRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Usuario> getAllUser(){
        List<Usuario> usuarios = new ArrayList<>();

        userRepository.findAll().forEach(usuarios::add);

        return usuarios;
    }
}
