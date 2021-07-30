/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosjava.pojo;

import java.util.List;

/**
 *
 * @author PC
 * @param <Producto>
 */
public class Compra<Producto> {
    private int totalArticulos;
    private boolean carro;
    private List<Producto> listaProductos;

    public Compra(int totalArticulos, boolean carro) {
        this.totalArticulos = totalArticulos;
        this.carro = carro;
    }

    public Compra(List<Producto> listaProductos) {
        this.totalArticulos = listaProductos.size();
        this.listaProductos = listaProductos;
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
    
    public boolean contieneDetalleDeProductos(){
        return !listaProductos.isEmpty();
    }
    
    public Producto getProducto(int index){
        return listaProductos.get(index);
    }
    
}
