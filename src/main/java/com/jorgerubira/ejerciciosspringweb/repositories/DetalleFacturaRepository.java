/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.repositories;

import com.jorgerubira.ejerciciosspringweb.entities.DetalleFactura;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Isabel
 */
@Repository
public interface DetalleFacturaRepository extends CrudRepository<DetalleFactura, Long> {
    
    //Buscar líneas por idFactura
    List<DetalleFactura> findByIdFactura(Long idFactura);
}
