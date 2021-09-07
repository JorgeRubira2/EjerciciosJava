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
        if (a >= b) {
            if (a >= c) {
                return a;
            } else {
                return c;
            }
        } else {
            if (b >= c) {
                return b;
            } else {
                return c;
            }
        }

    }

    //Devolver la suma de todos los elementos del vector
    public int sumarElementos(int[] vector) {
        int sum = 0;
        for (int a : vector) {
            sum += a;
        }
        return sum;
    }

    //Devolver cuantos elementos son pares
    public int contarPares(int[] vector) {
        int sum = 0;
        for (int a : vector) {
            if (a % 2 == 0) {
                sum++;
            }
        }
        return sum;
    }

    //Devolver el maximo comun divisor.
    //Recibir dos elementos a, b. Restar repetidamente el valor mas pequeño al más grande. Parar cuando son iguales.
    public int maximoComunDivisor(int a, int b) {
        int temporal;
        while (b != 0) {
            temporal = b;
            b = a % b;
            a = temporal;
        }
        return a;
    }

    //Contar vocales. Recibe una cadena y cuenta cuantas vocales hay.
    //1. Transformar el String y convertirlo a minúsculas toLowerCase(). 
    //2. Después recorrer los elementos hasta el final y obtener los caracteres con charAt(n). 
    public int contarVocales(String texto) {
        int contador = 0;
        texto = texto.toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u");
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == 'a' || texto.charAt(i) == 'e' || texto.charAt(i) == 'i' || texto.charAt(i) == 'o' || texto.charAt(i) == 'u') {
                contador++;
            }
        }
        return contador;
    }

}
