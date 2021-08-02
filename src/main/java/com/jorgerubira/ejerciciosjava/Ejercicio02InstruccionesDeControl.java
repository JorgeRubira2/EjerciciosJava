/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosjava;

/**
 *
 * @author PC
 */
public class Ejercicio02InstruccionesDeControl {

    //Devolver el número más alto
    public int maximoValor(int a, int b, int c) {

        if (a > b && a > c) {
            return a;
        } else if (b > c && b > a) {
            return b;
        } else if (c > a && c > b) {
            return c;
        } else if (a < b) {

            return b;
        } else if (a < c) {
            return c;
        } else if (b < c) {
            return c;
        } else if (c < b) {
            return b;
        } else {
            return 0;
        }

        //throw new RuntimeException("Pendiente de hacer");
    }

    //Devolver la suma de todos los elementos del vector
    public int sumarElementos(int[] vector) {
        int suma = 0;
        for (int i = 0; i < vector.length; i++) {

            suma = suma + vector[i];
        }
        return suma;

        //  throw new RuntimeException("Pendiente de hacer");
    }

    //Devolver cuantos elementos son pares
    public int contarPares(int[] vector) {

        int pares = 0;

        for (int i = 0; i < vector.length; i++) {
            if (vector[i] % 2 == 0) {
                pares++;
            }

        }
        return pares;
        //throw new RuntimeException("Pendiente de hacer");
    }

    //Devolver el maximo comun divisor.
    //Recibir dos elementos a, b. Restar repetidamente el valor mas pequeño al más grande. Parar cuando son iguales.
    public int maximoComunDivisor(int a, int b) {
        int aux;

        while (b != 0) {
            aux = b;
            b = a % b;
            a = aux;
        }
        return a;
        //throw new RuntimeException("Pendiente de hacer");
    }

    //Contar vocales. Recibe una cadena y cuenta cuantas vocales hay.
    //1. Transformar el String y convertirlo a minúsculas toLowerCase(). 
    //2. Después recorrer los elementos hasta el final y obtener los caracteres con charAt(n). 
    public int contarVocales(String texto) {

        texto = texto.toLowerCase();
        int numVocales = 0;
        char vocal;

        for (int i = 0; i < texto.length(); i++) {
            vocal = texto.charAt(i);

            if (vocal == 'a' || vocal == 'e' || vocal == 'i' || vocal == 'o' || vocal == 'u') {
                numVocales++;

            }

        }
        return numVocales;
        //throw new RuntimeException("Pendiente de hacer");
    }

}
