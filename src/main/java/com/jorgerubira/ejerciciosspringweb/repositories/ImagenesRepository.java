/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.repositories;
import com.jorgerubira.ejerciciosspringweb.entities.Imagenes;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Aran
 */
public interface ImagenesRepository extends JpaRepository<Imagenes, Integer> {
    
    public Imagenes findByRuta(String ruta);
   // public Imagenes findByDescripcion(String descripcion);
    public List <Imagenes> findByDescripcionContaining(String descripcion);
    
   

   
   
  
    
    
}
