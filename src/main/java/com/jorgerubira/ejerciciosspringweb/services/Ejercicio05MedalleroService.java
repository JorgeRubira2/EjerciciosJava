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
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class Ejercicio05MedalleroService implements IEjercicio05MedalleroService{
    
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
        List<String> paises = medallas.stream()
                                      .map(x->x.getPais())
                                      .distinct()
                                      .collect(Collectors.toList());
        
        List<MedallaPais> paso1 = paises.stream()
                                      .map(x->new MedallaPais(x,0,0,0))
                                      .collect(Collectors.toList());

        paso1.forEach(x->{
            x.setOro((int)medallas.stream()
                                  .filter(y->y.getMedalla().equals("Oro"))
                                  .filter(y->y.getPais().equals(x))
                                  .count()
            );
        });
        
        
        
        List<MedallaPais> res=paises.stream()
                                    .map(x-> new MedallaPais(
                                                x,
                                                (int)medallas.stream()
                                                        .filter(y->y.getMedalla().equals("Oro"))
                                                        .filter(y->y.getPais().equals(x))
                                                        .count(),
                                                (int)medallas.stream()
                                                        .filter(y->y.getMedalla().equals("Plata"))
                                                        .filter(y->y.getPais().equals(x))
                                                        .count(),                                                                
                                                (int)medallas.stream()
                                                        .filter(y->y.getMedalla().equals("Cobres"))
                                                        .filter(y->y.getPais().equals(x))
                                                        .count()
                                    ))
                                    .sorted((x,y) -> (y.getOro()+y.getPlata()+y.getCobre()) - (x.getOro()+x.getPlata()+x.getCobre()) )
                                    .collect(Collectors.toList());
        return res;
    }

    @Override
    public List<String> obtenerDeportesDeUnaMedalla(String pais, String medalla) {
        List<String> deportes=medallas.stream()
                .filter(x->medalla.equals(x.getMedalla()))
                .filter(x->medalla.equals(x.getPais()))
                .map(x->x.getDeporte())
                .collect(Collectors.toList());
        return deportes;
    }

    @Override
    public List<String> obtenerDeportesConMedalla(String pais) {
        List<String> deportes=medallas.stream()
                .filter(x->pais.equals(x.getPais()))
                .map(x->x.getDeporte())
                .collect(Collectors.toList());
        return deportes;
    }

    @Override
    public List<MedallaAtleta> obtenerRankingPorAlteta() {
        Set<String> atleta=medallas.stream()
                    .map(x->x.getDeportistas())
                    .collect(Collectors.toSet());
        List<MedallaAtleta> medallasDep=atleta.stream()
                .map(x->new MedallaAtleta(x,
                Integer.parseInt(Long.toString(medallas.stream().filter(y->x.equals(y.getDeportistas()) && "Oro".equals(y.getMedalla())).count())),
                Integer.parseInt(Long.toString(medallas.stream().filter(y->x.equals(y.getDeportistas()) && "Plata".equals(y.getMedalla())).count())),
                Integer.parseInt(Long.toString(medallas.stream().filter(y->x.equals(y.getDeportistas()) && "Bronce".equals(y.getMedalla())).count()))
                ))
                .collect(Collectors.toList());
        return medallasDep;
    }
    
}
