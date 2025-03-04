package com.isai.springformularios.service;

import com.isai.springformularios.models.Usuario;

import java.util.List;

public interface UsuarioService {
    Usuario save(Usuario usuario);

    List<Usuario> findAllUsers();
}
