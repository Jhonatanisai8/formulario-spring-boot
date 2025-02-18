package com.isai.springformularios.editors;

import com.isai.springformularios.service.paisServiceImple.PaisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class PaisPropertiesEditors
        extends PropertyEditorSupport {

    @Autowired
    private PaisServiceImpl paisService;

    @Override
    public void setAsText(String id) throws IllegalArgumentException {
        this.setValue(paisService.findPaisById(Long.parseLong(id)));
    }
}
