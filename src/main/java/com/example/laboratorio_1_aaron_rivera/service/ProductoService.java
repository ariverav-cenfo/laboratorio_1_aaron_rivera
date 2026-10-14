package com.example.laboratorio_1_aaron_rivera.service;

import com.example.laboratorio_1_aaron_rivera.mappers.CategoriaMapper;
import com.example.laboratorio_1_aaron_rivera.model.Categoria;
import com.example.laboratorio_1_aaron_rivera.model.Producto;
import com.example.laboratorio_1_aaron_rivera.repository.CategoriaRepository;
import com.example.laboratorio_1_aaron_rivera.repository.ProductoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ProductoService {
    private final ProductoRepository productoRepository;


    public ProductoService(ProductoRepository productoRepository, CategoriaRepository categoriaRepository, CategoriaMapper categoriaMapper){
        this.productoRepository = productoRepository;
    }

    public List<Producto> findAll(){return productoRepository.findAll();}

    public Optional<Producto> findById(Long id){return productoRepository.findById(id);}

    @Transactional
    public Producto create(Producto producto){
        producto.setIdProducto(null);
        return productoRepository.save(producto);
    }

    @Transactional
    public Optional<Producto> update(Long id, Producto datos){
        return productoRepository.findById(id).map(producto -> {
            producto.setNombreProducto(datos.getNombreProducto());
            producto.setDescrcipcionProducto(datos.getDescrcipcionProducto());
            producto.setPrecio(datos.getPrecio());
            producto.setStock(datos.getStock());
            producto.setCategoriaId(datos.getCategoriaId());
            return productoRepository.save(producto);
        });
    }

    @Transactional
    public boolean delete(Long id) {
        if (!productoRepository.existsById(id)) {
            return false;
        }
        productoRepository.deleteById(id);
        return true;
    }




}
