package me.dio.academia.digital;

import jakarta.validation.Valid;
import me.dio.academia.digital.dto.UsuarioDTO;
import me.dio.academia.digital.form.UsuarioForm;
import me.dio.academia.digital.service.IUsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final IUsuarioService usuarioService;

    public UsuarioController(IUsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/criar")
    public ResponseEntity<UsuarioDTO> create(@PathVariable @Valid @RequestBody UsuarioForm form) {
        UsuarioDTO novoUsuario = usuarioService.create(form);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioDTO>>findAll(){
        List<UsuarioDTO> usuarios = usuarioService.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<Void>delete(@PathVariable String username) {
        usuarioService.delete(username);
        return ResponseEntity.noContent().build();
    }

}
