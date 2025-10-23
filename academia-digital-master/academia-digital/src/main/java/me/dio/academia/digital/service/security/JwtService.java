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

    private static final String SECRET_STRING = "minha-chave-super-secreta-para-jwt-256bits";
    private static final long EXPIRACAO_MINUTOS = 30;

    private static final SecretKey SIGNING_KEY;

    static {
        byte[] keyBytes = SECRET_STRING.getBytes(StandardCharsets.UTF_8);
        SIGNING_KEY = Keys.hmacShaKeyFor(keyBytes);
    }

    public String generateToken(Usuario usuario) {
        return Jwts.builder()
                .subject(usuario.getUsername()) // Usar getUsername() da interface UserDetails
                .claim("role", usuario.getRole().name())
                .issuedAt(new Date())
                .expiration(Date.from(Instant.now().plus(EXPIRACAO_MINUTOS, ChronoUnit.MINUTES)))
                .issuer("SistemaAcademia")
                .signWith(getKey())
                .compact();
    }

    public boolean isTokenValido(String token, Usuario usuario) {
        String username = extractUsername(token);
        return (username.equals(usuario.getUsername()) && !isTokenExpirado(token));
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

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }


    private SecretKey getKey() {
        return SIGNING_KEY;
    }
}
