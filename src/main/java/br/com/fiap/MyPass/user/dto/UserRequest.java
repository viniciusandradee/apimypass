package br.com.fiap.MyPass.user.dto;

import br.com.fiap.MyPass.user.User;

import java.time.LocalDateTime;

public record UserRequest(
        String username,
        String password
) {
    public User toModel() {
        return User.builder()
                .username(username)
                .password(password)
                .build();
    }
}