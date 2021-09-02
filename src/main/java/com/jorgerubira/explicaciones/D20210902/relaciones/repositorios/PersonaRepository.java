package com.jorgerubira.explicaciones.D20210902.relaciones.repositorios;

import com.jorgerubira.explicaciones.D20210902.relaciones.entities.Persona;
import com.jorgerubira.explicaciones.D20210902.relaciones.entities.Telefono;
import org.springframework.data.repository.CrudRepository;


public interface PersonaRepository extends CrudRepository<Persona, Integer>{
}
