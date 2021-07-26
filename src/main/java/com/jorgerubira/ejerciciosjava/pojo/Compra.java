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
public class Compra {
    private int totalArticulos;
    private boolean carro;

    public Compra(int totalArticulos, boolean carro) {
        this.totalArticulos = totalArticulos;
        this.carro = carro;
    }

    public int getTotalArticulos() {
        return totalArticulos;
    }

    public void setTotalArticulos(int totalArticulos) {
        this.totalArticulos = totalArticulos;
    }

    public boolean isCarro() {
        return carro;
    }

    public void setCarro(boolean carro) {
        this.carro = carro;
    }
    
}
