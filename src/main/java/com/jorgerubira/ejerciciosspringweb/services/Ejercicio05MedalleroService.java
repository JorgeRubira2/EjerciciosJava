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
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class Ejercicio05MedalleroService implements IEjercicio05MedalleroService {

    private List<Medalla> medallas = new ArrayList<>();
    private List<MedallaPais> paises = new ArrayList<>();
    private List<MedallaAtleta> atletas = new ArrayList<>();

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

    @Override
    public void altaMedalla(Medalla medalla) {
        if (medalla != null) {
            medallas.add(medalla);
        }
    }

    @Override
    public List<Medalla> getMedallas() {

        return medallas;
    }

    @Override
    public List<MedallaPais> obtenerRankingPorPais() {
        Map<String, Long> oro = medallas.stream().filter(x -> x.getMedalla().equals("Oro")).collect(Collectors.groupingBy(x -> x.getPais(), Collectors.counting()));
        Map<String, Long> plata = medallas.stream().filter(x -> x.getMedalla().equals("Plata")).collect(Collectors.groupingBy(x -> x.getPais(), Collectors.counting()));
        Map<String, Long> bronce = medallas.stream().filter(x -> x.getMedalla().equals("Cobre")).collect(Collectors.groupingBy(x -> x.getPais(), Collectors.counting()));
        oro.keySet().forEach(x -> {
            Optional<Integer> oroCount = oro.entrySet().stream().filter(y -> y.getKey().equals(x)).map(y -> y.getValue().intValue()).findFirst();
            Optional<Integer> plataCount = plata.entrySet().stream().filter(y -> y.getKey().equals(x)).map(y -> y.getValue().intValue()).findFirst();
            Optional<Integer> cobreCount = bronce.entrySet().stream().filter(y -> y.getKey().equals(x)).map(y -> y.getValue().intValue()).findFirst();
            int oroAux = 0, plataAux = 0, cobreAux = 0;
            if (oroCount.isPresent()) {
                oroAux = oroCount.get();
            }
            if (plataCount.isPresent()) {
                plataAux = plataCount.get();
            }
            if (cobreCount.isPresent()) {
                cobreAux = cobreCount.get();
            }
            paises.add(new MedallaPais(x, oroAux, plataAux, cobreAux));

        });
        plata.keySet().forEach(x -> {
            Optional<Integer> plataCount = plata.entrySet().stream().filter(y -> y.getKey().equals(x)).map(y -> y.getValue().intValue()).findFirst();
            Optional<Integer> cobreCount = bronce.entrySet().stream().filter(y -> y.getKey().equals(x)).map(y -> y.getValue().intValue()).findFirst();
            int plataAux = 0, cobreAux = 0;
            if (plataCount.isPresent()) {
                plataAux = plataCount.get();
            }
            if (cobreCount.isPresent()) {
                cobreAux = cobreCount.get();
            }
            if (!paises.parallelStream().anyMatch(y -> y.getPais().equals(x))) {
                paises.add(new MedallaPais(x, 0, plataAux, cobreAux));
            }

        });
        bronce.keySet().forEach(x -> {
            Optional<Integer> cobreCount = bronce.entrySet().stream().filter(y -> y.getKey().equals(x)).map(y -> y.getValue().intValue()).findFirst();
            int cobreAux = 0;

            if (cobreCount.isPresent()) {
                cobreAux = cobreCount.get();
            }
            if (!paises.parallelStream().anyMatch(y -> y.getPais().equals(x))) {
                paises.add(new MedallaPais(x, 0, 0, cobreAux));
            }
        });
        paises = paises.stream().sorted((x, y) -> x.getPais().compareTo(y.getPais())).collect(Collectors.toList());
        return paises;
    }

    @Override
    public List<String> obtenerDeportesDeUnaMedalla(String pais, String medalla) {
        return medallas.stream().filter(x -> x.getPais().equals(pais)).filter(x -> x.getMedalla().equals(medalla)).map(x -> x.getDeporte()).collect(Collectors.toList());

    }

    @Override
    public List<String> obtenerDeportesConMedalla(String pais) {
        return medallas.stream().filter(x -> x.getPais().equals(pais)).filter(x -> x.getMedalla() != null).map(x -> x.getDeporte()).collect(Collectors.toList());
    }

    @Override
    public List<MedallaAtleta> obtenerRankingPorAlteta() {
        Map<String, Long> oro = medallas.stream().filter(x -> x.getMedalla().equals("Oro")).collect(Collectors.groupingBy(x -> x.getDeportistas(), Collectors.counting()));
        Map<String, Long> plata = medallas.stream().filter(x -> x.getMedalla().equals("Plata")).collect(Collectors.groupingBy(x -> x.getDeportistas(), Collectors.counting()));
        Map<String, Long> bronce = medallas.stream().filter(x -> x.getMedalla().equals("Cobre")).collect(Collectors.groupingBy(x -> x.getDeportistas(), Collectors.counting()));
        oro.keySet().forEach(x -> {
            Optional<Integer> oroCount = oro.entrySet().stream().filter(y -> y.getKey().equals(x)).map(y -> y.getValue().intValue()).findFirst();
            Optional<Integer> plataCount = plata.entrySet().stream().filter(y -> y.getKey().equals(x)).map(y -> y.getValue().intValue()).findFirst();
            Optional<Integer> cobreCount = bronce.entrySet().stream().filter(y -> y.getKey().equals(x)).map(y -> y.getValue().intValue()).findFirst();
            int oroAux = 0, plataAux = 0, cobreAux = 0;
            if (oroCount.isPresent()) {
                oroAux = oroCount.get();
            }
            if (plataCount.isPresent()) {
                plataAux = plataCount.get();
            }
            if (cobreCount.isPresent()) {
                cobreAux = cobreCount.get();
            }
            atletas.add(new MedallaAtleta(x, oroAux, plataAux, cobreAux));
        });
         plata.keySet().forEach(x -> {
            Optional<Integer> plataCount = plata.entrySet().stream().filter(y -> y.getKey().equals(x)).map(y -> y.getValue().intValue()).findFirst();
            Optional<Integer> cobreCount = bronce.entrySet().stream().filter(y -> y.getKey().equals(x)).map(y -> y.getValue().intValue()).findFirst();
            int plataAux = 0, cobreAux = 0;
            if (plataCount.isPresent()) {
                plataAux = plataCount.get();
            }
            if (cobreCount.isPresent()) {
                cobreAux = cobreCount.get();
            }
            if (!atletas.parallelStream().anyMatch(y -> y.getAtleta().equals(x))) {
                atletas.add(new MedallaAtleta(x, 0, plataAux, cobreAux));
            }

        });
        bronce.keySet().forEach(x -> {
            Optional<Integer> cobreCount = bronce.entrySet().stream().filter(y -> y.getKey().equals(x)).map(y -> y.getValue().intValue()).findFirst();
            int cobreAux = 0;

            if (cobreCount.isPresent()) {
                cobreAux = cobreCount.get();
            }
            if (!atletas.parallelStream().anyMatch(y -> y.getAtleta().equals(x))) {
                atletas.add(new MedallaAtleta(x, 0, 0, cobreAux));
            }
        });
         atletas = atletas.stream().sorted((x, y) -> x.getAtleta().compareTo(y.getAtleta())).collect(Collectors.toList());

        return atletas;
    }

}
