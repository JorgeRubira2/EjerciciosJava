package com.jorgerubira.ejerciciosspringweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jorgerubira.ejerciciosspringweb.entities.Imagen;

public interface ImagenRepository extends JpaRepository<Imagen, Long>{

    public Imagen findByCodigo(String codigo,String descripcion);
    
}
