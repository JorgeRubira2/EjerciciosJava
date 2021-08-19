/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.repositories;

import com.jorgerubira.ejerciciosspringweb.entities.Bolsa;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Jesus
 */
public interface BolsaRepository extends JpaRepository<Bolsa,Long>{

    /**
     *
     * @param titulo
     * @return
     */
    @Query("SELECT sum(titulos) from Bolsa  where titulo= :titulo")
    public int countSumaByTitle(String titulo);
    
}

