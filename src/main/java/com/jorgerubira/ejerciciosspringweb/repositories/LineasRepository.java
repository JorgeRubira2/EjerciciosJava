package com.jorgerubira.ejerciciosspringweb.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jorgerubira.ejerciciosspringweb.entities.FacturaLineas;

public interface LineasRepository extends JpaRepository<FacturaLineas, Integer>{

}
