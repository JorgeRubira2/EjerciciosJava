/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.repositories;

import com.jorgerubira.ejerciciosspringweb.domain.Imagen;
import org.springframework.data.repository.CrudRepository;

public interface ImagenRepository extends CrudRepository<Imagen, Integer> {
    
    public Imagen findByRuta(String id);
     
}
