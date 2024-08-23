package br.com.fiap.MyPass.password.dto;

import br.com.fiap.MyPass.password.Password;

import java.time.LocalDateTime;

public record PasswordResponse(
        Long id,
        String url,
        String username,
        String password

) {
    public static PasswordResponse from(Password password) {
        return new PasswordResponse(
                password.getId(),
                password.getUrl(),
                password.getUsername(),
                password.getPassword()
        );
    }
}