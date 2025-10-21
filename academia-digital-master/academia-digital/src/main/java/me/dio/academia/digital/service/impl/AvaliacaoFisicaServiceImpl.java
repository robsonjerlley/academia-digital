package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.dto.AvaliacaoFisicaDTO;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.IAvaliacaoFisica;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisica {

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
                .orElseThrow(()-> new Re)


    }

    @Override
    public List<AvaliacaoFisica> getAll() {
        return avaliacaoFisicaRepository.findAll();
    }

    @Override
    public AvaliacaoFisica upDate(Long id, AvaliacaoFisicaForm formUpdate) {
        AvaliacaoFisica avaliacaoFisica = get(id);
        avaliacaoFisica.setPeso(formUpdate.getPeso());
        avaliacaoFisica.setAltura(formUpdate.getAltura());
        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    @Override
    public void delete(Long id) {
        get(id);
        avaliacaoFisicaRepository.deleteById(id);

    }
}
