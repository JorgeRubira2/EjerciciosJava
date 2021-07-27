package com.jorgerubira.ejerciciosjava;

import java.util.Objects;
import java.util.Optional;

public class Ejercicio03Comparadores {

    //Debe devolver true si los dos enteros contienen el mismo valor.
    //Si no devuelve false
    //Si se envia null en cualquiera de ellos devuelve false
    public boolean compararEnteros(Integer i1, Integer i2){
        if(i1!=null && i2!=null){
            return i1.equals(i2);
        }
        else{
            return false;
        }
    }

    //Debe devolver true si los dos enteros contienen el mismo valor.
    //Si no devuelve false
    //Si se envia null en cualquiera de ellos devuelve false
    public boolean compararEnteroConLong(Integer i1, Long i2) {

        if(i1!=null && i2!=null && i1.intValue() == i2.longValue()){
            return true;
        }else{
            return false;
        }
    }

    //Debe devolver true si el texto que se ha enviado en un número. 
    //Si no devuelve false
    //Si se envia null devuelve false
    public boolean comprobarNumero(String numero) {
        if(numero!=null ){
            try {
                Double.parseDouble(numero);
                return true;                
            } catch (Exception e) {
                return false;
            }
        }else{
            return false;
        }
    }

    //Debe devolver true si los dos números son iguales. 
    //Si no devuelve false
    //Si se envia null en cualquier de ellos devuelve false
    public boolean comprobarOptionalConInteger(Optional<Integer> valor1, Integer valor2) {
        if(valor1.isEmpty()==false && valor2!=null && valor2.intValue() == valor1.get()){
           return true;
        }else{
            return false;
        }
        }
   
    //Debe devolver true si los dos números son iguales. 
    //Si no devuelve false
    //Si los dos tienen null devuelve false.
    public boolean comprobarOptionalesIntegerYDouble(Optional<Integer> valor1, Optional<Double> valor2) {

        if(valor1.isEmpty()==false && valor2.isEmpty()==false){
            try{
                System.out.println(Objects.equals(valor1.get(), valor2.get()));
                System.out.println(valor1.get() + " - " + valor2.get());
                return true;
            } catch (Exception e) {
                return false;
                
            }

        }else{
            return false;
        }
    }
    
    
}