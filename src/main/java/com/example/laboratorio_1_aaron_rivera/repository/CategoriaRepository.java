package com.example.laboratorio_1_aaron_rivera.repository;

import com.example.laboratorio_1_aaron_rivera.model.Categoria;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @EntityGraph(attributePaths = "categorias")
    List<Categoria>findAll();

    @EntityGraph(attributePaths = "categorias")
    Optional<Categoria> findById(Long CategoriaId);


    @EntityGraph(attributePaths = "categorias")
    void deleteById(Long CategoriaId);
}
