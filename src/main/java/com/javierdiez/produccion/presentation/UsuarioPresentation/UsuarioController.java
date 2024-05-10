package com.javierdiez.produccion.presentation.UsuarioPresentation;

import com.javierdiez.produccion.application.UsuarioApplication.UserService;
import com.javierdiez.produccion.domian.usuarioDomain.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UsuarioController {
    private final UserService usuarioService;

    public UsuarioController(UserService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> allUser(){
        List<Usuario> usuarios = usuarioService.getAllUser();
        return ResponseEntity.ok(usuarios);
    }
}
