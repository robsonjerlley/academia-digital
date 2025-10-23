package me.dio.academia.digital.controller;

import me.dio.academia.digital.dto.UsuarioDTO;
import me.dio.academia.digital.form.UsuarioForm;
import me.dio.academia.digital.service.impl.UsuarioServiceImpl;
import me.dio.academia.digital.service.security.AutenticacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final AutenticacaoService autenticacaoService;
    private final UsuarioServiceImpl service;

    public UsuarioController(AutenticacaoService autenticacaoService, UsuarioServiceImpl service) {
        this.autenticacaoService = autenticacaoService;
        this.service = service;
    }
    @PostMapping("/registrar")
    public ResponseEntity<UsuarioDTO> create(@Validated @RequestBody UsuarioForm form) {
        UsuarioDTO dot = service.create(form);
        return ResponseEntity.ok(dot);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>>findall() {
        List<UsuarioDTO> usuarios = service.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String username) {
        service.delete(username);
        return ResponseEntity.noContent().build();
    }

}
