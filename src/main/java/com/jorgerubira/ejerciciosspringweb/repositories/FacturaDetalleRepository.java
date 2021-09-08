
package com.jorgerubira.ejerciciosspringweb.repositories;

import com.jorgerubira.ejerciciosspringweb.entities.FacturaDetalle;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FacturaDetalleRepository extends JpaRepository<FacturaDetalle, Integer>{
    
}
