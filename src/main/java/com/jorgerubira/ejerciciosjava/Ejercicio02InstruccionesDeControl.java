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

        } else if (b > c) {
            return b;
        } else {
            return c;
        }

    }

    //Devolver la suma de todos los elementos del vector
    public int sumarElementos(int[] vector) {
        int suma = 0;
        for (int i = 0; i < vector.length; i++) {
            suma += vector[i];
        }
        return suma;
    }

    //Devolver cuantos elementos son pares
    public int contarPares(int[] vector) {
        int par = 0;
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] % 2 == 0) {
                par++;
            }
        }
        return par;
    }

    //Devolver el maximo comun divisor.
    //Recibir dos elementos a, b. Restar repetidamente el valor mas pequeño al más grande. Parar cuando son iguales.
    public int maximoComunDivisor(int a, int b) {
        throw new RuntimeException("Pendiente de hacer");
    }

    //Contar vocales. Recibe una cadena y cuenta cuantas vocales hay.
    //1. Transformar el String y convertirlo a minúsculas toLowerCase(). 
    //2. Después recorrer los elementos hasta el final y obtener los caracteres con charAt(n). 
    public int contarVocales(String texto) {
        String frase = texto.toLowerCase();
        int contador = 0;

        for (int i = 0; i < frase.length(); i++) {
            if (frase.charAt(i) == 'a' || frase.charAt(i) == 'e' || frase.charAt(i) == 'i' || frase.charAt(i) == 'o' || frase.charAt(i) == 'u') {
                contador++;
            }

        }
        return contador;
    }

}
