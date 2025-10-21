package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.form.MatriculaForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.MatriculaRepository;
import me.dio.academia.digital.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MatriculaServiceImpl implements IMatriculaService {

    @Autowired
    private MatriculaRepository matriculaRepository;

    @Autowired
    private AlunoRepository alunoRepository;



    @Override
    public Matricula create(MatriculaForm form) {
        Matricula matricula = new Matricula();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).orElseThrow();
        matricula.setAluno(aluno);

        return matriculaRepository.save(matricula);
    }

    @Override
    public List<Matricula> getAll() {

        return matriculaRepository.findAll();
    }

    public Matricula getId(Long id) {

      return   matriculaRepository.findById(id).orElseThrow();
    }

    @Override
    public void delete(Long id) {
        try {
            Matricula matricula = getId(id);
            matriculaRepository.delete(matricula);
        } catch (Exception e) {
            System.out.println("ERRO: Id não existe!");
            throw new RuntimeException(e);
        }
    }
}
