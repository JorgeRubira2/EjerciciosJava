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
        if (a>=b && a>=c){
            return a;
        }else if (b>=a && b>=c){
            return b;
    
        }else if (c>=a && c>=b){
            return c;
        }else{
            return 0;
        }
                
        
       
    }
    
    //Devolver la suma de todos los elementos del vector
    public int sumarElementos(int[] vector){
        int suma=0;
        for (int val:vector){
            suma+=val;
        }

        return suma;
    }    
    
    //Devolver cuantos elementos son pares
    public int contarPares(int[] vector){
            
        int contador=0;
        for (int val:vector){
        if (val%2 == 0){
            contador++;
        }
}
        return contador;
    }    
    
    //Devolver el maximo comun divisor.
    //Recibir dos elementos a, b. Restar repetidamente el valor mas pequeño al más grande. Parar cuando son iguales.
    public int maximoComunDivisor(int a, int b){
        
        throw new RuntimeException("Pendiente de hacer");
    }

    //Contar vocales. Recibe una cadena y cuenta cuantas vocales hay.
    //1. Transformar el String y convertirlo a minúsculas toLowerCase(). 
    //2. Después recorrer los elementos hasta el final y obtener los caracteres con charAt(n). 
    public int contarVocales(String texto){
        throw new RuntimeException("Pendiente de hacer");
    }
    
}
