
package com.jorgerubira.explicaciones.D20210902;

import static com.jorgerubira.explicaciones.D20210902.ModoNuevoAutomatico.algoritmo1;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class ModoNuevoObtenerDatos {
    public static int algoritmo1(){
        int suma=0;
        for (int n=0;n<5;n++){
            suma+=n;
            System.out.println(n);
            try{ Thread.sleep((int)(Math.random()*20)); }catch(Exception e){}
        }         
        return suma;
    }  
    public static int algoritmo2(){
        int suma=0;
        for (int n=6;n<10;n++){
            suma+=n;
            System.out.println(n);
            try{ Thread.sleep((int)(Math.random()*20)); }catch(Exception e){}
        }         
        return suma;
    }    
    
    public static void main(String[] args) {
        ExecutorService pool = null;
        try{
            pool=Executors.newCachedThreadPool();
            Future<Integer> promesa1=pool.submit(()->algoritmo1());
            Future<Integer> promesa2=pool.submit(()->algoritmo2());
            System.out.println("End");
            System.out.println("Suma " + (promesa1.get().intValue() + promesa2.get().intValue()));
            System.out.println("End 2");
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            pool.shutdown();    
        }    
    }
    
}
