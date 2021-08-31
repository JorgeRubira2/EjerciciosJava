package com.jorgerubira.explicaciones.D20210830;


public class Coche {
    //private Encapsulation, -> get set
    private int ruedas;
    private int puertas;

    public Coche() {
        ruedas=4;
        puertas=5;
    }

    public Coche(int ruedas, int puertas) {
        this.ruedas = ruedas;
        this.puertas = puertas;
    }

    public int getPuertas() {
        return puertas;
    }

    public int getRuedas() {
        return ruedas;
    }
    
    
    
    
    
}
