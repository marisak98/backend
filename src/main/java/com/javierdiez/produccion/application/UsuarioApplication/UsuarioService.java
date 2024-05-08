package com.javierdiez.produccion.application.UsuarioApplication;

import com.javierdiez.produccion.domian.usuarioDomain.Usuario;
import com.javierdiez.produccion.infrastructure.UsuarioInfrastructure.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    UsuarioRepository userRepository;

    public Usuario authenticate(String username, String password) {
        Usuario usuario = userRepository.findByEmail(username);
        if (usuario != null && usuario.checkPassword(password)) {
            return usuario;
        } else {
            return null;
        }
    }
}
