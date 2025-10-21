package me.dio.academia.digital.service;

import me.dio.academia.digital.dto.AvaliacaoFisicaDTO;
import me.dio.academia.digital.form.AvaliacaoFisicaForm;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IAvaliacaoFisica {

    AvaliacaoFisicaDTO create(AvaliacaoFisicaForm form);

    AvaliacaoFisicaDTO findById(Long id);

    List<AvaliacaoFisicaDTO> findAll();

    AvaliacaoFisicaDTO upDate(Long id, AvaliacaoFisicaForm formUpdate);

    void delete(Long id);


}
