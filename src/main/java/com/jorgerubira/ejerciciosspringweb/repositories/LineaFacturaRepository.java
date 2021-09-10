/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.repositories;
import com.jorgerubira.ejerciciosspringweb.domain.LineaFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LineaFacturaRepository extends CrudRepository<LineaFactura, Integer> {



  

}
