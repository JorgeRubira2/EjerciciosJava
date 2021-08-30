/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.repositories;

import com.jorgerubira.ejerciciosspringweb.entities.Valor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author janus
 */
public interface ValoresRepository extends JpaRepository<Valor, Integer>{
    List<Valor> findByValorAndImporteUnitario(String valor, Float importe);
}
