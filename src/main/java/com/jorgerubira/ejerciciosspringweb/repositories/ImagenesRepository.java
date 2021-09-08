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
 * @author skudo
 */
public interface ImagenesRepository extends JpaRepository<Imagenes, Integer> {
    
    //Buscar por código
    public Imagenes findByCodigo(String codigo);
    
    public List<Imagenes> findByDescripcionContaining(String descripcion);
    
}
