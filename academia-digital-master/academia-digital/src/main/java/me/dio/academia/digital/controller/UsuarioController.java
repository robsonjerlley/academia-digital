package me.dio.academia.digital.controller;

import jakarta.validation.Valid;
import me.dio.academia.digital.dto.UsuarioDTO;
import me.dio.academia.digital.form.UsuarioForm;
import me.dio.academia.digital.service.IUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final IUsuarioService usuarioService;

    public UsuarioController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> create(@Valid @RequestBody UsuarioForm form) {
        UsuarioDTO novoUsuario = usuarioService.create(form);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }
}
