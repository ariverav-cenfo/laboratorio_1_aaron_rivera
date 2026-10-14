package com.example.laboratorio_1_aaron_rivera.repository;

import com.example.laboratorio_1_aaron_rivera.model.Producto;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    @EntityGraph(attributePaths = "productos")
    Optional<Producto> findById(Long id);


    @EntityGraph(attributePaths = "productos")
    void deleteById(Long id);


    @EntityGraph(attributePaths = "productos")
    List<Producto> findAll();


}
