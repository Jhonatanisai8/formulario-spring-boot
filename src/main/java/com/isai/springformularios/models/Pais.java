package com.isai.springformularios.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@Embeddable
@Entity
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paisId;

    @Size(max = 20)
    @NotEmpty
    private String codigoPais;

    @Size(max = 20)
    @NotEmpty
    private String nombrePais;
}
