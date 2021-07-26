package com.jorgerubira.ejerciciosjava;

import java.util.Optional;

public class Ejercicio03Comparadores {
    
    //Debe devolver true si los dos enteros contienen el mismo valor.
    //Si no devuelve false
    //Si se envia null en cualquiera de ellos devuelve false
    public boolean compararEnteros(Integer i1, Integer i2){
        //opcion b
        if (i1 != null && i2 != null){
            return i1.equals(i2);
        } else {
            return false;
        }
        
//        opcion a
//        try {
//            return i1.equals(i2);
//        }catch (Exception e){
//            return false;
//        }
    }
    
    //Debe devolver true si los dos enteros contienen el mismo valor.
    //Si no devuelve false
    //Si se envia null en cualquiera de ellos devuelve false
    public boolean compararEnteroConLong(Integer i1, Long i2){
          //opcion c
          
          if (i1 != null && i2!= null) {
              //return i1.longValue()==i2.longValue();
              return i1.longValue()==i2.longValue();
          } else {
              return false;
          }
                  
          // opcion b
//        int i=0;
//        long j= 0;
//        try { 
//            i = i1.intValue();
//            j = i2.longValue();
//           // opcion a
//           // i = Integer.valueOf(i1);
//           // j=  Long.valueOf(i2);
//        }catch (Exception e){
//            return false;
//        }
//        return i == j;
    }    

    //Debe devolver true si el texto que se ha enviado en un número. 
    //Si no devuelve false
    //Si se envia null devuelve false
    public boolean comprobarNumero(String numero){
        try {
            Double.parseDouble(numero);
            return true;
        }catch (Exception e){
            return false;
        }
    }    
    
    //Debe devolver true si los dos números son iguales. 
    //Si no devuelve false
    //Si se envia null en cualquier de ellos devuelve false
    public boolean comprobarOptionalConInteger(Optional<Integer> valor1, Integer valor2){
        try {
            int i = (valor1.get()).intValue();
            int j = valor2.intValue();
            // opcion a
            //int i = Integer.valueOf(valor1.get());
            //int j = Integer.valueOf(valor2);
            return i == j;
        }catch (Exception e){
            return false;
        }
        
        
    }    

    //Debe devolver true si los dos números son iguales. 
    //Si no devuelve false
    //Si los dos tienen null devuelve false.
    public boolean comprobarOptionalesIntegerYDouble(Optional<Integer> valor1, Optional<Double> valor2){
        try{
            int i = (valor1.get()).intValue();
            double j = (valor2.get()).doubleValue();
            //opcion a
            //int i = Integer.valueOf(valor1.get());
            //double j = Double.valueOf(valor2.get());
            return i == j;
        }catch (Exception e){
            return false;
        }
    }    

}
