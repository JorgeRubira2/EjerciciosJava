package com.jorgerubira.ejerciciosjava;

public class Ejercicio01ConversionTipos {

    //Devuelve la suma a+b;
    public int ejemploSuma(int a, int b) {
        return a + b;
    }

    //Convierte de String a int.
    public int textoAEntero(String valor) {
        return Integer.parseInt(valor);
    }

    //Convierte de Float a int.
    public int decimalesAEntero(Float valor) {
        return valor.intValue();
    }

    //Convierte de int a Float.
    public Float enteroAFloat(int valor) {
        Float x = (float) valor;
        return x;
    }

    //Devuelve el siguiente carácter en el alfabeto (tabla ASCII).
    public char siguienteCaracter(char valor) {
        int bin = ++valor;
        return (char) bin;
    }

    //Devuelve el código ascii del caracter 
    public int obtenerAscii(char valor) {
        return (int) valor;
    }

    //Convierte de String a Double. Devuelve null si no se puede convertir
    public Double textoADouble(String valor) {
        char[] vector = valor.toCharArray();
        Double numero = null;
        for (int i = 0; i <= vector.length-1; i++) {
           int valorAscii = vector[i];
           if(valorAscii >= 48 && valorAscii <= 57){
               numero = Double.parseDouble(valor); 
           } else {
               numero = null;
           }
        }

        return numero; 
    }

}
