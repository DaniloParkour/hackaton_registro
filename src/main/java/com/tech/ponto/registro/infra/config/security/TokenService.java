package com.tech.ponto.registro.infra.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.tech.ponto.registro.domain.model.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

  @Value("${api.security.token.secret}")
  private String secret;

  public String gerarToken(Usuario usuario) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      String token = JWT.create().withIssuer("tech-ponto-api")
        .withSubject(usuario.getMatricula())
        .withExpiresAt(LocalDateTime.now().plusHours(10).toInstant(ZoneOffset.of("-03:00")))
        .sign(algorithm);
      return token;
    } catch (JWTCreationException e) {
      throw new RuntimeException("Erro ao gerar o token", e);
    }
  }

  public String validadeToken(String token) {
    try {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      return JWT.require(algorithm)
        .withIssuer("tech-ponto-api").build().verify(token).getSubject();
    } catch (JWTVerificationException exception) {
      return "";
    }
  }
}
