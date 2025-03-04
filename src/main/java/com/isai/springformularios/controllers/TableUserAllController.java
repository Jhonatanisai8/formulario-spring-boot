package com.isai.springformularios.controllers;

import com.isai.springformularios.models.Usuario;
import com.isai.springformularios.service.UsurarioServiceImpl.UsuarioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class TableUserAllController {

    @Autowired
    private UsuarioServiceImpl usuarioService;

    @GetMapping("/findAllUsers")
    public String findAllUsers(Model model) {
        model.addAttribute("tittle", "Lista de usuarios");
        List<Usuario> listUsersFront = usuarioService.findAllUsers();
        model.addAttribute("users", listUsersFront);
        return "tableUserAll";
    }
}
