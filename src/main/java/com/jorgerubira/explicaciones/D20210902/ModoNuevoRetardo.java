
package com.jorgerubira.explicaciones.D20210902;

import static com.jorgerubira.explicaciones.D20210902.ModoNuevoHiloSimple.algoritmo1;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class ModoNuevoRetardo {
    public static void algoritmo1(){
        for (int n=0;n<5;n++){
            System.out.println(n);
            try{ Thread.sleep((int)(Math.random()*20)); }catch(Exception e){
            }
        }         
    } 
       
    public static void main(String[] args) {
        ScheduledExecutorService pool = null;
        try{
            System.out.println("Inicio");
            pool=Executors.newScheduledThreadPool(3);
            pool.schedule(()->algoritmo1(), 10, TimeUnit.SECONDS);
            System.out.println("End");
        }finally{
            pool.shutdown();    
        }
    }       
}
