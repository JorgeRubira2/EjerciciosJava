/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210729;

import com.jorgerubira.ejerciciosjava.pojo.Persona;
import java.util.List;
import java.util.function.Consumer;

/**
 *
 * @author Sofia
 */
public class EjemplosMetodosFinales {

    private String nombre;
    private String ciudad;
    private int edad;

    public EjemplosMetodosFinales(String nombre, String ciudad, int edad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public static void main(String[] args) {
        List<Persona> lista = List.of(
                //                new Persona("Ana", "Madrid", 42),
                //                new Persona("Juan", "Zaragoza", 52),
                //                new Persona("Pepe", "Huesca", 23),
                //                new Persona("Fran", "Madrid", 23)
                new Persona("Ana", "Zaragoza", 40),
                new Persona("Juan", "Huesca", 30),
                new Persona("Alberto", "Huesca", 24),
                new Persona("Pepe", "Zaragoza", 20));
        Consumer<Persona> c1=x->x.setNombre(x.getNombre().toUpperCase());
        
        List<Consumer<Persona>> oper=List.of(
                x->x.setNombre(x.getNombre().toUpperCase()),
                x->x.setNombre(x.getNombre().replaceAll("E", "3")),
                x->{
                    if(x.getNombre().startsWith("A")){
                        x.setNombre(null);
                    }
                }
        );
//        String nombre = lista.stream()
//                .map(x->x.getNombre())
//                .collect(Collectors.joining(","));
////                .forEach(x->System.out.println(x);)
//        System.out.println(nombre);
//        
//        
//        List<Integer> edades = List.of(4,3,5,2);
//        Optional<Integer> i = edades.stream()
//                .reduce((x,y)->x+y);
//        if (i.isPresent()){
//            System.out.println(i.get());
//        }
//        
//        Optional<Integer> max = edades.stream()
//                .reduce((x,y)->x>y?x:y);
//        System.out.println(max.get());
//        List<Integer> lista1 = List.of(2,-4,1,-2);
//        List<Integer> lista2 = lista1.stream()
//                .filter(x -> x>0)
//                .collect(Collectors.toList());
//        List<Persona> resultado = lista.stream()
//        int contador = 0;
        for (Consumer<Persona> ope:oper){
            lista.stream().forEach(ope);
        }
lista.stream()
                //                .map((x)->x.getEdad())
                //                .reduce((x,y)->x.getEdad()>y.getEdad()?x:y);

                //        if (resultado.isPresent()){
                //            System.out.println(resultado.get() + " ");
                //        } else {
                //            System.out.println("ninguno");
                //        }
                //                .sorted((x,y)->x.getEdad()-y.getEdad())
                ////                .filter(x -> x.getCiudad().equals("Zaragoza"))
                //                .map(x -> x.getNombre())
                .filter(x -> x.getNombre()!=null)
//                .count();
                .forEach(x -> System.out.println(x.getNombre()+" "));
//        System.out.println(contador);
//                .collect(Collectors.toList());
//        lista2.forEach(x->System.out.println(x+" "));
    }

}
