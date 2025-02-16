package com.isai.springformularios.validation;

import com.isai.springformularios.models.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UsuarioValidador
        implements Validator {

    //si la clase usuario es asignable esta pasada como argumento
    @Override
    public boolean supports(Class<?> clazz) {
        return Usuario.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
//        Usuario usuario = (Usuario) target;
        //validamos el nombre
//        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
//                "nombre", "NotEmpty.usuario.nombre");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,
                "nombre", "Requerido.usuario.nombre");

//        if(usuario.getPais().getPaisId()==null){
//            errors.rejectValue("pais.paisId", "Requerido.usuario.pais");
//        }
        //otra alternativa
//        if (usuario.getNombre().isEmpty()) {
//            errors.rejectValue("nombre",
//                    "NotEmpty.usuario.nombre");
//        }
//        if (!usuario.getIdentificadorDni().matches("[0-9]{2}.[0-9]{3}.[0-9]{3}[-][A-Z]{1}")) {
//            errors.rejectValue("identificadorDni",
//                    "Pattern.usuario.identificadorDni");
//        }
    }
}
