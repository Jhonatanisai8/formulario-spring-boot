package com.isai.springformularios.editors;

import com.isai.springformularios.models.Rol;
import com.isai.springformularios.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class RolesEditors
        extends PropertyEditorSupport {

    @Autowired
    private RolService rolService;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        try {
            Long idRol = Long.parseLong(text);
            Rol rol = rolService.findById(idRol);
            setValue(rol);
        } catch (NumberFormatException e) {
            setValue(null);
        }
    }
}
