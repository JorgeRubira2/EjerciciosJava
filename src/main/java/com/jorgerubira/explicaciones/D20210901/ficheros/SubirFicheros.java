/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.explicaciones.D20210901.ficheros;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SubirFicheros {
    
    public Optional<Integer> optional(){
        try{
            //Operacion
            return Optional.of(3);
        }catch(Exception e){
            return Optional.empty();    //Equivalente a devolver nulos.
        }
    }
    
    public static void main(String[] args) {
        SpringApplication.run(SubirFicheros.class, args);
    }
}
