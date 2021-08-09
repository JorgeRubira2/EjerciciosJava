package com.jorgerubira.ejerciciosjava;

public class Ejercicio01ConversionTipos {

    //Devuelve la suma a+b;
    public int ejemploSuma(int a, int b){
<<<<<<< HEAD
        //throw new RuntimeException("Pendiente de hacer");
        return a+b;
=======
       
		return a+b;
>>>>>>> origin/master
    }
    
    //Convierte de String a int.
    public int textoAEntero(String valor) {
<<<<<<< HEAD
        //throw new RuntimeException("Pendiente de hacer");
        return Integer.parseInt(valor);
=======
       
    	return  Integer.parseInt(valor);
		
>>>>>>> origin/master
    }

    //Convierte de Float a int.
<<<<<<< HEAD
    public int decimalesAEntero(Float valor){
       // throw new RuntimeException("Pendiente de hacer");
       
       return valor.intValue();
=======
    public Float decimalesAEntero(Float valor){
    	
		return (float) valor.intValue();
    	
>>>>>>> origin/master
    }

    //Convierte de int a Float.
    public Float enteroAFloat(int valor){
<<<<<<< HEAD
        //throw new RuntimeException("Pendiente de hacer");
        
        return new Float(valor);
=======
    	return (float)valor ;
>>>>>>> origin/master
    }
    //Devuelve el siguiente carácter en el alfabeto (tabla ASCII).
    public char siguienteCaracter(char valor){
<<<<<<< HEAD
        //throw new RuntimeException("Pendiente de hacer");
       return valor+=1;
              
=======
    	return (char)(valor+1);
>>>>>>> origin/master
    }

    //Devuelve el código ascii del caracter 
    public int obtenerAscii(char valor){
<<<<<<< HEAD
      
        return  (int) valor;
        //throw new RuntimeException("Pendiente de hacer");
=======
    	return (int)valor;
>>>>>>> origin/master
    }

    //Convierte de String a Double. Devuelve null si no se puede convertir
    public Double textoADouble(String valor){
<<<<<<< HEAD
        try{
            Double d= new Double(valor);
            
            return d;
            
        }catch(Exception e){
            return null;
        }
       // throw new RuntimeException("Pendiente de hacer");
=======

    	try {
    		return Double.parseDouble(valor);
		} catch (Exception e) {
			return null;
		}
        

>>>>>>> origin/master
    }

}
