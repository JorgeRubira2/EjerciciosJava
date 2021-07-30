/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosjava.pojo;

/**
 *
 * @author PC
 */
public class RangoEdad {

    public RangoEdad(Rango rango, Long pos1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public enum Rango{
        Menor18, Entre18y60, Mayor60
    }
    private Rango rango;
    private int personas;

    public RangoEdad(Rango rango, int personas) {
        this.rango = rango;
        this.personas = personas;
    }

    public int getPersonas() {
        return personas;
    }

    public Rango getRango() {
        return rango;
    }
    
}
