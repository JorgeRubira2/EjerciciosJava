/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210726;

import java.util.List;

/**
 *
 * @author PC
 */
public class VectoresPrimitivos {
 
    
    public void metodo1(int[] a){
        
    }
    
    public static void main(String[] args) {
        int notaPepe=5;
        int notaJuan=8;
        int notaFran=9;
        
        int vectores[]=new int[5];
        int[] vectores2=new int[5]; //0 0 0 0 0
        int[] vectores3={3,4,2};    //3 4 2
        
        int[] notas={4,6,5};    //Tres. Cambiar de tamaño
        
        int[] not={4,6,5,5,7,5,0,0,0};
        int cuantas=4; // ArrayList
      
        //contar elementos,
        //sumar elementos,
        int acum=0;
        int contador=0;
        for (int nota:notas){
            if (nota>=5){
                acum+=nota;   
                contador++;
            }
        }
        //Lambdas, Streams
        
        //System.out.print(contador);
        //3    Pulgar
        //2    Carita
        
        int[][] matriz={
            {1,2,3},
            {4,5,6}
        };
        
        matriz[0]=matriz[1];
        matriz[0][0]++;
        System.out.print(matriz[1][0]);
        
        //5 pulgar 
        //4 carita
        //2 fiesta
        
        
        
        //int[][][] cubo=new int[5][2][3]; 
        
        
        
        
        
        /*
        
        for(int n=0;n<notas.length;n++){
            notas[n]++;
        }
        //Leer la información. Modificar la información
        for(int n=0;n<notas.length;n++){
            System.out.print(notas[n] + " ");
        }
        //Leer la información
        for(int nota:notas){
            System.out.print(nota + " ");
        }*/
        
        

        
        
        
        
        
        
    }
}
