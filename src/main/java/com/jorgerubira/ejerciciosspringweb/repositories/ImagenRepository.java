/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.repositories;


import com.jorgerubira.ejerciciosspringweb.entities.Imagen;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Mohamad
 */
public interface ImagenRepository extends JpaRepository<Imagen,Integer> {
    public List<Imagen> findByDescripcionContaining(String descripcion);
}
