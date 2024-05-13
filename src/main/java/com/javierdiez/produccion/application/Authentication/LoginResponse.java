package com.javierdiez.produccion.application.Authentication;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Data
@Builder
@Getter
@Setter
@Accessors(chain = true)
public class LoginResponse {
    private String token;
    private long expiresIn;
}
