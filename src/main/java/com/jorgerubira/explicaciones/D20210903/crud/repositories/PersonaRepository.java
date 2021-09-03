package com.jorgerubira.explicaciones.D20210903.crud.repositories;

import com.jorgerubira.explicaciones.D20210903.crud.entities.PersonaDia3;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PersonaRepository extends CrudRepository<PersonaDia3, Integer>{
    
    //@Query(value = "call proc(:nombre)", nativeQuery = true)
    //public void procedimiento(String nombre);
}
