package com.jorgerubira.explicaciones.D20210830;

import java.util.ArrayList;
import java.util.List;


public class ProgramacionFuncional {
 
    public static void main(String[] args) {
        List<Coche2> coches=new ArrayList<>();
        coches.add(new Coche2(4, 5));
        coches.add(new Coche2(5, 5));
        coches.add(new Coche2(4, 3));
        
        long contar2=0;
        for(int n=0;n<coches.size();n++){
            if (coches.get(n).getPuertas()==5){
                contar2++;
            }
        }
        
        contar2=0;
        for(Coche2 c:coches){
            if (c.getPuertas()==5){
                contar2++;
            }
        }
       
        long contar=coches.stream()
                         .filter(x->x.getPuertas()==5)
                         .count();
        
    }
    
}
