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
        return a+b;
    }

	public int maximoValor(int i, int j, int k) {
		int n=Math.max(i,j);
		return Math.max(k,n);
	}

	public int sumarElementos(int[] vector) {
		int suma=0;
		for(int i=0;i<vector.length;i++) {
			suma= vector[i]+suma;
		}
		return suma;
	}

	public Integer contarPares(int[] vector) {
		int numPares=0;
		for(int i=0;i<vector.length;i++) {
			if(vector[i]%2==0) numPares++;
		}
		return numPares;
	}

	public Integer contarVocales(String string) {
		int numVocales=0;
		for(int i=0;i<string.length();i++) {
			if(string.charAt(i)=='a'||string.charAt(i)=='e'||string.charAt(i)=='i'||string.charAt(i)=='o'||string.charAt(i)=='u') {
				numVocales++;
			}
		}
		return numVocales;
	}

	public Integer maximoComunDivisor(int num1, int num2) {
		while(num1 != num2)
            if(num1>num2)
                num1= num1-num2;
            else
                num2= num2 -num1;
		
		return num1;
	}


   

}
