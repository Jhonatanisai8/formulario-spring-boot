package com.isai.springformularios.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int usuarioId;

    //@Pattern(regexp = "[0-9]{2}.[0-9]{3}.[0-9]{3}[-][A-Z]{1}") //patron a seguir
    private String identificadorDni;


    //@NotEmpty
    @Size(min = 10, max = 15)
    private String nombre;

    @NotEmpty
    @Size(min = 10, max = 15)
    private String apellido;

    @NotBlank
    @Size(min = 3, max = 8)
    private String username;

    @NotEmpty
    @Size(min = 8, max = 20)
    private String password;

    @NotEmpty
    @Email(message = "Correo con formato incorrecto")
    @Size(min = 10, max = 25)
    private String email;
}
