/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210831;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PC
 */
public class TextoPlano {
    
    public static void main(String[] args) {
        String ruta="d:\\zzzCarpeta\\A\\B\\ficheroSalida.txt";
        File file=new File(ruta);
        file.getParentFile().mkdirs();
        try(FileWriter fw=new FileWriter(file);
            BufferedWriter bw=new BufferedWriter(fw)){
            bw.write("2"); bw.newLine();
            bw.write("4"); bw.newLine();
            bw.write("5"); bw.newLine();
            //bw.flush(); //Forzar a que haga el guardado.
        }catch(IOException e){
            e.printStackTrace();
        }
        
        try(FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr)){
            String linea;
            while( (linea = br.readLine()) != null ){
                System.out.println(linea);    
            }
        }catch(Exception e){
        }
        
        try(FileReader fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr)){
            String linea = br.readLine();
            while( linea!=null ){
                System.out.println(linea);    
                linea = br.readLine();
            }
        }catch(Exception e){
        }        
        
        //java.nio
        //CSV
        //1;Pepe;45
        //2;Juan;25
        try{
            List<String> lineas=Files.readAllLines(Paths.get(ruta));    
            lineas.stream().forEach(x->System.out.println(x));
        }catch(Exception e){
        }
        
        try{
            
            Files.lines(Paths.get(ruta))
                 .forEach(x->System.out.println(x));    
        }catch(Exception e){
        }
        
        try{
            String texto=Files.readString(Paths.get(ruta));
            String []lineas=texto.split("\n");
            String var="1;Pepe;Matric";
            String []campos=var.split(";");
            
        }catch(Exception e){
        }

        List<String> nombres=new ArrayList<>();
        nombres.add("Ana");
        nombres.add("Fran");
        nombres.add("Juan");
        
        try{
            Files.write(Paths.get(ruta), nombres, StandardOpenOption.CREATE);  
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        


        

        
        //Toda la ruta  Pulgar
        //Da un error   Carita
        
    }
    
}
