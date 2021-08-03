/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210730;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PC
 */
public class EjemplosExcepciones {
    
    //throws -> Pasar la responsabilidad al que llama. Metodo
    //throw -> Lanzar una excepcion. Bloque
    public void metodo(String nombre) throws FileNotFoundException {
        FileInputStream fis=new FileInputStream(nombre);    
    }
    
    public static void metodo2() throws FileNotFoundException{
            EjemplosExcepciones obj=new EjemplosExcepciones();
            obj.metodo("c:\\rrrr.txt");

    }
    
    public static void metodo3() throws FileNotFoundException{
        FileInputStream fis=null;
        try{
            
        }finally{
            System.err.println("A");
            try { fis.close(); } catch (IOException ex) {}        
        }
    }
    
    public static void main(String[] args) {
        
        try(FileInputStream fis2= new FileInputStream("c:\\rrr.txt")){
            fis2.available();
            fis2.available();
        } catch (Exception ex2) {
            System.out.println("Hola");
        }        

        
        try {
            metodo3();
        } catch (FileNotFoundException ex) {
            System.out.println("Hola");
        }        
        System.out.println("Adios");
        
        
        
        
        //Captura
        try {
            metodo2();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EjemplosExcepciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        //Error
        //StackOverflowError    <<Me quedo sin recursos. Finaliza el programa cuando ocurre
        //Exception
        //Exception     <<Puedo gestionarlo.

        try{
            FileInputStream fis=new FileInputStream("C:\\qwerqwer.txt");    
            //qwr
            //qwr
            //qwr
            //qwr
                    
        }catch(IndexOutOfBoundsException | FileNotFoundException | ArithmeticException | ArrayStoreException e){
            System.out.println("Fichero no encontrado");
            System.out.println("Fichero no encontrado");
            System.out.println("Fichero no encontrado");
        }catch(Exception e){
            System.out.println("Otro error");
        }
        
        
        if (true){
            int b=0;
            if (b!=0){
                int a=4/b;
            }
        }
        
        if (true){
            throw new RuntimeException("Error externo");
        }
        if (true){
            //throw new Exception("Error externo");
        }
            



        try{
            if (true){
                //throw new Exception("Este es un error");    
                throw new StackOverflowError();    
            }
            System.out.println("Entra");
        }catch(Exception e){
            System.out.println("No entra");
        }
        /*Entra pulgar
        No entra carita
        Nada fiesta*/
        
        //No entra
        
        
    }
    
}
