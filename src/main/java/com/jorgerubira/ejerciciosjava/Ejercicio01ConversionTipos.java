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
        float num = valor;
        int entero = (int) num;
        return entero;
    }

    //Convierte de int a Float.
    public Float enteroAFloat(int valor) {
        return (float) valor;
    }

    //Devuelve el siguiente carácter en el alfabeto (tabla ASCII).
    public char siguienteCaracter(char valor) {
        int v = valor + 1;
        char va  = (char) v;
        return va;
    }

    //Devuelve el código ascii del caracter 
    public int obtenerAscii(char valor) {
        return (int) valor;
    }

    //Convierte de String a Double. Devuelve null si no se puede convertir
    public Double textoADouble(String valor) {

        Double numero;
        try {
            numero = Double.parseDouble(valor);

        } catch (Exception e) {
            throw e;
        }
        return numero;

    }

}
