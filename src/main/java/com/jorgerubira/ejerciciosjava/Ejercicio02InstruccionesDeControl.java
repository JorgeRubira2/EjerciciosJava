package com.jorgerubira.ejerciciosjava;

public class Ejercicio02InstruccionesDeControl {
    
    //Devolver el número más alto
    public int maximoValor(int a, int b, int c){
        if (a>b && a>c){
            return a;
        }else if (b>c){
            return b;
        }else if (c>b){
            return c;
        }else if (a==b && a>c){
            return a;
        }else if (b==c && b>a){
            return b;
        }else{
            return 0;
        }
    }
    
    //Devolver la suma de todos los elementos del vector
    public int sumarElementos(int[] vector){
        int res = 0;
        for (int i=0;i<vector.length;i++){
            res = res+vector[i];
        }
        return res;
    }    
    
    //Devolver cuantos elementos son pares
    public int contarPares(int[] vector){
        int c= 0;
        for (int i=0;i<vector.length;i++){
            if (vector[i]%2==0){
                c++;
            }
        }
        return c;
    }    
    
    //Devolver el maximo comun divisor.
    //Recibir dos elementos a, b. Restar repetidamente el valor mas pequeño al más grande. Parar cuando son iguales.
    public int maximoComunDivisor(int a, int b){
        int n1 = Math.max(a, b);
        int n2 = Math.min(a, b);
        int res = 0;
        
        while (b != 0){
            res = b;
            b = a % b;
            a = res;
        }
        return res;
    }

    //Contar vocales. Recibe una cadena y cuenta cuantas vocales hay.
    //1. Transformar el String y convertirlo a minúsculas toLowerCase(). 
    //2. Después recorrer los elementos hasta el final y obtener los caracteres con charAt(n). 
    public int contarVocales(String texto){
        String tex=new String();
        tex = texto.toLowerCase();
        /*// Con expresion regular
        int total = tex.replaceAll("[^aeiou]","").length();
        */
        int total = 0;
        for (int i=0;i<tex.length();i++){
            char c= tex.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ){
                total++;
            }
        }
        return total;
    }
    
}
