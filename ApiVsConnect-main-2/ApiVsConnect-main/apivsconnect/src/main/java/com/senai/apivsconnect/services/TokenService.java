package com.senai.apivsconnect.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.senai.apivsconnect.models.UsuarioModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${api.security.token.secret}")
    private String secret;



    public String gerarToken(UsuarioModel usuario){
        try{
            Algorithm algoritimo = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("api-vsconnect")
                    .withSubject(usuario.getEmail())
                    .withExpiresAt(gerarValidadeToken())
                    .sign(algoritimo);
            return token;

        }catch(JWTCreationException exception){
            throw new RuntimeException("Erro", exception);
        }
    }

    public String validarToken(String token){
        try{
            Algorithm algoritimo = Algorithm.HMAC256(secret);
            return JWT.require(algoritimo)
                    .withIssuer("api-vsconnect")
                    .build()
                    .verify(token)
                    .getSubject();

        }catch(JWTCreationException exception){
            throw new RuntimeException(exception);
        }
    }




    private Instant gerarValidadeToken(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
