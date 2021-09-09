
package com.jorgerubira.ejerciciosspringweb.repositories;

import com.jorgerubira.ejerciciosspringweb.entities.FacturaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface FacturaDetalleRepository extends CrudRepository<FacturaDetalle, Integer>{
    
}
