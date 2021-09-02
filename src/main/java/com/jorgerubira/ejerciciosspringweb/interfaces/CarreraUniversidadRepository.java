/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.interfaces;

import com.jorgerubira.ejerciciosspringweb.entities.CarrerasUniversidad;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Joche
 */
public interface CarreraUniversidadRepository extends CrudRepository<CarrerasUniversidad, Integer>{
    
}
