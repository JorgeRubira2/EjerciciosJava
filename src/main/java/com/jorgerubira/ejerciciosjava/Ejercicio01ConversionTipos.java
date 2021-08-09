package com.jorgerubira.ejerciciosjava;

public class Ejercicio01ConversionTipos {

    //Devuelve la suma a+b;
    public int ejemploSuma(int a, int b){
        //throw new RuntimeException("Pendiente de hacer");
        return a+b;
    }
    
    //Convierte de String a int.
    public int textoAEntero(String valor) {
        //throw new RuntimeException("Pendiente de hacer");
        return Integer.parseInt(valor);
    }

    //Convierte de Float a int.
    public int decimalesAEntero(Float valor){
       // throw new RuntimeException("Pendiente de hacer");
       
       return valor.intValue();
    }

    //Convierte de int a Float.
    public Float enteroAFloat(int valor){
        //throw new RuntimeException("Pendiente de hacer");
        
        return new Float(valor);
    }
    //Devuelve el siguiente carácter en el alfabeto (tabla ASCII).
    public char siguienteCaracter(char valor){
        //throw new RuntimeException("Pendiente de hacer");
       return valor+=1;
              
    }

    //Devuelve el código ascii del caracter 
    public int obtenerAscii(char valor){
      
        return  (int) valor;
        //throw new RuntimeException("Pendiente de hacer");
    }

    //Convierte de String a Double. Devuelve null si no se puede convertir
    public Double textoADouble(String valor){
        try{
            Double d= new Double(valor);
            
            return d;
            
        }catch(Exception e){
            return null;
        }
       // throw new RuntimeException("Pendiente de hacer");
    }

}
