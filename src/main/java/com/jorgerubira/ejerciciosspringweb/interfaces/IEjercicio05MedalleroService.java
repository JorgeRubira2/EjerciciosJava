/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.interfaces;

import com.jorgerubira.ejerciciosspringweb.domain.Medalla;
import com.jorgerubira.ejerciciosspringweb.domain.MedallaAtleta;
import com.jorgerubira.ejerciciosspringweb.domain.MedallaPais;
import java.util.List;

public interface IEjercicio05MedalleroService {
 
    public void altaMedalla(Medalla medalla);
    public List<Medalla> getMedallas();

    //Listas calculadas a partir del List<Medalla>
    public List<MedallaPais> obtenerRankingPorPais();
    public List<String> obtenerDeportesDeUnaMedalla(String pais, String medalla);
    public List<String> obtenerDeportistasConMedalla(String pais);
    public List<MedallaAtleta> obtenerRankingPorAlteta();
    
}
