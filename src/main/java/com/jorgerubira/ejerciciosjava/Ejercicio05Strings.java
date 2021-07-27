/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosjava;

import java.text.Collator;
import java.text.Normalizer;
import java.util.Locale;

/**
 *
 * @author PC
 */
public class Ejercicio05Strings {
    
    /**
     * Recibe una palabra y devuelve esta en minusculas
     */
    public String convertirAMinusculas(String palabra1){
        return palabra1.toLowerCase();
    }

    /**
     * Recibe una frase y devuelve la segunda palabra.
     * Pista: Utilizar split para trocear la frase.
     */
    public String segundaPalabra(String palabra1){
        String[] res = palabra1.split(" ");
        return res[1];
    }    

    /**
     * Buscar en una frase una palabra concreta. Debe ser insensible a mayusculas y minusculas.
     * Devuelve -1 si no lo encuentra.
     * Ejemplo: Si tenemos "Hola Pepe" y buscamos "pepe" debe devolver 5
     * Tener en cuenta que las posiciones empiezan desde 0.
     */
    public int buscar(String frase, String palabra){
        Integer res = frase.toLowerCase().indexOf(palabra);
        return res;
    }    

    /**
     * Devuelve si las palabras son la misma sin contar las tildes o las mayusculas.
     * Ejemplo. "Balón" y "balon" deberían ser la misma palabra.
     * Pista. Para quitar las tildes utilizar replaceAll
     */
    public boolean equalsInsensibleMayusculasYTildes(String palabra1, String palabra2){
        Collator c = Collator.getInstance(new Locale("es"));
        c.setStrength(Collator.PRIMARY);
        if (c.equals(palabra1,palabra2)){
            return true;
        }
        return false;
    }
    
    /**
     * Convertir nombre sql to CamelCase. Debe convertir una frase de nomenclatura
     * Ejemplo. Debe convertir "minerales_importados" a "MineralesImportados"
     * Pista. Primero trocear la frase con split y cada elemento obtener el primer caracter o el resto con substring
     */
    public String convertirCamelCase(String palabra1){
        String[] texto2 = palabra1.split("_");
        String res = "";
        for (String pal:texto2){
            res += pal.substring(0, 1).toUpperCase() + pal.substring(1).toLowerCase();
        }
        return res;
    }
    
    /**
     * Contar palabras. Toma un texto que puede tener comas y puntos y dice cuantas palabras hay.
     * Ejemplo. "Hola.Este es un relato  con texto mas complicado, hasta el momento, que puedes encontrar." -> 15 palabras
     * Pista. Se recomienda convertir los puntos comas y dobles espacios a un espacio. Luego trocear con un split y contar cuantas palabras salen.
     */
    public int contarPalabras(String texto){
        texto = texto.replaceAll("\\,|\\.\\s{2,}|\\.|\\s{2,}", " ");
        String[] texto2 = texto.split(" ");
        return texto2.length;
    }

    /**
     * Cuenta cuantas líneas hay en el texto. Se considera una línea si tiene algún carácter. El salto de línea se realiza con el carácter \n o, en algunos textos, con \r\n.
     */
    public int contarLineas(String texto){
        throw new RuntimeException("Pendiente de hacer");
    }
    
    /**
     * Cuenta cuantas vocales hay en un texto (con tildes incluidas á).
     */
    public int contarVocales(String texto){
        throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Eliminación de espacios a izquierda y derecha
     */
    public String quitarEspacios(String frase){
        return frase.replaceAll("^\\s*|\\s*$","");
    }

}
