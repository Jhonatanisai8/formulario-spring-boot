package com.isai.springformularios.service;

import com.isai.springformularios.models.Pais;

import java.util.List;

public interface PaisService {
    List<Pais> findAll();

    Pais findPaisById(Long id);
}
