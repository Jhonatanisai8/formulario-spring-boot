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
        if (id != null && id.length() > 0) {
            try {
                Long idPais = Long.parseLong(id);
                this.setValue(paisService.findPaisById(idPais));
            } catch (NumberFormatException e) {
                setValue(null);
            }
        } else {
            setValue(null);
        }
    }
}
