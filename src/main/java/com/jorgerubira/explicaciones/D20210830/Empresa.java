/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210830;

public class Empresa<T> {
    
    private T maquina;

    public T getMaquina() {
        return maquina;
    }

    public void setMaquina(T maquina) {
        this.maquina = maquina;
    }
   
    public static void main(String[] args) {
        Empresa<Integer> e=new Empresa<>();
        e.setMaquina(new Integer(4));
        Integer a=e.getMaquina();
        
        
        
    }
    
    
    
}
