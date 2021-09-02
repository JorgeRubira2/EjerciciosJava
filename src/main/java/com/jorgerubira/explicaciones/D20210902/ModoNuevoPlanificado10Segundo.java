
package com.jorgerubira.explicaciones.D20210902;

import static com.jorgerubira.explicaciones.D20210902.ModoNuevoRetardo.algoritmo1;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.temporal.Temporal;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ModoNuevoPlanificado10Segundo {
    public static void algoritmo1(){
        for (int n=0;n<5;n++){
            System.out.println(n);
            try{ Thread.sleep((int)(Math.random()*20)); }catch(Exception e){
            }
            try{ Thread.sleep(3000); }catch(Exception e){}
            

        }         
    }  
    
    public static void algoritmo2(){
        for (int n=0;n<5;n++){
            System.out.println(n);
            try{ Thread.sleep((int)(Math.random()*20)); }catch(Exception e){
            }
        }         
    }
    
    public static void trabajo(){
        algoritmo1();
        algoritmo2();
    }
    
    public static void main(String[] args) {
        ScheduledExecutorService pool = null;
        pool=Executors.newScheduledThreadPool(1);
        pool.scheduleAtFixedRate(()->trabajo(), 0, 10, TimeUnit.SECONDS);   //Lo ejecuta de manera periodica
    }      
}
