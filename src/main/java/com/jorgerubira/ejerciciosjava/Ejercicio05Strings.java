/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosjava;

/**
 *
 * @author PC
 */
public class Ejercicio05Strings {
    
    /**
     * Recibe una palabra y devuelve esta en minusculas
     * 
     */
    public String convertirAMinusculas(String palabra1){
        throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Recibe una frase y devuelve la segunda palabra.
     * Pista: Utilizar split para trocear la frase.
     */
    public String segundaPalabra(String palabra1){
        throw new RuntimeException("Pendiente de hacer");
    }    

    /**
     * Buscar en una frase una palabra concreta. Debe ser insensible a mayusculas y minusculas.
     * Devuelve -1 si no lo encuentra.
     * Ejemplo: Si tenemos "Hola Pepe" y buscamos "pepe" debe devolver 5
     * Tener en cuenta que las posiciones empiezan desde 0.
     */
    public String buscar(String frase, String palabra){
        throw new RuntimeException("Pendiente de hacer");
    }    

    /**
     * Devuelve si las palabras son la misma sin contar las tildes o las mayusculas.
     * Ejemplo. "Balón" y "balon" deberían ser la misma palabra.
     * Pista. Para quitar las tildes utilizar replaceAll
     */
    public boolean equalsInsensibleMayusculasYTildes(String palabra1, String palabra2){
        throw new RuntimeException("Pendiente de hacer");
    }
    
    /**
     * Convertir nombre sql to CamelCase. Debe convertir una frase de nomenclatura
     * Ejemplo. Debe convertir "minerales_importados" a "MineralesImportados"
     * Pista. Primero trocear la frase con split y cada elemento obtener el primer caracter o el resto con substring
     */
    public String convertirCamelCase(String palabra1){
        throw new RuntimeException("Pendiente de hacer");
    }
    
    /**
     * Contar palabras. Toma un texto que puede tener comas y puntos y dice cuantas palabras hay.
     * Ejemplo. "Hola.Este es un relato  con texto mas complicado, hasta el momento, que puedes encontrar." -> 15 palabras
     * Pista. Se recomienda convertir los puntos comas y dobles espacios a un espacio. Luego trocear con un split y contar cuantas palabras salen.
     */
    public int contarPalabras(String texto){
        throw new RuntimeException("Pendiente de hacer");
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
    

}
