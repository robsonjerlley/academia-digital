package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.dto.AlunoDTO;
import me.dio.academia.digital.dto.AvaliacaoFisicaDTO;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.form.AlunoForm;
import me.dio.academia.digital.service.IAlunoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import me.dio.academia.digital.repository.AlunoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlunoServiceImpl implements IAlunoService {


    private final AlunoRepository alunoRepository;


    private final ModelMapper modelMapper;

    public AlunoServiceImpl(AlunoRepository alunoRepository, ModelMapper modelMapper) {
        this.alunoRepository = alunoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public AlunoDTO create(AlunoForm form) {
        Aluno aluno = modelMapper.map(form, Aluno.class);
        Aluno alunoSalvo = alunoRepository.save(aluno);
        return modelMapper.map(alunoSalvo, AlunoDTO.class);
    }

    @Override
    public AlunoDTO findById(Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new  RuntimeException("Aluno não encontrado"));
        return modelMapper.map(aluno , AlunoDTO.class);

    }

    @Override
    public List<AlunoDTO> findAll() {
        List<Aluno> alunos = alunoRepository.findAll();
        return alunos.stream().map(aluno -> modelMapper.map(aluno, AlunoDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public AlunoDTO update(Long id, AlunoForm form) {
        Aluno alunoExist = alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
        modelMapper.map(form, alunoExist);

        Aluno alunoUpdate = alunoRepository.save(alunoExist);
        return modelMapper.map(alunoUpdate, AlunoDTO.class);

    }

    @Override
    public void delete(Long id) {
       Aluno aluno = alunoRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
       alunoRepository.delete(aluno);



    }

    @Override
    public List<AvaliacaoFisicaDTO> findAvaliacaoById(Long id) {
        Aluno aluno = alunoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluno não existe"));
        return aluno.getAvaliacoes().stream().map(avaliacaoFisica -> modelMapper
                .map(avaliacaoFisica, AvaliacaoFisicaDTO.class)).collect(Collectors.toList());
    }


}
