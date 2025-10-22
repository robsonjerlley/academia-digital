package me.dio.academia.digital.service.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import me.dio.academia.digital.entity.Usuario;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtService {

    private static final String SECRET_KEY = "minha-chave-super-secreta-para-jwt-256bits";
    private static final long EXPIRACAO_MINUTOS = 30;

    public String generateToken(Usuario usuario) {
        return Jwts.builder()
                .subject(usuario.getUserName())
                .claim("role", usuario.getRole().name())
                .issuedAt(new Date()) // data de emissão
                .expiration(Date.from(Instant.now().plus(EXPIRACAO_MINUTOS, ChronoUnit.MINUTES)))
                .issuer("SistemaMensagens") // emissor do token
                .signWith(getKey())
                .compact();
    }


    public boolean isTokenValido(String token, Usuario usuario) {
        String email = extractEmail(token);
        return (email.equals(usuario.getUserName()) && !isTokenExpirado(token));
    }


    public boolean isTokenExpirado(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }


    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }


    public String extractEmail(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private SecretKey getKey() {
        byte[] keyBytes = SECRET_KEY.getBytes(StandardCharsets.UTF_8);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
