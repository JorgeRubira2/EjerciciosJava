/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210901.anotaciones;


public class PersonaFiesta {
    
    @AntesDeLaFiesta
    public void Vestirse(){
        System.out.println("Vestirse");
    }
    
    @AntesDeLaFiesta
    @DespuesDeLaFiesta
    public void Conducir(){
        System.out.println("Conducir");
    }

    @AntesDeLaFiesta
    public void PrepararGlobos(){
        System.out.println("PrepararGlobos");
    }

    @DespuesDeLaFiesta
    public void RecogerBasura(){
        System.out.println("RecogerBasura");
    }

}
