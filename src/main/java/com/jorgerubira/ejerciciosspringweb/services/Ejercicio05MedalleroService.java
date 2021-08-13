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
import java.util.Optional;
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
        
        /*
         List<Ciudad> lst = new LinkedList<>();
        lista.stream()
                .collect(Collectors.groupingBy(
                        x -> x.getCiudad(),
                        Collectors.counting()
                )).forEach((ciudad, cant) -> {
            int personas = Math.toIntExact(cant);
            Ciudad c = new Ciudad(ciudad, personas);
            lst.add(c);
        });
        */
        
        List<MedallaPais> mPais = new ArrayList<>();
       /* medallas.stream().collect(Collectors.
                                             groupingBy( 
                                                     x-> x.getPais(),
                                                     Collectors.counting())).values();*/
       medallas.stream().forEach((t) -> {
            Optional<MedallaPais> pais = mPais.stream().filter(x->x.getPais().equals(t.getPais())).findFirst();
           if(pais.isEmpty()){
               
                       mPais.add(new MedallaPais(t.getPais(), "Oro".equals(t.getMedalla())?1:0, "Plata".equals(t.getMedalla())?1:0, "Cobre".equals(t.getMedalla())?1:0));
              
           }else{
                //MedallaPais ax = mPais.stream().filter(x->x.getPais().equals(pais.get().getPais())).findFirst().get();
               switch(t.getMedalla()){
                   case "Oro":
                       pais.get().setOro(pais.get().getOro()+1);
                       break;
                       
                   case "Plata":
                       pais.get().setPlata(pais.get().getPlata()+1);
                       break;
                       
                   case "Cobre":
                       pais.get().setCobre(pais.get().getCobre()+1);
                       break;
                           
               }
           }
       });
        
        
        return mPais.stream().sorted((m2, m1) -> {
            //return (m1.getOro() + m1.getPlata() + m1.getCobre() ) - (m2.getOro() + m2.getPlata() + m2.getCobre());
            return m1.getOro()-m2.getOro();
        }).collect(Collectors.toList());
    }

    @Override
    public List<String> obtenerDeportesDeUnaMedalla(String pais, String medalla) {
        //Al clickar en cantidad de medallas -> Devolver todos deportes con medalla (Oro, Plata, Cobre)
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> obtenerDeportesConMedalla(String pais) {
        //Devolver todos deportes con medalla
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MedallaAtleta> obtenerRankingPorAlteta() {
        //Al clickar en un pais -> Devolver atletas y cantidad medallas
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
