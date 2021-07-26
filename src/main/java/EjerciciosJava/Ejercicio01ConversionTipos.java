package EjerciciosJava;

public class Ejercicio01ConversionTipos {

    //Devuelve la suma a+b;
    public int ejemploSuma(int a, int b) {
        return a + b;
    }

    //Convierte de String a int.
    public int textoAEntero(String valor) {
        return Integer.parseInt(valor);
    }

    //Convierte de Float a int.
    public int decimalesAEntero(Float valor) {
        return valor.intValue();
    }

    //Convierte de int a Float.
    public Float enteroAFloat(int valor) {
        Float x = (float) valor;
        return x;
    }

    //Devuelve el siguiente carácter en el alfabeto (tabla ASCII).
    public char siguienteCaracter(char valor) {
        return (char) ++valor;
    }

    //Devuelve el código ascii del caracter 
    public int obtenerAscii(char valor) {
        return (int) valor;
    }

    //Convierte de String a Double. Devuelve null si no se puede convertir
    public Double textoADouble(String valor) {
        Double a;
        try{
        a = Double.parseDouble(valor);
        } catch (NumberFormatException e){
        return null;
        }
        return a;
    }

}