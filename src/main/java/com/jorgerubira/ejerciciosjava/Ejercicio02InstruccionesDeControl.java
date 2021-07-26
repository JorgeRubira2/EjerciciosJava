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
    public int maximoValor(int a, int b, int c){
        if(a<b){
            if(b<c){
                return c;
            } else {
                return b;
            }
        } else {
            return a;
        }
    }
    
    //Devolver la suma de todos los elementos del vector
    public int sumarElementos(int[] vector){
        int total = 0;
        for(int valor:vector){
            total+=valor;
        }
        return total;
    }    
    
    //Devolver cuantos elementos son pares
    public int contarPares(int[] vector){
        int contador = 0;
        for(int valor:vector){
            if(valor%2==0){
                contador++;
            }
        }
        return contador;
    }    
    
    //Devolver el maximo comun divisor.
    //Recibir dos elementos a, b. Restar repetidamente el valor mas pequeño al más grande. Parar cuando son iguales.
    public int maximoComunDivisor(int a, int b){
        int mcd;
        do{
            if (a < b) {
                mcd = b - a;
                b-=a;
            } else{
                mcd = a - b;
                a-=b;
            }
        } while (a!=b);
        return mcd;
    }

    //Contar vocales. Recibe una cadena y cuenta cuantas vocales hay.
    //1. Transformar el String y convertirlo a minúsculas toLowerCase(). 
    //2. Después recorrer los elementos hasta el final y obtener los caracteres con charAt(n). 
    public int contarVocales(String texto){
        throw new RuntimeException("Pendiente de hacer");
    }
    
}
