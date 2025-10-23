package me.dio.academia.digital.controller;

import me.dio.academia.digital.dto.UsuarioDTO;
import me.dio.academia.digital.entity.Usuario;
import me.dio.academia.digital.form.UsuarioForm;
import me.dio.academia.digital.service.impl.UsuarioServiceImpl;
import me.dio.academia.digital.service.security.AutentificacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/autenticacao")
public class AutenticacaoController {

    private final AutentificacaoService autentificacaoService;
    private final UsuarioServiceImpl service;

    public AutenticacaoController(AutentificacaoService autentificacaoService, UsuarioServiceImpl service) {
        this.autentificacaoService = autentificacaoService;
        this.service = service;
    }
    @PostMapping()
    public ResponseEntity<UsuarioDTO> create(@RequestBody UsuarioForm form) {
        UsuarioDTO dot = service.create(form);
        return ResponseEntity.ok(dot);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String username) {
        service.delete(username);
        return ResponseEntity.noContent().build();
    }

}
