package com.jorgerubira.explicaciones.D20210722;

import java.util.Date;

public abstract class Persona { //No se puede hacer New de Persona
    //Ctrl + Mays + i   Import automaticamente
    //Ctrl + Space      Saca la ayuda de lo que estas editando
    //Alt + Intr
    
    private String nombre;
    private String direccion;
    private Date fechaNacimiento;

    public abstract void trabajar(); //Metodo abstracto no lleva codigo fuente. 
                                    //Obligacion a las clases derivadas tener este metodo.
    
    public void comer(){
        System.out.println("Comer en el salon");
    }
    
    public final void cobranFinalMes(){
        System.out.println("Cobrar a traves del banco");
    }    

    public Persona() {
    }
    
    public Persona(String nombre, String direccion, Date fechaNacimiento) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
}
