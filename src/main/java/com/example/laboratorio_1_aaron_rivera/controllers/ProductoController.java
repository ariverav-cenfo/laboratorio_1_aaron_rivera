package com.example.laboratorio_1_aaron_rivera.controllers;

import com.example.laboratorio_1_aaron_rivera.dto.CategoriaDTO;
import com.example.laboratorio_1_aaron_rivera.dto.ProductoDTO;
import com.example.laboratorio_1_aaron_rivera.mappers.ProductoMapper;
import com.example.laboratorio_1_aaron_rivera.model.Categoria;
import com.example.laboratorio_1_aaron_rivera.model.Producto;
import com.example.laboratorio_1_aaron_rivera.service.ProductoService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/productos")

public class ProductoController {

    private final ProductoMapper productoMapper;
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService, ProductoMapper productoMapper){
        this.productoMapper = productoMapper;
        this.productoService = productoService;
    }

    @PreAuthorize("hasAuthority('producto:leer')")
    @GetMapping
    public List<ProductoDTO> findAll(){
        return productoMapper.toDtoList(productoService.findAll());
    }

    @PreAuthorize("hasAuthority('producto:leer')")
    @GetMapping("/{id}")
    public ResponseEntity<ProductoDTO> findById(@PathVariable Long id){
        return ResponseEntity.of(productoService.findById(id).map(productoMapper::toDto));

    }

    @PreAuthorize("hasAuthority('producto:escribir')")
    @PostMapping("/")
    public ResponseEntity<ProductoDTO> create(@RequestBody ProductoDTO productoDTO){

        Producto creado = productoService.create(productoMapper.toEntity(productoDTO));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(creado.getIdProducto())
                .toUri();
        return ResponseEntity.created(location).body(productoMapper.toDto(creado));
    }

    @PreAuthorize("hasAuthority('producto:escribir')")
    @PutMapping("/{id}")
    public ResponseEntity<ProductoDTO> update(@PathVariable Long id, @RequestBody ProductoDTO productoDTO){
        return ResponseEntity.of(productoService.update(id, productoMapper.toEntity(productoDTO)).map(productoMapper::toDto));
    }

    @PreAuthorize("hasAuthority('producto:eliminar')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        return productoService.delete(id)
                ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}
