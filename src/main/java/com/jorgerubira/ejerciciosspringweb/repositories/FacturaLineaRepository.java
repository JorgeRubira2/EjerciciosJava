package com.jorgerubira.ejerciciosspringweb.repositories;

import com.jorgerubira.ejerciciosspringweb.entities.FacturaLinea;
import com.jorgerubira.ejerciciosspringweb.entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaLineaRepository extends JpaRepository<FacturaLinea, Long> {
    List<FacturaLinea> findByFactura(Factura factura);
}