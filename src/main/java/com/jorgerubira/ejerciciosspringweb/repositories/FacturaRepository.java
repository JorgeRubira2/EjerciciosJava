package com.jorgerubira.ejerciciosspringweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jorgerubira.ejerciciosspringweb.entities.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long>{

}
