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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("usuario")
public class FormController {
    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("tittle", "Formulario Usuarios");
        Usuario usuario = new Usuario();
        usuario.setNombre("Usuario 1");
        usuario.setApellido("Apellido 1");
        usuario.setEmail("usuario1@gmail.com");
        usuario.setIdentificadorDni("1234567890-AS");
        model.addAttribute("usuario", usuario);
        return "form";
    }

    @PostMapping("/form")
    public String procesar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) {
        //validamos
        if (result.hasErrors()) {
            return "form";
        }
        usuarioServiceImpl.save(usuario);
        model.addAttribute("tittle", "Resultado Form");
        model.addAttribute("usuario", usuario);
        status.setComplete();//completa el proceso
        return "resultado";
    }
}
