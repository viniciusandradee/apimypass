package br.com.fiap.MyPass.password.dto;

import br.com.fiap.MyPass.password.Password;

import java.time.LocalDateTime;

public record PasswordRequest(
        String url,
        String username,
        String password
) {
    public Password toModel() {
        return Password.builder()
                .url(url)
                .username(username)
                .password(password)
                .build();
    }
}