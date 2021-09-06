package com.jorgerubira.ejerciciosjava;

import com.jorgerubira.ejerciciosjava.interfaces.IComparadorPersonaCompra;
import com.jorgerubira.ejerciciosjava.pojo.Compra;
import com.jorgerubira.ejerciciosjava.pojo.Persona;
import java.util.Comparator;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Ejercicio05Strings {

    /**
     * Recibe una palabra y devuelve esta en minusculas
     */
    public String convertirAMinusculas(String palabra1) {
        return palabra1.toLowerCase();
    }

    /**
     * Recibe una frase y devuelve la segunda palabra. Pista: Utilizar split
     * para trocear la frase.
     */
    public String segundaPalabra(String palabra1) {
        return palabra1.split(" ")[1];
    }

    /**
     * Buscar en una frase una palabra concreta. Debe ser insensible a
     * mayusculas y minusculas. Devuelve -1 si no lo encuentra. Ejemplo: Si
     * tenemos "Hola Pepe" y buscamos "pepe" debe devolver 5 Tener en cuenta que
     * las posiciones empiezan desde 0.
     */
    public int buscar(String frase, String palabra) {
        return frase.toUpperCase().indexOf(palabra.toUpperCase());
    }

    /**
     * Devuelve si las palabras son la misma sin contar las tildes o las
     * mayusculas. Ejemplo. "Balón" y "balon" deberían ser la misma palabra.
     * Pista. Para quitar las tildes utilizar replaceAll
     */
    public boolean equalsInsensibleMayusculasYTildes(String palabra1, String palabra2) {
        palabra1 = palabra1.replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u");
        palabra2 = palabra2.replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u");
        return palabra1.equalsIgnoreCase(palabra2);
    }

    /**
     * Convertir nombre sql to CamelCase. Debe convertir una frase de
     * nomenclatura Ejemplo. Debe convertir "minerales_importados" a
     * "MineralesImportados" Pista. Primero trocear la frase con split y cada
     * elemento obtener el primer caracter o el resto con substring
     */
    public String convertirCamelCase(String palabra1) {
        String[] aux = palabra1.split("_");
        String resultado="";
        for(var i=0;i<aux.length;i++){
            aux[i]=aux[i].substring(0,1).toUpperCase()+aux[i].substring(1).toLowerCase();
            resultado = resultado + aux[i];
        }
        return resultado;
    }

    /**
     * Contar palabras. Toma un texto que puede tener comas y puntos y dice
     * cuantas palabras hay. Ejemplo. "Hola.Este es un relato con texto mas
     * complicado, hasta el momento, que puedes encontrar." -> 15 palabras
     * Pista. Se recomienda convertir los puntos comas y dobles espacios a un
     * espacio. Luego trocear con un split y contar cuantas palabras salen.
     */
    public int contarPalabras(String texto) {
        texto = texto.replaceAll("\\.|;|:| +|,", " ");
        String[] aux= texto.split(" ");
        int contador=0;
        for(int i = 0; i<aux.length;i++){
            if(aux[i].equals(""))
                contador++;
        }
        return aux.length-contador;
    }

    /**
     * Cuenta cuantas líneas hay en el texto. Se considera una línea si tiene
     * algún carácter. El salto de línea se realiza con el carácter \n o, en
     * algunos textos, con \r\n.
     */
    public int contarLineas(String texto) {
        int contador=0;
        if(texto.split("\r\n").length!=1){
            
            contador=texto.split("\r\n").length-1;
            texto = texto.replace("\r\n", "");
        }
        contador=contador + texto.split("\n").length-1;
        return contador;
    }

    /**
     * Cuenta cuantas vocales hay en un texto (con tildes incluidas á).
     */
    public int contarVocales(String texto) {
        int contador=0;
        texto = texto.toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u");
        for(int i = 0; i<texto.length();i++){
            if(texto.charAt(i)=='a'||texto.charAt(i)=='e'||texto.charAt(i)=='i'||texto.charAt(i)=='o'||texto.charAt(i)=='u')
                contador++;
        }
        return contador;
    }

    /**
     * Eliminación de espacios a izquierda y derecha
     */
    public String quitarEspacios(String frase) {
        while(frase.charAt(0)==' '){
            frase = frase.substring(1);
        }
        while(frase.charAt(frase.length()-1)==' '){
            frase = frase.substring(0,frase.length()-1);
        }
        return frase;
    }

}
