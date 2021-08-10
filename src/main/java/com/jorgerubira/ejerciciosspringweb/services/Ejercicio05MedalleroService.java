package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.domain.Medalla;
import com.jorgerubira.ejerciciosspringweb.domain.MedallaAtleta;
import com.jorgerubira.ejerciciosspringweb.domain.MedallaPais;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio05MedalleroService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

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
    public List<MedallaPais> obtenerRankingPorPais() { //habria que pasar pais?
        return medallas.stream()
                .collect(Collectors.groupingBy((x)-> x.getPais(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((x,y) -> y.getValue().intValue()-x.getValue().intValue())
                .map(x-> new MedallaPais(
                            x.getKey(),
                            (int)medallas.stream().filter(z->z.getPais().equals(x.getKey()) && "Oro".equals(z.getMedalla())).count(),
                            (int)medallas.stream().filter(z->z.getPais().equals(x.getKey()) && "Plata".equals(z.getMedalla())).count(),
                            (int)medallas.stream().filter(z->z.getPais().equals(x.getKey()) && "Cobre".equals(z.getMedalla())).count()
                )).collect(Collectors.toList());
    }

    @Override
    public List<String> obtenerDeportesDeUnaMedalla(String pais, String medalla) {
        return medallas.parallelStream()
                        .filter(x-> pais.equalsIgnoreCase(x.getPais()))
                        .filter(x-> medalla.equalsIgnoreCase(x.getMedalla()))
                        .map(x-> x.getDeporte())
                        .collect(Collectors.toList());
    }

    @Override
    public List<String> obtenerDeportesConMedalla(String pais) {
        return medallas.parallelStream()
                        .filter(x-> pais.equalsIgnoreCase(x.getPais()))
                        .map(x-> x.getDeporte())
                        .collect(Collectors.toList());
    }

    @Override
    public List<MedallaAtleta> obtenerRankingPorAlteta() {
        return medallas.stream()
                .collect(Collectors.groupingBy((x)-> x.getDeportistas(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((x,y) -> y.getValue().intValue()-x.getValue().intValue())
                .map(x-> new MedallaAtleta(
                            x.getKey(),
                            (int)medallas.stream().filter(z->z.getPais().equals(x.getKey()) && "Oro".equals(z.getMedalla())).count(),
                            (int)medallas.stream().filter(z->z.getPais().equals(x.getKey()) && "Plata".equals(z.getMedalla())).count(),
                            (int)medallas.stream().filter(z->z.getPais().equals(x.getKey()) && "Cobre".equals(z.getMedalla())).count()
                )).collect(Collectors.toList());
    }
    
    
}
