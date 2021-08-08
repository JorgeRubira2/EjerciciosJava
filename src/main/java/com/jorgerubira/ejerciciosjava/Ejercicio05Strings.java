/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosjava;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        return palabra1.split(" ")[1];
    }    

    /**
     * Buscar en una frase una palabra concreta. Debe ser insensible a mayusculas y minusculas.
     * Devuelve -1 si no lo encuentra.
     * Ejemplo: Si tenemos "Hola Pepe" y buscamos "pepe" debe devolver 5
     * Tener en cuenta que las posiciones empiezan desde 0.
     */
    public int buscar(String frase, String palabra){
        return frase.toLowerCase().indexOf(palabra.toLowerCase());
    }    

    /**
     * Devuelve si las palabras son la misma sin contar las tildes o las mayusculas.
     * Ejemplo. "Balón" y "balon" deberían ser la misma palabra.
     * Pista. Para quitar las tildes utilizar replaceAll
     */
     private String insensible (String palabra1){
        return palabra1.toLowerCase().replaceAll("á","a").replaceAll("é","e").replaceAll("í","i").replaceAll("ó","o").replaceAll("ú","u");
    }
    public boolean equalsInsensibleMayusculasYTildes(String palabra1, String palabra2){
        Ejercicio05Strings ejer05 = new Ejercicio05Strings();
        
        palabra1 = ejer05.insensible(palabra1);
        palabra2 = ejer05.insensible(palabra2);
        return palabra1.equals(palabra2);
    }
    
    /**
     * Convertir nombre sql to CamelCase. Debe convertir una frase de nomenclatura
     * Ejemplo. Debe convertir "minerales_importados" a "MineralesImportados"
     * Pista. Primero trocear la frase con split y cada elemento obtener el primer caracter o el resto con substring
     */
    public String convertirCamelCase(String palabra1){
        StringBuffer strBuff = new StringBuffer();
        String[] separado = palabra1.split("_");
        for (int i = 0; i < separado.length ; i++){
            separado[i] = separado[i].substring(0,1).toUpperCase() + separado[i].substring(1,separado[i].length()).toLowerCase();
            strBuff.append(separado[i]);
        }
        return strBuff.toString();
    }
    
    /**
     * Contar palabras. Toma un texto que puede tener comas y puntos y dice cuantas palabras hay.
     * Ejemplo. "Hola.Este es un relato  con texto mas complicado, hasta el momento, que puedes encontrar." -> 15 palabras
     * Pista. Se recomienda convertir los puntos comas y dobles espacios a un espacio. Luego trocear con un split y contar cuantas palabras salen.
     */
    public int contarPalabras(String texto){
        String aus = texto.replace("  "," ").replace("..",".").replace(",,",",").replace("::",":");
        while (aus.replace("  "," ").replace("..",".").replace(",,",",").replace("::",":").length() != aus.length() ){
            aus = aus.replace("  "," ").replace("..",".").replace(",,",",").replace("::",":");
        }
        System.out.println("reemplazsado "+ aus);
        String[] listaPalabras = aus.split("[' ']+|['.']+|[',']+|[':']+");
        int count= 0;
        for (String linea :listaPalabras){
            if(linea.length()>0){
                count++;
            }
        }
        return count;
    }

    /**
     * Cuenta cuantas líneas hay en el texto. Se considera una línea si tiene algún carácter. El salto de línea se realiza con el carácter \n o, en algunos textos, con \r\n.
     */
    public int contarLineas(String texto){
        String[] listaParrafos =  texto.split("[\n]|[\r]");
        int count= 0;
        for (String linea :listaParrafos){
            if(linea.length()>0){
                count++;
            }
        }
        return count;
    }
    
    /**
     * Cuenta cuantas vocales hay en un texto (con tildes incluidas á).
     */
    public int contarVocales(String texto){
        char[] text =this.insensible(texto).toCharArray();
        List<Character> vocales = new ArrayList<>(List.of('a','e','i','o','u'));
        int i = 0;
        for (char letra: text){
            if (vocales.contains( Character.valueOf(letra))){
                i++;
            }
        }
        return i;
    }

    /**
     * Eliminación de espacios a izquierda y derecha
     */
    public String quitarEspacios(String frase){
        return frase.trim();
    }

}
