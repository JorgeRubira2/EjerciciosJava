
package com.jorgerubira.explicaciones.D20210902;

import static com.jorgerubira.explicaciones.D20210902.ModoNuevoHiloSimple.algoritmo1;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ModoNuevoMultiplesHilos {
    public static void algoritmo1(){
        for (int n=0;n<5;n++){
            System.out.println(n);
            try{ Thread.sleep((int)(Math.random()*20)); }catch(Exception e){}
        }         
    }
    
    public static void main(String[] args) {
        ExecutorService pool = null;
        try{
            int procesadores=Runtime.getRuntime().availableProcessors();    //Cuantos procesadores
            System.out.println(procesadores);
            pool=Executors.newFixedThreadPool(2); //Solo 2 hilo
            pool.execute(()->algoritmo1());
            pool.execute(()->algoritmo1());
            pool.execute(()->algoritmo1());
            System.out.println("End");
        }finally{
            pool.shutdown();    
        }
    }      
}
