package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.dto.UsuarioDTO;

import me.dio.academia.digital.entity.Usuario;
import me.dio.academia.digital.exceptions.ResourceNotFoundException;
import me.dio.academia.digital.form.UsuarioForm;
import me.dio.academia.digital.repository.UsuarioRepository;
import me.dio.academia.digital.service.IUsuarioService;
import org.modelmapper.ModelMapper;


public class UsuarioServiceImpl implements IUsuarioService {


    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, ModelMapper modelMapper) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public UsuarioDTO create(UsuarioForm form) {
        Usuario usuario = modelMapper.map(form, Usuario.class);
        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return modelMapper.map(usuarioSalvo, UsuarioDTO.class);
    }

    @Override
    public void delete(String username) {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não existe."));
        usuarioRepository.delete(usuario);

    }
}
