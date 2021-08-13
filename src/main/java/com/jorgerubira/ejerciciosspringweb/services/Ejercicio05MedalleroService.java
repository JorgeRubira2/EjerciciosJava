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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 */
@Service
public class Ejercicio05MedalleroService implements IEjercicio05MedalleroService {
    
    private List<Medalla> medallas = new ArrayList<>();
    
    public Ejercicio05MedalleroService(){ 
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

    @Override
    public void altaMedalla(Medalla medalla) {
        medallas.add(medalla);
    }

    @Override
    public List<Medalla> getMedallas() {
        return medallas;
    }

    @Override
    public List<MedallaPais> obtenerRankingPorPais() {
        return medallas.stream()
                .collect(Collectors.groupingBy(m->m.getPais()))
                .entrySet().stream()
                .map(x->new MedallaPais(x.getKey(),
                        (int)x.getValue().stream().filter(m->"Oro".equals(m.getMedalla())).count(),
                        (int)x.getValue().stream().filter(m->"Plata".equals(m.getMedalla())).count(),
                        (int)x.getValue().stream().filter(m->"Bronce".equals(m.getMedalla())).count()))
                .sorted((x,y)->{
                    if(y.getOro()==x.getOro()){
                        if(y.getPlata()==x.getPlata()){
                            return y.getCobre()-x.getCobre();
                        } else {
                            return y.getPlata()-x.getPlata();
                        }
                    } else {
                        return y.getOro()-x.getOro();
                    }
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<String> obtenerDeportesDeUnaMedalla(String pais, String medalla) {
        return medallas.stream()
                .filter(m->medalla.equals(m.getMedalla()))
                .filter(m->pais.equals(m.getPais()))
                .map(m->m.getDeporte())
                .collect(Collectors.toList());
    }

    @Override
    public List<String> obtenerDeportistasConMedalla(String pais) {
        return medallas.stream()
                .filter(m->pais.equals(m.getPais()))
                .map(m->m.getDeportistas())
                .collect(Collectors.toList());
    }

    @Override
    public List<MedallaAtleta> obtenerRankingPorAlteta() {
        return medallas.stream()
                .collect(Collectors.groupingBy(m->m.getDeportistas()))
                .entrySet().stream()
                .map(x->new MedallaAtleta(x.getKey(),
                        (int)x.getValue().stream().filter(m->"Oro".equals(m.getMedalla())).count(),
                        (int)x.getValue().stream().filter(m->"Plata".equals(m.getMedalla())).count(),
                        (int)x.getValue().stream().filter(m->"Bronce".equals(m.getMedalla())).count()))
                .sorted((x,y)->{
                    if(y.getOro()==x.getOro()){
                        if(y.getPlata()==x.getPlata()){
                            return y.getCobre()-x.getCobre();
                        } else {
                            return y.getPlata()-x.getPlata();
                        }
                    } else {
                        return y.getOro()-x.getOro();
                    }
                })
                .collect(Collectors.toList());
    }
}
