package com.jorgerubira.explicaciones.D20210727;

import com.jorgerubira.ejerciciosjava.pojo.Compra;
import com.jorgerubira.ejerciciosjava.pojo.Persona;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;




public class EjemploPredicates {
    public static void main(String[] args) {
        //Resumen
        //Predicate<Per3> condicion=(p)->p.getEdad()>=16;           //Recibe un objeto y devuelve un boolean
        //Function<Per3,String> transformador=(p)->p.getNombre();   //Recube un objeto y devuelve otro objeto
        //Consumer<Persona> ponerA18=(p)->p.setEdad(18);            //Recibe un lo trata sin devolver nada
        //Supplier s=()->Optional.empty();                          //Genera un objeto.
        
        
        //Analiza un objeto y devuelve un boolean indicando si ese objeto cumple una condición.
        Predicate<Per3> condicion=(p)->p.getEdad()>=16;
        
        Function<Per3,String> transformador=(p)->p.getNombre();
        Function<Persona,Compra> 
                    transformador2=(p)->{
                        if (p.getCesta().isPresent()){
                            return p.getCesta().get();
                        }else {
                            return null;
                        }
                    };
        
        Function<Persona,Compra> transformador3=(p)->p.getCesta().isPresent()?p.getCesta().get():null;

        Function<String, Persona> trans=(nombre)->new Persona(nombre, 18);
        
        //List<String> nombres=List.of("Ana", "Juan", "Pepe");
        //List<Persona> person=List.of(nombres.stream().map(trans).toArray());
        
        Function<String, String> trans2=(palabra)->palabra.toUpperCase();
        UnaryOperator<String> trans3=(palabra)->palabra.toUpperCase();
        
        //Visualizar o tratar información. No devuelve nada. void 
        Consumer<String> mostrar=(palabra)->System.out.println(palabra);
        Consumer<Persona> mostrarPer=(p)->System.out.println(p.getNombre() + " " + p.getEdad());
        
        Consumer<Persona> ponerA18=(p)->p.setEdad(18);
        
        List<Persona> lista=new ArrayList<>();
        lista.add(new Persona("Juan", 20));
        lista.add(new Persona("Ana", 70));        
        lista.add(new Persona("Fran", 10));
        lista.add(new Persona("Ana", 20));
        
        lista.stream().forEach(ponerA18);
        lista.stream().forEach(mostrarPer);
        
        lista.stream().forEach((p)->System.out.println(p));
        
        //No lleva parametros pero devuelve un objeto.
        Supplier s=()->Optional.empty();
        List<Optional<Integer>> a=new ArrayList<>(100);
        
        
        //BiConsumer visualiza dos objetos
        BiConsumer<Persona, Persona> mostrar2Per=(p1,p2)->System.out.println(p1.getNombre() + " " + p1.getNombre());
    }




}
