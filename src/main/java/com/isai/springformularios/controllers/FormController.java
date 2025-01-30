package com.isai.springformularios.controllers;

import com.isai.springformularios.models.Usuario;
import com.isai.springformularios.service.UsurarioServiceImpl.UsuarioServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class FormController {
    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("tittle", "Formulario Usuarios");
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);
        return "form";
    }

    @PostMapping("/form")
    public String procesar(@Valid Usuario usuario, BindingResult result, Model model) {
        //validamos
        if (result.hasErrors()) {
            //retornamos a la vista
//            Map<String, String> errors = new HashMap<>();
//            result.getFieldErrors()
//                    .forEach(error -> {
//                        errors.put(error.getField(),
//                                "El campo ".concat(error.getField())
//                                        .concat(" ")
//                                        .concat(Objects.requireNonNull(error.getDefaultMessage())));
//                    });
            return "form";
        }
        usuarioServiceImpl.save(usuario);
        model.addAttribute("tittle", "Resultado Form");
        model.addAttribute("usuario", usuario);
        return "resultado";
    }
}
