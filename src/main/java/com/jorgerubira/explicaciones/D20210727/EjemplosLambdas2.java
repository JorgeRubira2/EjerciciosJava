/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210727;

import com.jorgerubira.ejerciciosjava.pojo.Ciudad;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class Persona{
    private String nombre;
    private int edad;
    private boolean permisoTrabajo;
    private String pais;

    public Persona(String nombre, String pais, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.pais=pais;
    }

    public String getPais() {
        return pais;
    }
    
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public boolean isPermisoTrabajo() {
        return permisoTrabajo;
    }

    public void setPermisoTrabajo(boolean permisoTrabajo) {
        this.permisoTrabajo = permisoTrabajo;
    }
    
    
}

interface DarPermiso{
    public boolean comprobarSiAceptaPermiso(Persona p);
}


interface DarPermiso2{
    public boolean comprobarSiAceptaPermiso(Persona p1, Persona p2);
}

//Interface Funcional -> Solo 1 metodo. Lambdas 
interface Calculadora{
    public double calculo(double a, double b);
}

interface Generador{
    public Optional<Persona> generar();
}

interface Mostrador{
    public void mostrador(Persona p);
}


class FormaVieja implements DarPermiso{
  
    @Override
    public boolean comprobarSiAceptaPermiso(Persona p) {
        return p.getEdad()>=16 && p.getEdad()<=80 && p.getPais().equals("España");
    }
}

class FormaVieja2 implements DarPermiso{
    @Override
    public boolean comprobarSiAceptaPermiso(Persona p) {
        return p.getEdad()>=16;
    }
}

public class EjemplosLambdas2 {
    
    public static void verPersonas(List<Persona> lista, Mostrador operacion){
        for(Persona p:lista){
            operacion.mostrador(p);
        }
    }
    
    public static void darPermisoTrabajo(List<Persona> lista, DarPermiso condicion){
        //Si tiene mas de 16 -> Le damos permiso de trabajo.
        for(Persona p:lista){
            //
           if (condicion.comprobarSiAceptaPermiso(p)){
               p.setPermisoTrabajo(true);
           } 
        }
    }
    
    public static void darPermisoTrabajo2(List<Persona> lista, DarPermiso2 condicion){
        //Si tiene mas de 16 -> Le damos permiso de trabajo.
        if (condicion.comprobarSiAceptaPermiso(lista.get(0), lista.get(1))){
            lista.get(0).setPermisoTrabajo(true);
            lista.get(1).setPermisoTrabajo(true);
        }
    }    
    
    
    public static void main(String[] args) {
        List<Persona> lista=new ArrayList<>();
        lista.add(new Persona("Juan", "España", 10));
        lista.add(new Persona("Ana", "Francia", 20));
        lista.add(new Persona("Fran", "Alemania", 70));
        
        verPersonas(lista, (p)->{ System.out.println(p.getNombre()); } );
        verPersonas(lista, (p)->{ System.out.println(p.getNombre() + " " + p.getEdad()); } );

        /**
         * for while 
         */
        
        /*
        //Juan false - Ana false - Fran false -
        
        //Clase anonima
        DarPermiso obj=new DarPermiso() {
            @Override
            public boolean comprobarSiAceptaPermiso(Persona p) {
                return p.getEdad()>21;
            }
        };
        
        //Lambda.
        DarPermiso obj2=(p)-> {
            if (p.getPais().equals("España")){
                return p.getEdad()>21;
            }
            if (p.getPais().equals("Francia")){
                return p.getEdad()>16;
            }
            return false;
        };
        
        darPermisoTrabajo(lista, obj);
        darPermisoTrabajo(lista, obj2);
        darPermisoTrabajo(lista, (p)->p.getEdad()>21 && p.getPais().equals("España") );
        darPermisoTrabajo2(lista, (padre,hijo)->padre.getEdad()>21 && hijo.getEdad()>16 && hijo.getPais().equals("España") );
        
        Calculadora cal=(a,c)->a+c;
        
        Generador g=()->Optional.empty();
        
        //darPermisoTrabajo(lista, 16, 1000 ,"España");
        //darPermisoTrabajo(lista, 16, 1000 ,"");
        
        for (Persona persona : lista) {
            System.out.print(persona.getNombre() + " " + persona.isPermisoTrabajo() + " - ");
        }
        //Juan false - Ana false - Fran true - 
        */
    }
}
