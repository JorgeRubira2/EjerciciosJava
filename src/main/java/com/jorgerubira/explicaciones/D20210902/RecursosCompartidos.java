
package com.jorgerubira.explicaciones.D20210902;

import static com.jorgerubira.explicaciones.D20210902.ModoNuevoObtenerDatos.algoritmo1;
import static com.jorgerubira.explicaciones.D20210902.ModoNuevoObtenerDatos.algoritmo2;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class RecursosCompartidos {
    
    public static int valor=0;
    
    public static synchronized void operacionComplejaAtomica(){
        int a=valor;
        a++;
        try{ Thread.sleep(10);}catch(Exception e){}
        valor=a;
    }

    public static void operacionComplejaAtomica2(){
        synchronized(new Integer(2)){ //Codigo. 
            int a=valor;
            a++;
            try{ Thread.sleep(10);}catch(Exception e){}
            valor=a;
        }
    }
    

    public static void main(String[] args) {
        ExecutorService pool = null;
        try{
            pool=Executors.newCachedThreadPool();
            for (int n=0;n<10;n++){
                pool.execute(()-> {
                    for (int m=0;m<10;m++){
                        operacionComplejaAtomica2();
                    }
                });
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            pool.shutdown();    
        } 
        //Esperar a que acaben los hilos.
        try{
            pool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);    
        }catch(Exception e){}
        System.out.println(valor);
        
    }
    
}
