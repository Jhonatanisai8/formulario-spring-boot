package com.isai.springformularios.controllers;

import com.isai.springformularios.editors.NombreMayusculaEditor;
import com.isai.springformularios.editors.PaisPropertiesEditors;
import com.isai.springformularios.editors.RolesEditors;
import com.isai.springformularios.models.Pais;
import com.isai.springformularios.models.Rol;
import com.isai.springformularios.models.Usuario;
import com.isai.springformularios.service.UsurarioServiceImpl.UsuarioServiceImpl;
import com.isai.springformularios.service.paisServiceImple.PaisServiceImpl;
import com.isai.springformularios.service.rolServiceImpl.RolServiceImpl;
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
import java.util.*;

@Controller
@SessionAttributes("usuario")
public class FormController {

    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    @Autowired
    private UsuarioValidador usuarioValidador;

    @Autowired
    private PaisServiceImpl paisServiceImpl;

    @Autowired
    private PaisPropertiesEditors paisPropertiesEditors;

    @Autowired
    private RolesEditors rolesEditors;

    @Autowired
    private RolServiceImpl rolServiceImpl;

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

        ///REGISTRAMOS PAIS
        binder.registerCustomEditor(Pais.class, "pais", paisPropertiesEditors);
        binder.registerCustomEditor(Rol.class, "roles", rolesEditors);
    }

    @ModelAttribute("listaPaises")
    public List<Pais> listaPaises() {
        return paisServiceImpl.findAll();
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

    @ModelAttribute("listaRoles")
    public List<Rol> listaRoles() {
        return rolServiceImpl.findAll();
    }

    @ModelAttribute("generos")
    public List<String> generos() {
        return List.of("Masculino", "Femenino");
    }


    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("tittle", "Formulario Usuarios");
        Usuario usuario = new Usuario();
//        usuario.setNombre("Usuario 1");
//        usuario.setApellido("Apellido 1");
//        usuario.setEmail("usuario1@gmail.com");
//        usuario.setIdentificadorDni("1234567890-AS");
        usuario.setActivo(true);
        usuario.setValorSecreto("Valor Secreto");
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

//        Pais paisBuscado = listaPaises().stream()
//                .filter(pais -> pais.getPaisId()
//                        .equals(usuario.getPais().getPaisId()))
//                .findFirst()
//                .get();
//
//        usuario.setPais(paisBuscado);
        usuarioServiceImpl.save(usuario);
        model.addAttribute("usuario", usuario);
        status.setComplete();//completa el proceso
        return "resultado";
    }
}
