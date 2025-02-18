package com.isai.springformularios.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    //@NotEmpty
    private String codigoPais;

    @Size(max = 20)
    //@NotEmpty
    private String nombrePais;

    @OneToMany(
            mappedBy = "pais",
            cascade = CascadeType.ALL
           // orphanRemoval = true
    )
    private List<Usuario> usuarios;
}
