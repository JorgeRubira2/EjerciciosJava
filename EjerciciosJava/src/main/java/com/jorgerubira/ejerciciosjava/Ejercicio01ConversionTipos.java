package EjerciciosJava.src.main.java.com.jorgerubira.ejerciciosjava;

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
    	 return Integer.parseInt(valor);
    }

    //Convierte de int a Float.
    public Float enteroAFloat(int valor){
    	return Float.parseFloat(valor.toString()); 
    	
    }

    //Devuelve el siguiente carácter en el alfabeto (tabla ASCII).
    public char siguienteCaracter(char valor){
        char c = valor++;
        return c;
    }

    //Devuelve el código ascii del caracter 
    public int obtenerAscii(char valor){
        int c = valor;
        return c;
    }

    //Convierte de String a Double. Devuelve null si no se puede convertir
    public Double textoADouble(String valor){
        try{
            //Algoritmo 
        }catch(Exception e){
            return null;
        }
        throw new RuntimeException("Pendiente de hacer");
    }

}
