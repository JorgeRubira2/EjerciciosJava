/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210830;

import java.util.Optional;

/**
 *
 * @author PC
 */
public class TipoEjemplo {
    public static void main(String[] args) {
        int vari1=2;
        Integer vari2=2;
        Optional<Integer> vari3=Optional.of(2);
        Optional<Integer> vari4=Optional.ofNullable(vari2);
        
        if (vari4.isPresent() && vari4.isEmpty()==false){
            Integer vari5=vari4.get();
        }
        
        Integer vari6 = vari4.orElse(0);
        
        short s=4;
        Integer vari7=new Integer(s);
        
        short f=vari7.shortValue();
        
    }
}
