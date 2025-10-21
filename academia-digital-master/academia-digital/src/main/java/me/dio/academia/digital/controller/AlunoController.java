package me.dio.academia.digital.controller;

import me.dio.academia.digital.dto.AlunoDTO;
import me.dio.academia.digital.dto.AvaliacaoFisicaDTO;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.form.AlunoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import me.dio.academia.digital.service.impl.AlunoServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoServiceImpl service;

    @PostMapping()
    public ResponseEntity<AlunoDTO> create(@Validated @RequestBody AlunoForm form) {
        AlunoDTO dto = service.create(form);
        return ResponseEntity.ok(dto);
    }

    @GetMapping()
    public ResponseEntity<List<AlunoDTO>> findAll() {
        List<AlunoDTO> alunos = service.findAll();
        return ResponseEntity.ok(alunos);
    }

   @GetMapping("/{id}")
   public ResponseEntity<AlunoDTO> findById(@PathVariable Long id) {
        AlunoDTO alunoDTO = service.findById(id);
        return ResponseEntity.ok(alunoDTO);
   }


    @GetMapping("/avaliacoes/{id}")
    public ResponseEntity<List<AvaliacaoFisicaDTO>>findAvaliacaoById(@PathVariable Long id) {
        List<AvaliacaoFisicaDTO> avaliacoesDTO = service.findAvaliacaoById(id);
        return ResponseEntity.ok(avaliacoesDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlunoDTO> update(@Validated @PathVariable Long id, @RequestBody AlunoForm form) {
        AlunoDTO alunoDTO = service.update(id, form);
        return ResponseEntity.ok(alunoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
