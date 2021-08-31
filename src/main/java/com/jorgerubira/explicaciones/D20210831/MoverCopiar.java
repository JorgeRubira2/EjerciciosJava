package com.jorgerubira.explicaciones.D20210831;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;


public class MoverCopiar {
    public static void main(String[] args) {
        try{
            Files.copy(Paths.get("c:\\origen\\fichero.txt"), Paths.get("c:\\destino"), StandardCopyOption.REPLACE_EXISTING);
            Files.move(Paths.get("c:\\origen\\fichero.txt"), Paths.get("c:\\destino"), StandardCopyOption.REPLACE_EXISTING);
            Files.delete(Paths.get("c:\\origen\\fichero.txt"));
        }catch(Exception e){
        }
        
    }
}
