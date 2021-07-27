/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.jorgerubira.ejerciciosjava;

/**
 *
 * @author PC
 */
public class Ejercicio02InstruccionesDeControl {
    
	public Ejercicio02InstruccionesDeControl() {
    }
    
    public int suma(int a,int b){
        int c=a+b;
        return c;
    }

	public int maximoValor(int i, int j, int k) {
		return Math.max(i,Math.max(i, k));
	}

	public int sumarElementos(int[] vector) {
		int suma=0;
        for (int i = 0; i <= vector.length; i++) {
            suma+=vector[i];
        }
        return suma;
	}

	public Integer contarPares(int[] vector) {
		int pares = 0;
		for (int i = 0; i <= vector.length; i++) {
			if(vector[i]%2==0) pares++;
		}
		return pares;
	}

	public Integer contarVocales(String string) {
		int vocales = 0;
		for(int i=0;i<string.length();i++) {
			if(string.charAt(i)=='a'||string.charAt(i)=='e'||string.charAt(i)=='i'||string.charAt(i)=='o'||string.charAt(i)=='u') {
				vocales++;
			}
		}
		return vocales;
	}

	public Integer maximoComunDivisor(int a, int b) {
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


   

}
