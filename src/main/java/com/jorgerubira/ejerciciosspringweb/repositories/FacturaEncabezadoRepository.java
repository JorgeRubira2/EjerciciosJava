/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.repositories;

import com.jorgerubira.ejerciciosspringweb.entities.FacturaEncabezado;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Jesus
 */
public interface FacturaEncabezadoRepository extends JpaRepository<FacturaEncabezado,Integer> {
    
    @Query(value="select id from factura_encabezado", nativeQuery=true)
    public List<Integer> findAllSelectId();
}
