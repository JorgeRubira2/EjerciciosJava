package com.jorgerubira.explicaciones.D20210830;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProgramacionFuncional2 {
    public static void main(String[] args) {

        List<Coche2> coches=new ArrayList<>();
        coches.add(new Coche2(4, 5));
        coches.add(new Coche2(5, 5));
        coches.add(new Coche2(4, 3));    
        
        List<Coche> conv=coches.stream()
                               .map(x->new Coche(x.getRuedas(), x.getPuertas()))
                               .sorted((x,y)->x.getPuertas()-y.getPuertas())
                               .collect(Collectors.toList());

        //La lista de coches por tipo de puerta.
        //3 -> {(4,3)}
        //5 -> {(4,5), (5,5)}
        //Agrupacion
        
        Map<Integer, List<Coche2>> res=coches.stream()
                                             .collect(Collectors.groupingBy(x->x.getPuertas(), Collectors.toList() ));   
                                             
        System.out.println(res);
        
        //Cuenta cuantos coches hay de cada numero de ruedas.
        //4 -> 2
        //5 -> 1
        //Agrupacion
        Map<Integer, Long> contar=coches.stream()
                                        .collect(Collectors.groupingBy(x->x.getRuedas(), Collectors.counting() ));

        System.out.println(contar);

        //Que tipos de puertas hay.
        //3 5
        
        List<Integer> tiposPuertas=coches.stream()
                                         //.parallel()
                                         .map(x->new Integer(x.getPuertas()))
                                         .distinct()
                                         //.sequential()
                                         .sorted((x,y)->x-y)
                                         .collect(Collectors.toList());
                                         
        System.out.println(tiposPuertas);        
        //3 5 
        
    }
}


