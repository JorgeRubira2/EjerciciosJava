
package com.jorgerubira.ejerciciosspringweb.repositories;

import com.jorgerubira.ejerciciosspringweb.entities.Imagen;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ImagenesRepository extends JpaRepository<Imagen, Integer>{
    List<Imagen> findByDescripcionContains(String desc); 
}
