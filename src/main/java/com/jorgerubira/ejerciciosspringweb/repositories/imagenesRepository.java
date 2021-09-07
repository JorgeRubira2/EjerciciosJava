package com.jorgerubira.ejerciciosspringweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jorgerubira.ejerciciosspringweb.entities.Imagen;

public interface imagenesRepository extends JpaRepository<Imagen, Integer> {
    
}
