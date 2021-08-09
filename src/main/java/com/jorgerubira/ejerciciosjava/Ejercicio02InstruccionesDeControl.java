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
        int n=Math.max(a,b);
	return Math.max(c,n);
    }
    
    //Devolver la suma de todos los elementos del vector
    public int sumarElementos(int[] vector){
        int suma=0;
		for(int i=0;i<vector.length;i++) {
			suma= vector[i]+suma;
		}
		return suma;
    }    
    
    //Devolver cuantos elementos son pares
    public int contarPares(int[] vector){
        int numPares=0;
		for(int i=0;i<vector.length;i++) {
			if(vector[i]%2==0) numPares++;
		}
		return numPares;
    }    
    
    //Devolver el maximo comun divisor.
    //Recibir dos elementos a, b. Restar repetidamente el valor mas pequeño al más grande. Parar cuando son iguales.
    public int maximoComunDivisor(int num1, int num2){
      while(num1 != num2)
            if(num1>num2)
                num1= num1-num2;
            else
                num2= num2 -num1;
		
		return num1;
    }

    //Contar vocales. Recibe una cadena y cuenta cuantas vocales hay.
    //1. Transformar el String y convertirlo a minúsculas toLowerCase(). 
    //2. Después recorrer los elementos hasta el final y obtener los caracteres con charAt(n). 
    public int contarVocales(String texto){
        int numVocales=0;
		for(int i=0;i<texto.length();i++) {
			if(texto.charAt(i)=='a'||texto.charAt(i)=='e'||texto.charAt(i)=='i'||texto.charAt(i)=='o'||texto.charAt(i)=='u'
                           ||texto.charAt(i)=='A'||texto.charAt(i)=='E'||texto.charAt(i)=='I'||texto.charAt(i)=='O'||texto.charAt(i)=='U') {
				numVocales++;
			}
		}
		return numVocales;
    }
    
}
