package com.jorgerubira.ejerciciosspringweb.repositories;
import com.jorgerubira.ejerciciosspringweb.entities.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagenRepository extends JpaRepository<Imagen, Long>{

    public Imagen findByCodigo(String codigo);
    
}