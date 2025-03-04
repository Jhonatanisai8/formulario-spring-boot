package com.isai.springformularios.service.UsurarioServiceImpl;

import com.isai.springformularios.dao.UsuarioRepository;
import com.isai.springformularios.models.Usuario;
import com.isai.springformularios.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImpl
        implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public List<Usuario> findAllUsers() {
        return usuarioRepository.findAll();
    }
}
