package com.jorgerubira.ejerciciosjava;

import java.util.Optional;

public class Ejercicio03Comparadores {

    
    //Debe devolver true si los dos enteros contienen el mismo valor.
    //Si no devuelve false
    //Si se envia null en cualquiera de ellos devuelve false
    public boolean compararEnteros(Integer i1, Integer i2){
        if(i1==null && i2==null){
            return false;
        }
        try {
            return i1.equals(i2);
        } catch (Exception e) {
            return false;
        }
}
    
    //Debe devolver true si los dos enteros contienen el mismo valor.
    //Si no devuelve false
    //Si se envia null en cualquiera de ellos devuelve false
    public boolean compararEnteroConLong(Integer i1, Long i2){
        
        try {
            if(i1!=null && i2!=null){
                
            return Long.valueOf(i1).equals(i2);
            
            }else{
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }    

    //Debe devolver true si el texto que se ha enviado en un número. 
    //Si no devuelve false
    //Si se envia null devuelve false
    public boolean comprobarNumero(String numero){
        try {
            if(numero!=null){
                return false;
            }else{
                Integer.parseInt(numero);
            return true;
                
            }
                
        } catch (NumberFormatException e) {
            return false;
        }
    }    
    
    //Debe devolver true si los dos números son iguales. 
    //Si no devuelve false
    //Si se envia null en cualquier de ellos devuelve false
    public boolean comprobarOptionalConInteger(Optional<Integer> valor1, Integer valor2){
        //Integer var = valor1.get();     Puesto en el if
        if(valor1.isPresent() && valor2!=null && valor1.get().equals(valor2)){
            return true;
        }else{
            return false;
        }
    }    

    //Debe devolver true si los dos números son iguales. 
    //Si no devuelve false
    //Si los dos tienen null devuelve false.
    public boolean comprobarOptionalesIntegerYDouble(Optional<Integer> valor1, Optional<Double> valor2){
        throw new RuntimeException("Pendiente de hacer");
    }    

}
