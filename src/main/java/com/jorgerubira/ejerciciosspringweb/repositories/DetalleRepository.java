package com.jorgerubira.ejerciciosspringweb.repositories;

import com.jorgerubira.ejerciciosspringweb.entities.Detalle;
import com.jorgerubira.ejerciciosspringweb.entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleRepository extends JpaRepository<Detalle, Long> {
    List<Detalle> findByFactura(Factura factura);
}
