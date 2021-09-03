package com.jorgerubira.ejerciciosspringweb.repositories;

import com.jorgerubira.ejerciciosspringweb.entities.Imagen;
import org.springframework.data.repository.CrudRepository;

public interface GestionImagenesRepository extends CrudRepository<Imagen, Integer>{
    
}
