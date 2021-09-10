package com.jorgerubira.ejerciciosspringweb.repositories;

import com.jorgerubira.ejerciciosspringweb.entities.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Integer> {
}