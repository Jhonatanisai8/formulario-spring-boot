package com.isai.springformularios.models;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Pais {
    private Long paisId;

    @Size(max = 20)
    private String codigoPais;

    @Size(max = 20)
    private String nombrePais;
}
