/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210730;

import com.jorgerubira.ejerciciosjava.pojo.Persona;
import java.util.Date;
import java.util.List;

/**
 *
 * @author PC
 */
public class EjemploParallelStreams {
 
    public static void main(String[] args) {
        
        List<Persona> lista=List.of(
                            new Persona("Ana"),
                            new Persona("Juan"),
                            new Persona("Fran"));
        Date dAntes=new Date();
        lista.parallelStream()
             .filter(x->x.getNombre().equals("Ana")==false)
             .sequential()
             .parallel()
             .sequential()
             .forEach(per->per.obtenerDNI());
        
        Date dDespues=new Date();
        System.out.println((dDespues.getTime()-dAntes.getTime()));
    }
    //1000 pulgar
    //3000 carita
    
 
    
//DNI de Ana
//DNI de Juan
//DNI de Fran
//3046    
    
    
    //DNI de Ana
    //DNI de Juan
    //DNI de Fran
}
