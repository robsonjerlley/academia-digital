package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.form.MatriculaForm;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IMatriculaService {

    Matricula create(MatriculaForm form);

    List<Matricula> getAll();

   void delete(Long id);


}
