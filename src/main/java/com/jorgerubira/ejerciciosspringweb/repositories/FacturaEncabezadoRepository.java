/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.repositories;

import com.jorgerubira.ejerciciosspringweb.entities.FacturaEncabezado;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Jesus
 */
public interface FacturaEncabezadoRepository extends JpaRepository<FacturaEncabezado,Integer> {
    
}
