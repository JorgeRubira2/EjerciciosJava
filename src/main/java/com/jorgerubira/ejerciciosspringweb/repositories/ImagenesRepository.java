package com.jorgerubira.ejerciciosspringweb.repositories;

import com.jorgerubira.ejerciciosspringweb.entities.Imagen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagenesRepository extends JpaRepository<Imagen, Long> {
}
