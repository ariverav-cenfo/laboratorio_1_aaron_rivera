package com.example.laboratorio_1_aaron_rivera.mappers;

import com.example.laboratorio_1_aaron_rivera.dto.CategoriaDTO;
import com.example.laboratorio_1_aaron_rivera.dto.ProductoDTO;
import com.example.laboratorio_1_aaron_rivera.model.Categoria;
import com.example.laboratorio_1_aaron_rivera.model.Producto;
import org.springframework.stereotype.Component;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProductoMapper {

    ProductoDTO toDto(Producto producto);

    List<ProductoDTO> toDtoList(List<Producto> productos);

    //@Mapping(target = "categorias", ignore = true)
    Producto toEntity(ProductoDTO productoDTO);


}
