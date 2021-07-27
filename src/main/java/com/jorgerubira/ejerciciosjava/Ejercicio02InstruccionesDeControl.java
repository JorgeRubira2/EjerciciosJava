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
        if (a >= b && a >= c) {
            return a;
        } else if (b >= a && b >= c) {
            return b;
        } else {
            return c;
        }
    }

    //Devolver la suma de todos los elementos del vector
    public int sumarElementos(int[] vector) {
        int result = 0;
        for (int elemento : vector) {
            result += elemento;
        }
        return result;
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
    }

    //Devolver el maximo comun divisor.
    //Recibir dos elementos a, b. Restar repetidamente el valor mas pequeño al más grande. Parar cuando son iguales.
    public int maximoComunDivisor(int a, int b) {
        while (a != b) {
            if (a > b) {
                a -= b;
            } else {
                b -= a;
            }
        }
        return a;
    }

    //Contar vocales. Recibe una cadena y cuenta cuantas vocales hay.
    //1. Transformar el String y convertirlo a minúsculas toLowerCase(). 
    //2. Después recorrer los elementos hasta el final y obtener los caracteres con charAt(n). 
    public int contarVocales(String texto) {
        String a = texto.toLowerCase();
        int contar = 0;
        char[] vocales = {'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < vocales.length; j++) {
                if (a.charAt(i) == vocales[j]) {
                    contar++;
                }
            }
        }
        return contar;

    }

}
