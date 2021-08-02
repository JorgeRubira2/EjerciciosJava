package main.java.com.jorgerubira.ejerciciosjava;
public class Ejercicio01ConversionTipos {

    //Devuelve la suma a+b;
    public int ejemploSuma(int a, int b){
       return a+b;
    }
    
    //Convierte de String a int.
    public int textoAEntero(String valor) {
        return Integer.parseInt(valor);
    }

    //Convierte de Float a int.
    public int decimalesAEntero(Float valor){
	
    	float a=Math.round(valor.valueOf(valor).floatValue());  
    	   int b=(int)a;
    	   return b;
    }

    //Convierte de int a Float.
    public Float enteroAFloat(int valor){
       Float f= (float) valor;
       return f;
    }

    //Devuelve el siguiente carácter en el alfabeto (tabla ASCII).
    public char siguienteCaracter(char valor){
        int n = valor+1;
        return (char)n;
    }

    //Devuelve el código ascii del caracter 
    public int obtenerAscii(char valor){
        int n = valor;
        return n;
    }

    //Convierte de String a Double. Devuelve null si no se puede convertir
    public Double textoADouble(String valor){
        try{
            return Double.parseDouble(valor);
        }catch(Exception e){
            return null;
        }
      
    }

}
