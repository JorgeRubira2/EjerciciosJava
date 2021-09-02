
package com.jorgerubira.explicaciones.D20210902;

import static com.jorgerubira.explicaciones.D20210902.ModoNuevoHiloSimple.algoritmo1;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ModoNuevoAutomatico {
    public static void algoritmo1(){
        for (int n=0;n<5;n++){
            System.out.println(n);
            try{ Thread.sleep((int)(Math.random()*20)); }catch(Exception e){
            }
        }         
    } 
       
    public static void main(String[] args) {
        ExecutorService pool = null;
        try{
            pool=Executors.newCachedThreadPool();
            for (int n=0;n<100;n++){
                pool.execute(()->algoritmo1());
            }
            System.out.println("End");
        }finally{
            pool.shutdown();    
        }
    }       
}
