
package com.jorgerubira.explicaciones.D20210728;


public class Visado {
    
    private String nombre;
    private String numero;
    private int numeroViajes;
    private boolean caducado;
    private boolean bloqueado;

    public Visado crear(String nombre, String numero){
        this.nombre=nombre;
        this.numero=numero;
        return this;
    }
    
    public Visado hacerUnViaje(){
        numeroViajes++;
        return this;
    }
    
    public Visado caduca(){
        caducado=true;
        return this;
    }
    
    public Visado requisar(){
        bloqueado=true;
        return this;
    }
    
    public Visado devolver(){
        bloqueado=false;
        return this;
    }
    
    public static void main(String[] args) {
        Visado v=new Visado();
        v.crear("Juan", "2424242424").hacerUnViaje().hacerUnViaje().requisar().devolver().hacerUnViaje();
    }
    
}
