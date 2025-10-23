package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.dto.AvaliacaoFisicaDTO;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.exceptions.ResourceNotFoundException;
import me.dio.academia.digital.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

    private final AvaliacaoFisicaRepository avaliacaoFisicaRepository;
    private final AlunoRepository alunoRepository;

    private final ModelMapper modelMapper;

    public AvaliacaoFisicaServiceImpl(AvaliacaoFisicaRepository avaliacaoFisicaRepository, AlunoRepository alunoRepository, ModelMapper modelMapper) {
        this.avaliacaoFisicaRepository = avaliacaoFisicaRepository;
        this.alunoRepository = alunoRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public AvaliacaoFisicaDTO create(AvaliacaoFisicaForm form) {
        AvaliacaoFisica avaliacaoFisica = modelMapper.map(form , AvaliacaoFisica.class);
        AvaliacaoFisica avaliacaoSalav = avaliacaoFisicaRepository.save(avaliacaoFisica);
        return modelMapper.map(avaliacaoSalav, AvaliacaoFisicaDTO.class);

    }

    @Override
    public AvaliacaoFisicaDTO findById(Long id) {
        AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Aluno não existe."));
        return modelMapper.map(avaliacaoFisica, AvaliacaoFisicaDTO.class);
    }

    @Override
    public List<AvaliacaoFisicaDTO> findAll() {
        List<AvaliacaoFisica> avaliacoes = avaliacaoFisicaRepository.findAll();
        return avaliacoes.stream().map(avaliacao -> modelMapper.map(avaliacao, AvaliacaoFisicaDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public AvaliacaoFisicaDTO upDate(Long id, AvaliacaoFisicaForm formUpdate) {
        AvaliacaoFisica avaliacaoExist = avaliacaoFisicaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno não existe."));
        AvaliacaoFisica avaliacaoUpdate = avaliacaoFisicaRepository.save(avaliacaoExist);
        return modelMapper.map(avaliacaoUpdate, AvaliacaoFisicaDTO.class);

    }

    @Override
    public void delete(Long id) {
        AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Aluno não existe."));
        avaliacaoFisicaRepository.delete(avaliacaoFisica);

    }
}
