package me.dio.academia.digital.service;

import me.dio.academia.digital.dto.UsuarioDTO;
import me.dio.academia.digital.form.UsuarioForm;

import java.util.List;

public interface IUsuarioService {

    UsuarioDTO create(UsuarioForm form);

    List<UsuarioDTO> findAll();

    void delete (String username);


}
