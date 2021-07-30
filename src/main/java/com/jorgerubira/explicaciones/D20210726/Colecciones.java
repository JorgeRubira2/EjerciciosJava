/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210726;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

/**
 *
 * @author PC
 */
public class Colecciones {

    public static void main(String[] args) {
        //Mutables
        //Calculo PI
        //Radio 
        //Procesadores (4 cores). Concurrencia.
        //add(){
        List<String> lista1 = new ArrayList<>();  //No concurrencia. <Mas rapido
        List<String> lista2 = new Vector<>();     //Concurrencia. Un poco mas lento
        List<String> lista3 = new LinkedList<>(); //Implementa List pero tambien Queue, Deque
        Queue<String> lista3b = new LinkedList<>(); //Encolar, Sacar
        Deque<String> lista3c = new LinkedList<>(); //Apilar, Desapilar, Encolar, Sacar
        //LinkedList<String> lista3d=new LinkedList<>(); 
        Stack<String> lista4 = new Stack<>();  //Versión antigua

        List<String> lista5 = List.of("Ana", "Juan", "Pepe");    //List inmutable
        lista5.add("H"); //Excepcion.estamos añadiendo en un list , que es inmutable

        List<String> lista6 = new ArrayList<>();
        lista6.add("R");
        lista6.add("R2");
        lista6.add("R4");

        List<String> lista7=new ArrayList<>(List.of("Ana", "Juan", "Pepe")); //este es mutable, desde un array inmutable 
        
       
        lista4.push("Apilar");
        lista4.pop();

        /*lista3b.add("Juan");
        lista3b.add("Ana");
        lista3b.add("Pepe");
        
        lista3b.poll();
        System.out.println(lista3b.poll());
        System.out.println(lista3b.size());*/
        lista3c.addFirst("Ana");
        lista3c.addFirst("Juan");
        lista3c.addFirst("Pepe");
        System.out.println(lista3c.poll());

        //Ana pulgar
        //Pepe Carita.
        //2  Pulgar
        //1  Carita
        /*System.out.println(a[4]);
        System.out.println(lista1.get(4));
        System.out.println(lista1.set(4,"Pepe"));*/
        lista1.add("Hola "); //Añade un elemento al final
        lista1.add("tal "); //Añade un elemento al final
        lista1.add(1, "que "); //Añadir por la mitad
        lista1.add(5, "que "); //Saltará una excepción
        lista1.remove("tal ");  //Borrado con contenido.
        lista1.remove(0);   //Borrado con posición
        int pos = lista1.indexOf("que ");  //Buscar un elemento. -1 si no lo encuentra.
        boolean b = lista1.contains("que ");  //Buscar un elemento

        String elemento = lista1.get(0);  //Lee la información
        lista1.set(0, "Buenos dias ");  //Modifica la información.

        for (String aux : lista1) {
            System.out.print(aux);
        }
        for (int n = 0; n < lista1.size(); n++) {
            if (lista1.get(n).equals("que ")) {
                lista1.set(n, "como ");
            }
        }
        for (int n = lista1.size() - 1; n >= 0; n--) {
            if (lista1.get(n).equals("que ")) {
                lista1.remove(n);
            }
        }
        
    }
}
