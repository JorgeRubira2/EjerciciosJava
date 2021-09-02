package com.jorgerubira.explicaciones.D20210902;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ModoNuevoHiloSimple {
    
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
            pool=Executors.newSingleThreadExecutor(); //Solo 1 hilo
            pool.execute(()->algoritmo1());
            pool.execute(()->algoritmo1());
            pool.execute(()->algoritmo1());
            System.out.println("End");
        }finally{
            pool.shutdown();    
        }
    }
}


