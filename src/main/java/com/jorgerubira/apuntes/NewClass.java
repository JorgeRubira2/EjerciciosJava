/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.apuntes;

import java.io.File;

/**
 *
 * @author javia
 */
public class NewClass {
    public static void main(String[] args) throws Exception {
        
        File ruta = new File("d://zFicheros//d1//d2//Fichero.txt");
        try{
        System.out.println("A");
        ruta.getParentFile().mkdir();
        System.out.println("B");
        }catch(Exception e){System.out.println("No ejecutar");}
    }
}
