package me.dio.academia.digital.controller;

import me.dio.academia.digital.dto.MatriculaDTO;
import me.dio.academia.digital.form.MatriculaForm;
import me.dio.academia.digital.service.impl.MatriculaServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    private final MatriculaServiceImpl service;

    public MatriculaController(MatriculaServiceImpl service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<MatriculaDTO>create(@RequestBody MatriculaForm form) {
        MatriculaDTO dto = service.create(form);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<MatriculaDTO>> findAll() {
        List<MatriculaDTO> matirculasDTO = service.findAll();
        return ResponseEntity.ok(matirculasDTO);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }



}
