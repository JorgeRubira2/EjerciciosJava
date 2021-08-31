/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210831;

import java.io.File;

/**
 *
 * @author PC
 */
public class EjemploFile {
    public static void main(String[] args) {
        String ruta="D:\\";
        File f=new File(ruta);
        if (f.exists()){
            System.out.println("Existe");
        }else{
            System.out.println("No existe");
        }
        
        if (f.isDirectory()){
            System.out.println("Directorio");
            
            File []ficherosInternos=f.listFiles();
            for (File ficheroInterno : ficherosInternos) {
                if (ficheroInterno.isDirectory()){
                    System.out.print("*");
                }
                try{
                    System.out.println(ficheroInterno.getName() + " " + ficheroInterno.getAbsolutePath() + " " + ficheroInterno.getParent()  );    
                }catch(Exception e){
                    
                }
            }
        }else{
            System.out.println("Fichero");
        }
        
   

        
        
        
    }
}
