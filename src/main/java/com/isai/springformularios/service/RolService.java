package com.isai.springformularios.service;

import com.isai.springformularios.models.Rol;

import java.util.List;

public interface RolService {
    public List<Rol> findAll();

    Rol findById(Long id);
}
