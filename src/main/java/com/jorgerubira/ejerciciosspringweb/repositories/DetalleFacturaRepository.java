package com.jorgerubira.ejerciciosspringweb.repositories;

import com.jorgerubira.ejerciciosspringweb.entities.DetalleFactura;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DetalleFacturaRepository extends JpaRepository<DetalleFactura, Integer> {
    
    @Query("select df from DetalleFactura df where df.factura.idFactura = :idFactura")
    public List<DetalleFactura> obtenerFacturas(Integer idFactura);
}
