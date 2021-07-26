package com.jorgerubira.ejerciciosjava;

import java.util.Optional;

public class Ejercicio03Comparadores {
    
    //Debe devolver true si los dos enteros contienen el mismo valor.
    //Si no devuelve false
    //Si se envia null en cualquiera de ellos devuelve false
    public boolean compararEnteros(Integer i1, Integer i2){
        try{
        return i1.equals(i2);
        }catch(NullPointerException e){
            return false;
        }
    } 
    
    //Debe devolver true si los dos enteros contienen el mismo valor.
    //Si no devuelve false
    //Si se envia null en cualquiera de ellos devuelve false
    public boolean compararEnteroConLong(Integer i1, Long i2){
        if (i1 != null && i2 != null){
            return i1.equals(i2.intValue());
        }
        return false;      
    }

    //Debe devolver true si el texto que se ha enviado en un número. 
    //Si no devuelve false
    //Si se envia null devuelve false
    public boolean comprobarNumero(String numero){
      try{
          if(numero != null){
              double num=Double.parseDouble(numero);
              return true;
          } 
      }catch(NumberFormatException e) {
          return false;
      }
      return false;
    }      
    
    //Debe devolver true si los dos números son iguales. 
    //Si no devuelve false
    //Si se envia null en cualquier de ellos devuelve false
    public boolean comprobarOptionalConInteger(Optional<Integer> valor1, Integer valor2){
      

        if(valor1.isEmpty() || valor2 == null ){
        return false;
        }else if (valor1.get().equals(valor2)){
            return true;
        }
       return false;        
    } 

    //Debe devolver true si los dos números son iguales. 
    //Si no devuelve false
    //Si los dos tienen null devuelve false.
    public boolean comprobarOptionalesIntegerYDouble(Optional<Integer> valor1, Optional<Double> valor2){
        if(valor1.isPresent() && valor2.isPresent()){
            Integer va1=valor1.get();
            double va2=valor2.get();
            return va1.equals(va2);
            
            
            
        }
    }    

}
