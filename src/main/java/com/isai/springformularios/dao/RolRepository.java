package com.isai.springformularios.dao;

import com.isai.springformularios.models.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository
        extends JpaRepository<Rol, Long> {
}
