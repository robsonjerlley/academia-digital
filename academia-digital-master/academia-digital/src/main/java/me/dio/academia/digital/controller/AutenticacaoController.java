package me.dio.academia.digital.controller;

import me.dio.academia.digital.service.security.AutentificacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoController {

    private final AutentificacaoService autentificacaoService;

    public AutenticacaoController(AutentificacaoService autentificacaoService) {
        this.autentificacaoService = autentificacaoService;
    }

    public ResponseEntity<AutentificacaoService>


}
