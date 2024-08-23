package br.com.fiap.MyPass.user.dto;

import br.com.fiap.MyPass.user.User;

import java.time.LocalDateTime;

public record UserResponse(
        Long id,
        String username,
        String password
) {
    public static UserResponse from(User user) {
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getPassword()
        );
    }
}