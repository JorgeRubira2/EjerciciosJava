package com.jorgerubira.ejerciciosjava;

import java.util.Optional;

public class Ejercicio03Comparadores {
    
	public boolean compararEnteros(Integer i1, Integer i2){
        
        if (i1 != null && i2 != null){
            return i1==i2;
        } else {
            return false;
        }
        

    }
    
    //Debe devolver true si los dos enteros contienen el mismo valor.
    //Si no devuelve false
    //Si se envia null en cualquiera de ellos devuelve false
    
  
    public boolean compararEnteroConLong(Integer i1, Long i2){
	Integer copia=Integer.parseInt(i2.toString());
	if(copia==i1 && copia!=null && i1 != null) return true;
	else return false;
    }    

    //Debe devolver true si el texto que se ha enviado en un n�mero. 
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
    
    //Debe devolver true si los dos n�meros son iguales. 
    //Si no devuelve false
    //Si se envia null en cualquier de ellos devuelve false
    //todas validas
    public boolean comprobarOptionalConInteger(Optional<Integer> valor1, Integer valor2){
       if(valor1==null || valor2==null) 
    	   return false;
       else if(valor1.equals(valor2))
            return true;
       else 
    	   return false;
        
    }    

    //Debe devolver true si los dos n�meros son iguales. 
    //Si no devuelve false
    //Si los dos tienen null devuelve false.
    //todas v�lidas
    public boolean comprobarOptionalesIntegerYDouble(Optional<Integer> valor1, Optional<Double> valor2){
    	int num1 = (valor1.get()).intValue();
        double num2 = (valor2.get()).doubleValue();
        if(num1==num2) 
            return true;
        else 
        	return false;
    }    
}
