package me.dio.academia.digital.controller;

import me.dio.academia.digital.dto.LoginRequestDTO;
import me.dio.academia.digital.dto.LoginResponseDTO;
import me.dio.academia.digital.service.security.AutenticacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoController {

    private final AutenticacaoService service;


    public AutenticacaoController(AutenticacaoService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO>autenticar(@RequestBody LoginRequestDTO request) {
        String token = service.authenticate(request.username(), request.password());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

}
