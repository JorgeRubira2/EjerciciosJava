package com.jorgerubira.ejerciciosspringweb.repositories;

import com.jorgerubira.ejerciciosspringweb.entities.Imagen;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface GestionImagenesRepository extends CrudRepository<Imagen, Integer>{
    
    public Imagen findByAleatorio(String aleatorio);
    
    public List <Imagen> findByDescripcionContaining(String descripcion);
}
