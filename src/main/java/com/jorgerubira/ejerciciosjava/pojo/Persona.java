package com.jorgerubira.ejerciciosjava.pojo;

import java.util.Date;
import java.util.Optional;

public class Persona { 
    private String nombre; 
    private String ciudad;
    private int edad;
    private Date fechaNacimiento;
    private int altura;
    private int peso;
    
    //Solo para el supermercado.
    //private Optional<Compra> cesta;

    public Persona(String nombre, String ciudad){
        this.nombre = nombre;
        this.ciudad = ciudad;
    }
   
    
    //Solo para el supermercado.
    private Optional<Compra> cesta=Optional.empty();   

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    public Persona(String nombre, Compra cesta) {
        this.nombre = nombre;
        this.cesta = Optional.ofNullable(cesta);

    }
    
    public Persona(String nombre, String ciudad, int edad, Date fechaNacimiento, int altura, int peso) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.altura = altura;
        this.peso = peso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public Optional<Compra> getCesta() {
        return cesta;
    }

    public void setCesta(Compra cesta) {
        this.cesta = Optional.ofNullable(cesta);
    }
       
}
