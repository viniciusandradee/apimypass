package br.com.fiap.MyPass.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;

@Service
public class TokenService {

    public Token createToken(String username){
        var expirationAt = LocalDateTime.now().plus(1, ChronoUnit.HOURS).toInstant(ZoneOffset.UTC);
        Algorithm algorithm = Algorithm.HMAC256("assinatura");
        String token = JWT.create()
                .withSubject(username)
                .withExpiresAt(expirationAt)
                .withIssuer("mypass")
                .withClaim("role", "ADMIN")
                .sign(algorithm);
        return new Token(token, username);
    }

}