/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosjava.interfaces;

/**
 *
 * @author PC
 */
public interface ICalculadoraBasica {
    
    public ICalculadoraBasica reset();  //Poner a 0 la calculadora
    public ICalculadoraBasica sumar(double valor); 
    public ICalculadoraBasica restar(double valor); 
    public ICalculadoraBasica multiplicar(double valor); 
    public ICalculadoraBasica dividir(double valor);
    public double getResultado();
}
  