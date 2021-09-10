package com.jorgerubira.ejerciciosspringweb.repositories;

import com.jorgerubira.ejerciciosspringweb.entities.InteriorFactura;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InteriorFacturaRepository extends JpaRepository<InteriorFactura, Integer> {
    
    
    public List<InteriorFactura> obtenerFacturas(Integer idFactura);
}