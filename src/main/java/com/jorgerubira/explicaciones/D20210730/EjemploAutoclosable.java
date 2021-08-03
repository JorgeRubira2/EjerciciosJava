/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210730;

import java.io.FileInputStream;

class Fichero implements AutoCloseable{
    public void metodo1() throws MiParticularException{
        throw new MiParticularException();
    }
    
    public void metodo2() throws MiParticular2Exception{
        throw new MiParticular2Exception();
    }    
    
    public void liberar(){
        System.out.println("Liberar");
    }

    @Override
    public void close() throws Exception {
        liberar();
    }
}

class MiParticularException extends Exception{

    public MiParticularException() {
        super("Exception particular");
    }
    
}

class MiParticular2Exception extends RuntimeException{
}


public class EjemploAutoclosable {
    public static void main(String[] args) {
        try(Fichero f1=new Fichero();
            Fichero f2=new Fichero();
            FileInputStream fis=new FileInputStream("c:\\aaa.txt");
            ){
            f1.metodo1();
            f2.metodo1();
        }catch(Exception e){
        }
        
        Fichero f2=new Fichero();
        f2.metodo2();
        //Liberar
        
        //Liberar
        //Liberar
    }
}
