package com.isai.springformularios.controllers;

import com.isai.springformularios.editors.NombreMayusculaEditor;
import com.isai.springformularios.models.Usuario;
import com.isai.springformularios.service.UsurarioServiceImpl.UsuarioServiceImpl;
import com.isai.springformularios.validation.UsuarioValidador;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@SessionAttributes("usuario")
public class FormController {

    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    @Autowired
    private UsuarioValidador usuarioValidador;

    //valida de manera cuando se envia el formulario
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(usuarioValidador);
        //validador del campo fecha para convertir un string a date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        //binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));//valida de forma global
        binder.registerCustomEditor(Date.class, "fechaNacimiento", new CustomDateEditor(dateFormat, true)); //valida un campo en especifico

        //binder.registerCustomEditor(String.class, new NombreMayusculaEditor());
        binder.registerCustomEditor(String.class,"nombre", new NombreMayusculaEditor());
        binder.registerCustomEditor(String.class,"apellido", new NombreMayusculaEditor());

    }


    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("tittle", "Formulario Usuarios");
        Usuario usuario = new Usuario();
//        usuario.setNombre("Usuario 1");
//        usuario.setApellido("Apellido 1");
//        usuario.setEmail("usuario1@gmail.com");
//        usuario.setIdentificadorDni("1234567890-AS");
        model.addAttribute("usuario", usuario);
        return "form";
    }

    @PostMapping("/form")
    public String procesar(@Valid Usuario usuario, BindingResult result, Model model, SessionStatus status) {
        //validamos

        ///usuarioValidador.validate(usuario, result);

        model.addAttribute("tittle", "Resultado Form");

        if (result.hasErrors()) {
            return "form";
        }
        usuarioServiceImpl.save(usuario);
        model.addAttribute("usuario", usuario);
        status.setComplete();//completa el proceso
        return "resultado";
    }
}
