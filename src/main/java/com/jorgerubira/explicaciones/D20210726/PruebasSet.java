/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210726;

//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.LinkedHashSet;
//import java.util.List;
//import java.util.Set;
//import java.util.TreeSet;
//<<<<<<< HEAD
//import java.util.Vector;
//import java.util.TreeMap;
//import java.util.Map;
//
//class Persona implements Comparable<Object> {
//
//    private String nombre;
//    private int edad;
//
//    public Persona(String nombre, int edad) {
//        this.nombre = nombre;
//        this.edad = edad;
//    }
//
//    public int getEdad() {
//        return edad;
//    }
//
//    public String getNombre() {
//        return nombre;
//    }
//
//    @Override
//    public int hashCode() {
//        return edad;
//    }
//
//    @Override
//    public int compareTo(Object o) {
//        return edad - ((Persona) o).edad;
//        //"Ana".comparteTo("Juan")     -1 -> Ana va antes que Juan
//        //return this.nombre.compareTo(((Persona)o).nombre);
//    }
//
//}
//
//public class PruebasSet {
//
//    public static void main(String[] args) {
////        Set<String> conjunto1=new TreeSet<>();
////        Set<String> conjunto2=new HashSet<>();
////        Set<String> conjunto3=new LinkedHashSet<>();
////        
////        
////        conjunto1.add("Val");
////        conjunto1.add("Pepe");
////        conjunto1.add("Juan");
////        conjunto1.add("Ana");
////        conjunto1.add("Val");
////        conjunto1.add("Bautista");
////        conjunto1.add("Juan");
////        
////        List<String> lista=new ArrayList<>(conjunto1);
////        
////
////        
////        conjunto1.remove("Juan");
////        
////        //No lo inserta       Pulgar
////        //Lo inserta 2 veces  Carita
////        
////        boolean b=conjunto1.contains("Ana");
////
////        if (conjunto1.contains("Ana")){
////            
////        }
////        
////        int elementos=conjunto1.size();
////        
////        //Forech no permite modificar estructura (add-remove).
////        for (String nombre:conjunto1){
////            System.out.print(nombre + " ");   //Orden - aletorio
////        }
////        
////
////        //'A B C'
////        //'A D'
////        //retainAll->Interseccion
////        
////        Set<String> noBorrar=new HashSet<>();
////        for (String nombre:conjunto1){  //Borrar elementos que empiecen por A
////            if (nombre.startsWith("A")==false){
////                noBorrar.add(nombre);
////            }
////        }
////        conjunto1=noBorrar;
////        //conjunto1.retainAll(noBorrar);  //List ArrayList<String>
////
////        for (String nombre:conjunto1){
////            System.out.println("");
////        }
////        
////        System.out.println("\n-------------");
////        
////        Set<Persona> conjuntoPersonas=new TreeSet<>();
////        //Comparable
////        conjuntoPersonas.add(new Persona("Ana", 42));
////        conjuntoPersonas.add(new Persona("Juan", 12));
////        conjuntoPersonas.add(new Persona("Ana", 12));
////        for (Persona p:conjuntoPersonas){
////            System.out.print(p.getNombre() + " "); 
////        }
////        System.out.print(conjuntoPersonas.size()); 
////        //2 Pulgar
////        //3 Carita
////        //3
//
////        Set<Persona> e1 = new HashSet<>();
////        e1.add(new Persona("Pepe", 45));
////        e1.add(new Persona("Fran", 80));
////        e1.add(new Persona("Pepe", 10));
////        e1.add(new Persona("Pepe", 45));
////        for (Persona i : e1) {
////            System.out.println(i.getNombre() + " ");
////        }
////        Set<String> per = new HashSet<>(Set.of("Pepe"));
////        List<String> per = new Vector<>();
////        e1.add("Pepe");
////        e1.add("Fran");        
////        e1.add("Pepe");
////        e1.add("Pepe");
////        e1.retainAll(per);
////        for (String i : e1) {
////            System.out.println(i + " ");
////        }
////        Map<Long, Persona> e1=new TreeMap<>();
////        e1.put(4L, new Persona("Pepe", 30));
////        e1.put(1L, new Persona("Fran", 20));
////        e1.put(3L, new Persona("Ana", 40));
////        e1.put(2L, new Persona("Juan", 50));
////        for (Persona i : e1.values()) {
////            System.out.println(i.getNombre() + " ");
////        }
//        List<Persona> e1 = new ArrayList<>();
//        e1.add(new Persona("Pepe", 30));
//        e1.add(new Persona("Juan", 50));
//        e1.add(1,new Persona("Juan", 40));
//        e1.add(1,new Persona("Ana", 20));
//        e1.remove(2);
//        e1.add(new Persona("Ana", 20));
//        
////        for (int n = 0; n < e1.size(); n++) {
////            if(e1.get(n).getNombre().equals("Juan")){
////                e1.remove(n);
////            }
////        }
////        
////        
//        for (Persona p : e1) {
//            System.out.println(p.getNombre() + " ");
//        }
//
//=======
//
//
//class Persona implements Comparable{
//    private String nombre;
//    private int edad;
//
//    public Persona(String nombre, int edad) {
//        this.nombre = nombre;
//        this.edad = edad;
//    }
//
//    public int getEdad() {
//        return edad;
//    }
//
//    public String getNombre() {
//        return nombre;
//    }
//
//    @Override
//    public int compareTo(Object o) {
//        System.out.print("D");
//        //return edad-((Persona)o).edad;
//        //"Ana".comparteTo("Juan")     -1 -> Ana va antes que Juan
//        return this.nombre.compareTo(((Persona)o).nombre);
//    }
// 
//    
//}
//
//public class PruebasSet {
//    public static void main(String[] args) {
//        Set<String> conjunto1=new TreeSet<>();
//        Set<String> conjunto2=new HashSet<>();
//        Set<String> conjunto3=new LinkedHashSet<>();
//        
//        conjunto1.add("Val");
//        conjunto1.add("Val");
//        conjunto1.add("Val");
//        conjunto1.add("Val");
//        conjunto1.add("Pepe");
//        conjunto1.add("Juan");
//        conjunto1.add("Ana");
//        conjunto1.add("Val");
//        conjunto1.add("Bautista");
//        conjunto1.add("Juan");
//        
//        List<String> lista=new ArrayList<>(conjunto1);
//        
//
//        
//        conjunto1.remove("Juan");
//        
//        //No lo inserta       Pulgar
//        //Lo inserta 2 veces  Carita
//        
//        boolean b=conjunto1.contains("Ana");
//
//        if (conjunto1.contains("Ana")){
//            
//        }
//        
//        int elementos=conjunto1.size();
//        
//        //Forech no permite modificar estructura (add-remove).
//        for (String nombre:conjunto1){
//            System.out.print(nombre + " ");   //Orden - aletorio
//        }
//        
//
//        //'A B C'
//        //'A D'
//        //retainAll->Interseccion
//        
//        Set<String> noBorrar=new HashSet<>();
//        for (String nombre:conjunto1){  //Borrar elementos que empiecen por A
//            if (nombre.startsWith("A")==false){
//                noBorrar.add(nombre);
//            }
//        }
//        conjunto1=noBorrar;
//        //conjunto1.retainAll(noBorrar);  //List ArrayList<String>
//
//        for (String nombre:conjunto1){
//            System.out.println("");
//        }
//        
//        System.out.println("\n-------------");
//        
//        Set<Persona> conjuntoPersonas=new TreeSet<>();
//        //Comparable
//        conjuntoPersonas.add(new Persona("Ana", 42));
//        conjuntoPersonas.add(new Persona("Juan", 12));
//        conjuntoPersonas.add(new Persona("Ana", 12));
//        for (Persona p:conjuntoPersonas){
//            System.out.print(p.getNombre() + " "); 
//        }
//        System.out.print(conjuntoPersonas.size()); 
//        //2 Pulgar
//        //3 Carita
//        //3
//>>>>>>> origin/master
//    }
//}
