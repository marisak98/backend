package com.javierdiez.produccion.application.UsuarioApplication.dtoUsuario;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class LoginUsuarioDto {
    private String email;
    private String password;
}
