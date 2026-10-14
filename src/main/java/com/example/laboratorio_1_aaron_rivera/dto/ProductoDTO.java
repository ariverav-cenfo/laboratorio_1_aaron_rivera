package com.example.laboratorio_1_aaron_rivera.dto;

import java.math.BigDecimal;
import java.util.Set;

public record ProductoDTO (
    Long IdProducto,
    String NombreProducto,
    String DescrcipcionProducto,
    BigDecimal Precio,
    Integer Stock,
    Long CategoriaId

){}
