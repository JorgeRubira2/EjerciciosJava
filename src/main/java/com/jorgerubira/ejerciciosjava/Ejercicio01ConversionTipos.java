package com.jorgerubira.ejerciciosjava;

public class Ejercicio01ConversionTipos {

    public static final String MARRON = "marron";

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
        return (float) valor;
    }

    //Devuelve el siguiente carácter en el alfabeto (tabla ASCII).
    public char siguienteCaracter(char valor) {
        valor++;
        return valor;
    }

    //Devuelve el código ascii del caracter 
    public int obtenerAscii(char valor) {
        return (int) valor;
    }

    //Convierte de String a Double. Devuelve null si no se puede convertir
    public Double textoADouble(String valor) {
        try {

            return Double.parseDouble(valor);

        } catch (NumberFormatException nfe) {
            return null;
        }
    }
}
