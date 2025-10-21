package me.dio.academia.digital.service;

import me.dio.academia.digital.dto.MatriculaDTO;
import me.dio.academia.digital.form.MatriculaForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMatriculaService {

    MatriculaDTO create(MatriculaForm form);

    List<MatriculaDTO> findAll();

    void delete(Long id );





}
