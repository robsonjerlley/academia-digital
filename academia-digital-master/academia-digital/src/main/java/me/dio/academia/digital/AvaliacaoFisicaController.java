package me.dio.academia.digital;

import me.dio.academia.digital.dto.AvaliacaoFisicaDTO;
import me.dio.academia.digital.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.service.impl.AvaliacaoFisicaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaServiceImpl service;

    @PostMapping
    public ResponseEntity<AvaliacaoFisicaDTO> create(@Validated @RequestBody AvaliacaoFisicaForm form) {
        AvaliacaoFisicaDTO dto = service.create(form);
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<AvaliacaoFisicaDTO>> findAll() {
        List<AvaliacaoFisicaDTO> avaliacoesDTO = service.findAll();
        return ResponseEntity.ok(avaliacoesDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoFisicaDTO> findById(@PathVariable Long id ) {
      AvaliacaoFisicaDTO avaliacaoDTO = service.findById(id);
        return ResponseEntity.ok(avaliacaoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
