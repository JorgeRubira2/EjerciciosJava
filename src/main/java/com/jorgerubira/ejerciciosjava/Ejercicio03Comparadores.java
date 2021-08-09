package com.jorgerubira.ejerciciosjava;

import java.util.Optional;

public class Ejercicio03Comparadores {

    //Debe devolver true si los dos enteros contienen el mismo valor.
    //Si no devuelve false
    //Si se envia null en cualquiera de ellos devuelve false 
    public boolean compararEnteros(Integer i1, Integer i2) {
        if (i1 != null && i2 != null){
            return i1==i2;
        } else {
            return false;
        }
    }

    //Debe devolver true si los dos enteros contienen el mismo valor.
    //Si no devuelve false
    //Si se envia null en cualquiera de ellos devuelve false
    public boolean compararEnteroConLong(Integer i1, Long i2) {
       Integer copia=Integer.parseInt(i2.toString());
	if(copia==i1 && copia!=null && i1 != null) return true;
	else return false;
    }

    //Debe devolver true si el texto que se ha enviado en un número. 
    //Si no devuelve false
    //Si se envia null devuelve false
    public boolean comprobarNumero(String numero) {
        try {
            Integer.parseInt(numero);
            return true;
        }catch (Exception e){
            return false;
    }

    //Debe devolver true si los dos números son iguales. 
    //Si no devuelve false
    //Si se envia null en cualquier de ellos devuelve false
  /*
    
*/
  
 

    //Debe devolver true si los dos números son iguales. 
    //Si no devuelve false
    //Si los dos tienen null devuelve false.
}
    
     public boolean comprobarOptionalConInteger(Optional<Integer> valor1, Integer valor2) {
        
      int num1 = (valor1.get()).intValue();
        double num2 = (valor2).doubleValue();
        if(num1==num2) 
            return true;
        else 
        	return false;
    }    
      
    
       public boolean comprobarOptionalesIntegerYDouble(Optional<Integer> valor1, Optional<Double> valor2) {
       int num1 = (valor1.get()).intValue();
        double num2 = (valor2.get()).doubleValue();
        if(num1==num2) 
            return true;
        else 
        	return false;
    }   
    }
