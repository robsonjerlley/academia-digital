package me.dio.academia.digital.service;

import me.dio.academia.digital.dto.UsuarioDTO;
import me.dio.academia.digital.form.UsuarioForm;

public interface IUsuarioService {

    UsuarioDTO create(UsuarioForm form);


    void delete (String username);


}
