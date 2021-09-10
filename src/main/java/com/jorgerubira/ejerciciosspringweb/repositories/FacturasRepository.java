package com.jorgerubira.ejerciciosspringweb.repositories;

import com.jorgerubira.ejerciciosspringweb.entities.Facturas;
import org.springframework.data.repository.CrudRepository;

public interface FacturasRepository extends CrudRepository<Facturas, Integer>{
    
}
