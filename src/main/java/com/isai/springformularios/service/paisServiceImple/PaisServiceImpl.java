package com.isai.springformularios.service.paisServiceImple;

import com.isai.springformularios.dao.PaisRepository;
import com.isai.springformularios.models.Pais;
import com.isai.springformularios.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisServiceImpl
        implements PaisService {

    @Autowired
    private PaisRepository paisRepository;

    @Override
    public List<Pais> findAll() {
        return paisRepository.findAll();
    }

    @Override
    public Pais findPaisById(Long id) {
        return paisRepository.findById(id).get();
    }
}
