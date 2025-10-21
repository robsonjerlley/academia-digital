package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.dto.MatriculaDTO;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.exceptions.ResourceNotFoundException;
import me.dio.academia.digital.form.MatriculaForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.MatriculaRepository;
import me.dio.academia.digital.service.IMatriculaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatriculaServiceImpl implements IMatriculaService {


    private final MatriculaRepository matriculaRepository;


    private final AlunoRepository alunoRepository;

    private final ModelMapper modelMapper;

    public MatriculaServiceImpl(MatriculaRepository matriculaRepository, AlunoRepository alunoRepository, ModelMapper modelMapper) {
        this.matriculaRepository = matriculaRepository;
        this.alunoRepository = alunoRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public MatriculaDTO create(MatriculaForm form) {
        Matricula matricula = new Matricula();
        Aluno aluno = alunoRepository.findById(form.getAlunoId())
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não existe"));
        matricula.setAluno(aluno);

        Matricula matriculaSalva = matriculaRepository.save(matricula);
        return modelMapper.map(matriculaSalva, MatriculaDTO.class);
    }

    @Override
    public List<MatriculaDTO> findAll() {
     List<Matricula> matriculas = matriculaRepository.findAll();
        return matriculas.stream().map(matricula -> modelMapper.map(matricula, MatriculaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        Matricula matricula = matriculaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Matrícula não encontrada com o ID: " + id));
                matriculaRepository.delete(matricula);
    }
}
