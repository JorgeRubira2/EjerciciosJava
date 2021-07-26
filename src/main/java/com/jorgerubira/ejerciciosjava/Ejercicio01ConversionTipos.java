package com.jorgerubira.ejerciciosjava;

public class Ejercicio01ConversionTipos {

    //Devuelve la suma a+b;
    public int ejemploSuma(int a, int b){
        return a+b;
    }
    
    //Convierte de String a int.
    public int textoAEntero(String valor) {
        int numEntero = Integer.parseInt(valor);
        return numEntero;
    }

    //Convierte de Float a int.
    public int decimalesAEntero(Float valor){
        int numEntero = valor.intValue();
        return numEntero;
    }

    //Convierte de int a Float.
    public Float enteroAFloat(int valor){
        Float numFloat = (float) valor;
        return numFloat;
    }

    //Devuelve el siguiente carácter en el alfabeto (tabla ASCII).
    public char siguienteCaracter(char valor){
        int ascii = (int) valor;
        ascii++;
        return (char) ascii;
    }

    //Devuelve el código ascii del caracter 
    public int obtenerAscii(char valor){
        int ascii = (int) valor;
        return ascii;
    }

    //Convierte de String a Double. Devuelve null si no se puede convertir
    public Double textoADouble(String valor){
        try{
            double texto = Double.parseDouble(valor);
            return texto;
        }catch(NumberFormatException e){
            return null;
        }
        //throw new RuntimeException("Pendiente de hacer");
    }

}
