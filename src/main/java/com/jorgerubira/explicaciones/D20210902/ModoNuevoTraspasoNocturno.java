
package com.jorgerubira.explicaciones.D20210902;

import static com.jorgerubira.explicaciones.D20210902.ModoNuevoRetardo.algoritmo1;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.temporal.Temporal;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ModoNuevoTraspasoNocturno {
    public static void algoritmo1(){
        for (int n=0;n<5;n++){
            System.out.println(n);
            try{ Thread.sleep((int)(Math.random()*20)); }catch(Exception e){
            }
        }         
    }   
    
    public static void main(String[] args) {

        OffsetDateTime actual = OffsetDateTime.now();
        Temporal doceDeLaNoche=actual.toLocalDate().plusDays(1).atStartOfDay();
        long minutos=Duration.between(actual, doceDeLaNoche).toMinutes();
        
        ScheduledExecutorService pool = null;
        pool=Executors.newScheduledThreadPool(1);
        pool.scheduleAtFixedRate(()->algoritmo1(), minutos, 24*60, TimeUnit.MINUTES);   //Lo ejecuta de manera periodica
        
    }      
}
