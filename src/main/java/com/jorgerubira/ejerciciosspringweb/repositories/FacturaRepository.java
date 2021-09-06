package com.jorgerubira.ejerciciosspringweb.repositories;

import com.jorgerubira.ejerciciosspringweb.entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
