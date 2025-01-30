package com.isai.springformularios.controllers;

import com.isai.springformularios.models.Usuario;
import com.isai.springformularios.service.UsurarioServiceImpl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FormController {
    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("tittle", "Resultado Usuarios");
        return "form";
    }

    @PostMapping("/form")
    public String procesar(Model model,
                           @RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String email) {
        model.addAttribute("tittle", "Resultado Form");
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        model.addAttribute("email", email);
        Usuario usuario = new Usuario();
        usuario.setUsuario(username);
        usuario.setPassword(password);
        usuario.setEmail(email);
        usuarioServiceImpl.save(usuario);
        return "resultado";
    }
}
