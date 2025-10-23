package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.dto.UsuarioDTO;

import me.dio.academia.digital.entity.Usuario;
import me.dio.academia.digital.exceptions.ResourceNotFoundException;
import me.dio.academia.digital.form.UsuarioForm;
import me.dio.academia.digital.repository.UsuarioRepository;
import me.dio.academia.digital.service.IUsuarioService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements IUsuarioService {


    private final UsuarioRepository usuarioRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UsuarioDTO create(UsuarioForm form) {
        Usuario usuario = new Usuario();
        usuario.setUsername(form.getUsername());
        usuario.setPassword(passwordEncoder.encode(form.getPassword()));
        usuario.setRole(form.getRole());

        Usuario usuarioSalvo = usuarioRepository.save(usuario);
        return modelMapper.map(usuarioSalvo, UsuarioDTO.class);
    }

    @Override
    public List<UsuarioDTO> findAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream().map(usuario -> modelMapper.map(usuario,UsuarioDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String username) {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não existe."));
        usuarioRepository.delete(usuario);

    }
}
