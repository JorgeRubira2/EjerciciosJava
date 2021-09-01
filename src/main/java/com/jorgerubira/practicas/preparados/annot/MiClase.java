/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.practicas.preparados.annot;

public class MiClase {

    @MiAnotacion
    public void A(){
        System.out.println("A ");
    }
    
    public void B(){
        System.out.println("B");
    }

    @MiAnotacion
    public void C(){
        System.out.println("C");
    }
    
}
