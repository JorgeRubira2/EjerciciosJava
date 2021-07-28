/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210728;


interface Operacion{
    int operar(int a, int b);
}

public class ProgramacionFuncionalEjemplo {
    
    public static int sumar(int a, int b){
        return a+b;
    }
    
    public static int[] operarMucho(int []lista, Operacion oper) {
        int[] res=new int[lista.length-1];
        for (int n=0;n<res.length;n++){
            res[n]=oper.operar(lista[n],lista[n+1]);
        }
        return res;
    }
    
    public static void main(String[] args) {
        Operacion suma=(a,b)->a+b;
        Operacion resta=(a,b)->a-b;
        Operacion multiplicacion=(a,b)->a*b;
        
        int []lista={1,2,3,4};
        int []listaMo=operarMucho(lista,suma);        
        int []listaMo2=operarMucho(lista,resta);        
        
        int c1=sumar(2,3);   //imperativa  
        
        int c2=suma.operar(2, 3);
        int c3=resta.operar(2, 3);
        

        
        
    }
}
