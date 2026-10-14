package com.example.laboratorio_1_aaron_rivera.controllers;

import com.example.laboratorio_1_aaron_rivera.dto.CategoriaDTO;
import com.example.laboratorio_1_aaron_rivera.mappers.CategoriaMapper;
import com.example.laboratorio_1_aaron_rivera.model.Categoria;
import com.example.laboratorio_1_aaron_rivera.service.CategoriaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
@RestController
@RequestMapping("/api/v1/categoria")
@Slf4j
public class CategoriaController {
    private final CategoriaService categoriaService;
    private final CategoriaMapper categoriaMapper;

    public CategoriaController(CategoriaService categoriaService, CategoriaMapper categoriaMapper){
        this.categoriaService = categoriaService;
        this.categoriaMapper = categoriaMapper;
    }

    @PreAuthorize("hasAuthority('categoria:leer')")
    @GetMapping
    public List<CategoriaDTO> findAll(){
        return categoriaMapper.toDtoList(categoriaService.findAll());
    }

    @PreAuthorize("hasAuthority('categoria:leer')")
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> findById(@PathVariable Long id){
        return ResponseEntity.of(categoriaService.findById(id).map(categoriaMapper::toDto));

    }

    @PreAuthorize("hasAuthority('categoria:escribir')")
    @PostMapping("/")
    public ResponseEntity<CategoriaDTO> create(@RequestBody CategoriaDTO categoriaDTO){

        Categoria creado = categoriaService.create(categoriaMapper.toEntity(categoriaDTO));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(creado.getCategoriaId())
                .toUri();
        return ResponseEntity.created(location).body(categoriaMapper.toDto(creado));
    }

    @PreAuthorize("hasAuthority('categoria:escribir')")
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> update(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO){
        return ResponseEntity.of(categoriaService.update(id, categoriaMapper.toEntity(categoriaDTO)).map(categoriaMapper::toDto));
    }

    @PreAuthorize("hasAuthority('categoria:eliminar')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return categoriaService.delete(id)
                ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}
