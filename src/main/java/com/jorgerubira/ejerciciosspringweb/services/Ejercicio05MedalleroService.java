/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.domain.Medalla;
import com.jorgerubira.ejerciciosspringweb.domain.MedallaAtleta;
import com.jorgerubira.ejerciciosspringweb.domain.MedallaPais;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio05MedalleroService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class Ejercicio05MedalleroService {
    
    private List<Medalla> medallas = new ArrayList<>();

    public Ejercicio05MedalleroService() {
        medallas.add(new Medalla("China", "Peso medio femenino", "Oro", "Lucha", "Li Qian"));
        medallas.add(new Medalla("Gran Bretaña", "Peso medio femenino", "Plata", "Lucha", "Lauren Price"));
        medallas.add(new Medalla("Kenia", "Maratón masculino", "Oro", "Atletismo", "E. Kipchoge"));
        medallas.add(new Medalla("Paises Bajos", "Maratón masculino", "Plata", "Atletismo", "A. Nageeye"));
        medallas.add(new Medalla("Bélgica", "Maratón masculino", "Cobre", "Atletismo", "B. Abdi"));
        medallas.add(new Medalla("Corea", "Nado sincronizado femenino", "Oro", "Natacion", "V. Chingireva, P. Komar"));
        medallas.add(new Medalla("China", "Nado sincronizado femenino", "Plata", "Natacion", "Y. Xiao, Q.Wang"));
        medallas.add(new Medalla("Ucrania", "Nado sincronizado femenino", "Cobre", "Natacion", "A. Savchuk, K. Sydorenko"));
        medallas.add(new Medalla("China", "Clavados masculino", "Oro", "Natacion", "Y. Cao"));
        medallas.add(new Medalla("China", "Clavados masculino", "Plata", "Natacion", "J. Yang"));
        medallas.add(new Medalla("Gran Bretaña", "Clavados masculino", "Cobre", "Natacion", "T. Daley"));
    }

    public void altaMedalla(Medalla medalla) {
        medallas.add(medalla);
    }

    public List<Medalla> getMedallas() {

        return medallas;
    }

    public List<MedallaPais> obtenerRankingPorPais() {
        List<String> paises = medallas.stream()
                .map(x -> x.getPais())
                .distinct()
                .collect(Collectors.toList());
        List<MedallaPais> resultado = paises.stream()
                .map(x -> new MedallaPais(
                x,
                (int) medallas.stream().filter(
                        y -> y.getMedalla() == "Oro" && y.getPais().equals(x)).count(),
                (int) medallas.stream().filter(
                        y -> y.getMedalla() == "Plata" && y.getPais().equals(x)).count(),
                (int) medallas.stream().filter(
                        y -> y.getMedalla() == "Cobre" && y.getPais().equals(x)).count()
        ))
                .collect(Collectors.toList());
        return resultado;
    }

    public List<String> obtenerDeportesDeUnaMedalla(String pais, String medalla) {
        List<String> resultado = medallas.stream()
                .filter(x -> x.getPais().equals(pais) && x.getMedalla().equals(medalla))
                .map(x -> x.getDeporte())
                .distinct()
                .collect(Collectors.toList());
        return resultado;
    }

//    public List<String> obtenerDeportesConMedalla(String pais) {
//
//        List<String> deportes = medallas.stream()
//                .filter(x->x.getPais().equals(pais))
//                .map(x->x.getDeporte())
//                .distinct()
//                .collect(Collectors.toList());
//        List<String> resultado = deportes.stream()
//                 .map(x-> medallas.stream().filter(y->y.getPais().equals(pais)&&y.getDeporte().equals(x).map(y->y.getMedalla())))
//                 .collect(Collectors.toList());
//        
//                 
//                
//      return resultado;
//    }

//    public List<MedallaAtleta> obtenerRankingPorAlteta() {
//
//    }
}
