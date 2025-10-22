package me.dio.academia.digital.service;

import me.dio.academia.digital.dto.UsuarioDTO;

public interface IUsuarioService {

    UsuarioDTO create();


    void delete (Long id);


}
