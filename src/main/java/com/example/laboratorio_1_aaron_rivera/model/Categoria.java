package com.example.laboratorio_1_aaron_rivera.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Categoria {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CategoriaId;

    @Column(nullable = false, length = 100)
    private String NombreCategoria;

    @Column(nullable = false, length = 250)
    private String DescripcionCategoria;

}
