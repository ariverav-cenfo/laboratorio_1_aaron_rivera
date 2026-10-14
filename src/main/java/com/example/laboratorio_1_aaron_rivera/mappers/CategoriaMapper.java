package com.example.laboratorio_1_aaron_rivera.mappers;

import com.example.laboratorio_1_aaron_rivera.dto.CategoriaDTO;
import com.example.laboratorio_1_aaron_rivera.model.Categoria;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoriaMapper {

    CategoriaDTO toDto(Categoria categoria);

    List<CategoriaDTO> toDtoList(List<Categoria> categorias);

    //@Mapping(target = "categorias", ignore = true)
    Categoria toEntity(CategoriaDTO categoriaDTO);

}
