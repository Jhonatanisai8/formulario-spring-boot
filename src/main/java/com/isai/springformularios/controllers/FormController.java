package com.isai.springformularios.controllers;

import com.isai.springformularios.editors.NombreMayusculaEditor;
import com.isai.springformularios.models.Pais;
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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        binder.registerCustomEditor(String.class, "nombre", new NombreMayusculaEditor());
        binder.registerCustomEditor(String.class, "pais", new NombreMayusculaEditor());
        binder.registerCustomEditor(String.class, "apellido", new NombreMayusculaEditor());

    }

    @ModelAttribute("listaPaises")
    public List<Pais> listaPaises() {
        return List.of(
                new Pais(1L, "ARG", "Argentina"),
                new Pais(2L, "BOL", "Bolivia"),
                new Pais(3L, "BRA", "Brasil"),
                new Pais(4L, "CHL", "Chile"),
                new Pais(5L, "COL", "Colombia"),
                new Pais(6L, "CRI", "Costa Rica"),
                new Pais(7L, "CUB", "Cuba"),
                new Pais(8L, "ECU", "Ecuador"),
                new Pais(9L, "SLV", "El Salvador"),
                new Pais(10L, "GTM", "Guatemala"),
                new Pais(11L, "HND", "Honduras"),
                new Pais(12L, "MEX", "México"),
                new Pais(13L, "NIC", "Nicaragua"),
                new Pais(14L, "PAN", "Panamá"),
                new Pais(15L, "PRY", "Paraguay"),
                new Pais(16L, "PER", "Perú"),
                new Pais(17L, "DOM", "República Dominicana"),
                new Pais(18L, "URY", "Uruguay"),
                new Pais(19L, "VEN", "Venezuela")
        );
    }

    @ModelAttribute("paises")
    public List<String> paises() {
        return List.of("Colombia", "Perú", "España", "Mexico", "Chile", "EE.UU");
    }

    @ModelAttribute("paisesMap")
    public Map<String, String> paisesMap() {
        Map<String, String> paises = new HashMap<>();
        paises.put("Perú", "Perú");
        paises.put("Bolivia", "Bolivia");
        paises.put("Brasil", "Brasil");
        paises.put("Chile", "Chile");
        paises.put("Colombia", "Colombia");
        paises.put("Costa Rica", "Costa Rica");
        paises.put("Argentina", "Argentina");
        paises.put("Cuba", "Cuba");
        paises.put("Ecuador", "Ecuador");
        paises.put("El Salvador", "El Salvador");
        paises.put("Guatemala", "Guatemala");
        paises.put("Honduras", "Honduras");
        paises.put("México", "México");
        paises.put("Nicaragua", "Nicaragua");
        paises.put("Panamá", "Panamá");
        paises.put("Paraguay", "Paraguay");
        paises.put("República Dominicana", "República Dominicana");
        paises.put("Uruguay", "Uruguay");
        paises.put("Venezuela", "Venezuela");
        return paises;
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
