package com.jorgerubira.ejerciciosjava.pojo;

public class RangoEdad {
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
