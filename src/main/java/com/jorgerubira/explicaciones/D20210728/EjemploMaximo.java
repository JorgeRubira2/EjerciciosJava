/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210728;

import java.util.List;
import java.util.Optional;

class Persona5{
    private String nombre;
    private int edad;
    private Optional<Compra3> compra=Optional.empty();

    public Persona5(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Persona5(String nombre, int edad, Compra3 compra) {
        this.nombre = nombre;
        this.edad = edad;
        this.compra = Optional.ofNullable(compra);
    }

    public Optional<Compra3> getCompra() {
        return compra;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public int hashCode() {
        return 2222; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    @Override
    public boolean equals(Object obj) {
        return nombre.equals(((Persona5)obj).nombre) ;
    }

    
}

class Compra3{
    private int totalProductos;
    private boolean pagado;

    public Compra3(int totalProductos, boolean pagado) {
        this.totalProductos = totalProductos;
        this.pagado = pagado;
    }

    public int getTotalProductos() {
        return totalProductos;
    }

    public boolean isPagado() {
        return pagado;
    }
    
    public void pagar(){
        pagado=true;
    }
    
}


public class EjemploMaximo {
    public static void main(String[] args) {
        List<Persona5> personas=List.of(
                    new Persona5("Juan", 20),
                    new Persona5("Ana", 64, new Compra3(4, true)),
                    new Persona5("Pepe", 54, new Compra3(2, false)),
                    new Persona5("Ana", 64, new Compra3(4, true)),
                    new Persona5("Ana", 64, new Compra3(4, true))
        );        
        
        //Ana2 Ana3 
        //Juan Ana < 
        //Nada <
        
        Optional<Persona5> p=personas.stream()
                                     .max((x,y)->x.getEdad()-y.getEdad() );
        
        //System.out.print(p.get().getNombre());  //Pepe
                                                //Ana

        //Los dos que mas edad tienen.
        personas.stream()
                .sorted((x,y)->y.getEdad()-x.getEdad())
                .limit(2)
                .forEach(x->System.out.print(x.getNombre() + " "));
        
        personas.stream()
                .skip(3)
                .limit(3)
                .forEach(x->System.out.print(x.getNombre() + " "));        

        
        //Juan Ana 
        //Pepe Ana2 
        //[1000] [0-49][50-99][100-149]
        //[0-1][2-3]
        
        //Comparator
        //<0  a < b
        //==0 a == b
        //>0  a > b
        //a-b;
        //2  4 -> 2-4 -> <0
        //4  4 -> 4-4 -> ==0
        //5  2 -> 5-2 -> >0
        //if (a<b){
        //    return -1;
        //}else if (a>b){
        //    return 1;
        //}else{
        //    return 0;
        //}
        
                                                
        
        
    }
}
