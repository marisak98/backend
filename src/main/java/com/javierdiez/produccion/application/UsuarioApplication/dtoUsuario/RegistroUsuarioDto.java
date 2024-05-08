package com.javierdiez.produccion.application.UsuarioApplication.dtoUsuario;

import com.javierdiez.produccion.domian.usuarioDomain.Rol;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RegistroUsuarioDto {
    private String username;
    private String email;
    private String password;
    private Rol rol;
}
