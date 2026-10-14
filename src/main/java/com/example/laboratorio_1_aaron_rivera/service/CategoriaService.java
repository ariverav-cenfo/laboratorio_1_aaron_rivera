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
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository, ProductoRepository productoRepository, CategoriaMapper categoriaMapper){
        this.categoriaRepository = categoriaRepository;
    }


    public List<Categoria> findAll(){
        return categoriaRepository.findAll();
    }


    public Optional<Categoria> findById(Long id){
        return categoriaRepository.findById(id);
    }

    @Transactional
    public Categoria create(Categoria categoria){
        categoria.setCategoriaId(null);
        return categoriaRepository.save(categoria);
    }

    @Transactional
    public boolean delete(Long id){
        if(!categoriaRepository.existsById(id)){
            return false;
        }
        categoriaRepository.deleteById(id);
        return true;
    }

    @Transactional
    public Optional<Categoria> update(Long id, Categoria datos){
        return categoriaRepository.findById(id).map(categoria -> {
            categoria.setNombreCategoria(datos.getNombreCategoria());
            categoria.setDescripcionCategoria(datos.getDescripcionCategoria());
            return categoriaRepository.save(categoria);
        });
    }



}
