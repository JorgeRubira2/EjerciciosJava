package com.jorgerubira.practicas.preparados.concurrency;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Principal {
    
    private static int valor=0;
    private static HashMap<String, Integer> ht=new HashMap<>();
    
    public static void incrementar() throws Exception {
        int a=valor;
        //Thread.sleep(100);
        a++;
        valor=a;
    }

    public static void tratar() {
        try{
            for(int n=0;n<10;n++){
                incrementar();
                System.out.println(n);
            }
        }catch(Exception e){
        }
    }
    
    public static void imprimir() {
        try{
            for(int n=0;n<5;n++){
                System.out.println(n);
                Thread.sleep(1000);
            }
        }catch(Exception e){
        }
    }
    
    public static int calcular() {
        int sum=0;
        try{
            for(int n=0;n<5;n++){
                sum+=n;
                Thread.sleep(1000);
            }
        }catch(Exception e){
        }
        return sum;
    }    
    
    public static void usoHiloSimple(){
        ExecutorService service=null;
        try{
            service = Executors.newSingleThreadExecutor();
            service.execute(()->imprimir() );
            service.execute(()->imprimir() );
        } finally {
            if (service!=null) service.shutdown();
        }
    }
    
    public static void usoCalcularHiloSimple(){
        ExecutorService service=null;
        try{
            service = Executors.newSingleThreadExecutor();
            Future<Integer> valor1= service.submit(()->calcular());
            Future<Integer> valor2= service.submit(()->calcular());
            System.out.println(valor1.get().intValue() + valor2.get().intValue());
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            if (service!=null) service.shutdown();
        }
    }

    public static void usoSincronized(){
        ExecutorService service=null;
        try{
            service = Executors.newFixedThreadPool(2);
            service.execute(()->tratar());
            service.execute(()->tratar());
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            if (service!=null) service.shutdown();
        }
        try {
          service.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
        }        
    }

    public static void usoSincronized2(){
        ExecutorService service=null;
        try{
            service = Executors.newFixedThreadPool(100);
            for (int n=0;n<10;n++){
                service.execute(()->{
                    for (int m=0;m<10;m++){
                        ht.put(UUID.randomUUID().toString(), 3);  
                    }
                });
            }
        } catch(Exception e){
            e.printStackTrace();
        } finally {
            if (service!=null) service.shutdown();
        }
        try {
          service.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
        }        
    }

    
    
    public static void usoHiloMultiple(){
        ExecutorService service=null;
        try{
            service = Executors.newFixedThreadPool(2);
            service.execute(()->imprimir() );
            service.execute(()->imprimir() );
            service.execute(()->imprimir() );
        } finally {
            if (service!=null) service.shutdown();
        }
    }
    
    public static void usoHiloDinamico(){
        ExecutorService service=null;
        try{
            service = Executors.newCachedThreadPool();
            service.execute(()->imprimir() );
            service.execute(()->imprimir() );
            service.execute(()->imprimir() );
        } finally {
            if (service!=null) service.shutdown();
        }
    }    

    public static void usoHiloConRetraso(){
        ScheduledExecutorService service=null;
        try{
            service = Executors.newScheduledThreadPool(2);
            service.schedule(()->imprimir(), 2, TimeUnit.SECONDS);
            service.schedule(()->imprimir(), 2, TimeUnit.SECONDS);
            
        } finally {
            if (service!=null) service.shutdown();
        }
    } 
    
    public static void usoHiloProgramado(){
        ScheduledExecutorService service=null;
        OffsetDateTime now = OffsetDateTime.now() ;

        service = Executors.newScheduledThreadPool(1);
        service.scheduleAtFixedRate(
                ()->imprimir(),
                Duration.between(
                        now, 
                        now.toLocalDate().plusDays(1).atStartOfDay()
                ).toMillis(),
                1,
                TimeUnit.DAYS
        );
    }     
    
    public static void usoHiloProgramado2(){
        ScheduledExecutorService service=null;
        service = Executors.newScheduledThreadPool(1);
        service.scheduleAtFixedRate(
                ()->imprimir(),0,10,TimeUnit.SECONDS
        );
    }     

    public static void main(String[] args) {
        usoSincronized2();
        System.out.println("Fin" + valor);
        System.out.println("Tam" + ht.size());
    }
}
