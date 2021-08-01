/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210730;

import com.jorgerubira.ejerciciosjava.pojo.Persona;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 *
 * @author PC
 */
public class EjemploParallelMaxThreads {
    public static void main(String[] args) {
        List<Persona> lista=List.of(
                            new Persona("Ana"),
                            new Persona("Juan"),
                            new Persona("Fran"));
        Date dAntes=new Date();
        
        try{
            ForkJoinPool myPool = new ForkJoinPool(2);
            myPool.submit(()-> 
                    lista.parallelStream().forEach(per->per.obtenerDNI())
            ).get();
        }catch(Exception e){
        }
        
        Date dDespues=new Date();
        System.out.println((dDespues.getTime()-dAntes.getTime()));        
    }
}
