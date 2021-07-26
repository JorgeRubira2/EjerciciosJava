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
        
        return (a>b)?((a>c)?a:c):((b>c)?b:c) ;
    }
    
    //Devolver la suma de todos los elementos del vector
    public int sumarElementos(int[] vector){
        
        int i = 0;
        for ( int j : vector){
            i+=j;
        }
        return i;
        
    }    
    
    //Devolver cuantos elementos son pares
    public int contarPares(int[] vector){
        int i = 0;
        for ( int j : vector){
            if (j%2==0){
                i+=1;
            }
        }
        return i;
    }    
    
    //Devolver el maximo comun divisor.
    //Recibir dos elementos a, b. Restar repetidamente el valor mas pequeño al más grande. Parar cuando son iguales.
    public int maximoComunDivisor(int a, int b){
       int max = a;
       int min = b;
       int aux = 0;
       if (b>a) {
           max = b;
           min = a;
       } 
       while (max > min)
       {
            max-=min;
            if (min>max) {
               aux = max;
               max = min;
               min = aux;
           } 
       }
       return max;
    }

    //Contar vocales. Recibe una cadena y cuenta cuantas vocales hay.
    //1. Transformar el String y convertirlo a minúsculas toLowerCase(). 
    //2. Después recorrer los elementos hasta el final y obtener los caracteres con charAt(n). 
    public int contarVocales(String texto){
        texto = texto.toLowerCase();
        int contador = 0;
        for (int i = 0; i< texto.length(); i++ ){
            if (texto.charAt(i) == 'a' || texto.charAt(i) == 'e' || texto.charAt(i) == 'i' || texto.charAt(i) == 'o' || texto.charAt(i) == 'u')
            {
                contador+=1;
            }
        }
        return contador;
    }
    
}
