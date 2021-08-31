package com.jorgerubira.explicaciones.D20210830;

import lombok.Builder;


public class FuncionesImpl implements IFunciones{

    @Override
    public void funcion1() {
        System.out.println("Hola");
    }

    @Override
    public void funcion1(int a) {
        System.out.println("Hola 3");
    }    
    
    @Override
    public void funcion2(String s) {
        System.out.println("Hola 2");
    }


    
}
