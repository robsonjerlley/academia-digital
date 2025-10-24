package me.dio.academia.digital.service.impl;

import me.dio.academia.digital.dto.UsuarioDTO;
import me.dio.academia.digital.entity.Usuario;
import me.dio.academia.digital.entity.enums.Role;
import me.dio.academia.digital.exceptions.ResourceNotFoundException;
import me.dio.academia.digital.form.UsuarioForm;
import me.dio.academia.digital.repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceImplTest  {
    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    private UsuarioForm usuarioForm;
    private Usuario usuario;
    private UsuarioDTO usuarioDTO;

    @BeforeEach
    void setUp() {
        usuarioForm =new UsuarioForm("usuarioteste", "password123", Role.USUARIO);
        usuario = new Usuario();
        usuario.setId(1L);
        usuario.setUsername("usuarioteste");
        usuario.setPassword("password123");
        usuario.setRole(Role.USUARIO);

        usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(1L);
        usuarioDTO.setUsername("usuarioteste");
        usuarioDTO.setRole(Role.USUARIO);
    }


    @Test
    @DisplayName("Deve ter sucesso em criar um usuário e decodificar a senha")
    void deveCriarUmUsuarioECodofocarASenhaComSucesso() {
        when(passwordEncoder.encode(usuarioForm.getPassword())).thenReturn(usuario.getPassword());
        when(usuarioRepository.save(any(Usuario.class))).thenReturn(usuario);
        when(modelMapper.map(any(Usuario.class), eq(UsuarioDTO.class))).thenReturn(usuarioDTO);

        UsuarioDTO result = usuarioService.create(usuarioForm);
        assertNotNull(result);

        assertEquals(usuarioDTO.getUsername(), result.getUsername());
        verify(passwordEncoder, times(1)).encode(usuarioForm.getPassword());
        verify(usuarioRepository, times(1)).save(any(Usuario.class));
        verify(modelMapper, times(1)).map(any(Usuario.class), eq(UsuarioDTO.class));

    }


    @Test
    @DisplayName("Deve lançar ResourceNotFoundException ao tentar deletar um usuário inexistente")
    void deveLancarResourceNotFoundExceptionAoTentarDeletarOUsuario() {
        when(usuarioRepository.findByUsername(anyString())).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> usuarioService.delete("naoExiste"));
        verify(usuarioRepository, times(1)).findByUsername("naoExiste");
        verify(usuarioRepository, never()).delete(any(Usuario.class));

    }






}
