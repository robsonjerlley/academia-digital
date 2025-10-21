package me.dio.academia.digital.service;

import me.dio.academia.digital.dto.AlunoDTO;
import me.dio.academia.digital.dto.AvaliacaoFisicaDTO;
import me.dio.academia.digital.form.AlunoForm;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface IAlunoService {

    AlunoDTO create(AlunoForm from);
    AlunoDTO findById(Long id);
    List<AlunoDTO> findAll();
    AlunoDTO update(Long id, AlunoForm formUpdate);

    void delete(Long id);
     List<AvaliacaoFisicaDTO> findAvaliacaoById(Long id);

}
