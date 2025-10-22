package me.dio.academia.digital.service.security;

import me.dio.academia.digital.entity.Usuario;
import me.dio.academia.digital.exceptions.ResourceNotFoundException;
import me.dio.academia.digital.repository.UsuarioRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AutentificacaoService {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

   private  final PasswordEncoder passwordEncoder;

   public AutentificacaoService(UsuarioRepository usuarioRepository, JwtService jwtService, AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
    }

    public String authenticate(String username, String password) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));

        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(()-> new ResourceNotFoundException("Usuario não existe."));
        return jwtService.generateToken(usuario);
    }

}
