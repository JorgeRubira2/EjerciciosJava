package com.jorgerubira.ejerciciosspringweb.repositories;

import com.jorgerubira.ejerciciosspringweb.entities.Datos;
import org.springframework.data.repository.CrudRepository;

public interface ImportarCSVRepository extends CrudRepository<Datos, Integer>{
    
}
