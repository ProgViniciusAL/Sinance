package com.vinicius.sinance.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.vinicius.sinance.model.UserEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Calendar;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String TOKEN_SECRET;

    public String generateToken(UserEntity userEntity) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);

            return JWT.create()
                    .withIssuer("sinance-web-api-security")
                    .withSubject(userEntity.getUsername())
                    .withExpiresAt(LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00")))
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            throw new RuntimeException(exception);
        }
    }

    public String validateToken(String token) {
        if(token != null) {
            try {
                Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);

                return JWT.require(algorithm)
                        .withIssuer("sinance-web-api-security")
                        .build()
                        .verify(token)
                        .getSubject();
            } catch (JWTDecodeException exception) {
                throw new RuntimeException(exception);
            }
        }
        return null;
    }

}
