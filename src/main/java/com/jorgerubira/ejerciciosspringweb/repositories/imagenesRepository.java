package com.jorgerubira.ejerciciosspringweb.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jorgerubira.ejerciciosspringweb.entities.Imagen;

public interface imagenesRepository extends JpaRepository<Imagen, Integer> {
	 public List<Imagen>findByDescripcion(String descripcion);
	}
    

