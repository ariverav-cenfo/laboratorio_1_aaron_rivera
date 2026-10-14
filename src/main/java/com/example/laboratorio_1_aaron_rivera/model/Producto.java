package com.example.laboratorio_1_aaron_rivera.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Producto {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long IdProducto;

    @Column(nullable = false, length = 100)
    private String NombreProducto;

    @Column(nullable = false, length = 250)
    private String DescrcipcionProducto;

    @Column(nullable = false)
    private BigDecimal Precio;

    @Column(nullable = false)
    private Integer Stock;

    @Column(nullable = false)
    private Long CategoriaId;
}
