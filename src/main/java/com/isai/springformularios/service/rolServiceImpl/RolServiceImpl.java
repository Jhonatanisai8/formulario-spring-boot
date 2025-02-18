package com.isai.springformularios.service.rolServiceImpl;

import com.isai.springformularios.dao.RolRepository;
import com.isai.springformularios.models.Rol;
import com.isai.springformularios.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolServiceImpl
        implements RolService {
    @Autowired
    private RolRepository rolRepository;

    @Override
    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

    @Override
    public Rol findById(Long id) {
        return rolRepository.findById(id).get();
    }
}
