package com.jorgerubira.explicaciones.D20210831;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.RandomAccess;

public class EjemploPaths {
    public static void main(String[] args) {
        
        Path p=Path.of("c:\\directo\\.\\d6\\..\\d2\\..\\d3\\d4\\..\\d5");
        Path p2=p.normalize().toAbsolutePath();
        Path p3=Path.of("c:\\directo\\.\\d5\\..\\d3\\..\\d2\\d1\\..\\d5\\fichero.txt");
        Path p4=p.relativize(p3);
        System.out.println(p2);
        
        Path pOrigen=Path.of("c:\\a\\b");
        Path pDestino=Path.of("c:\\a\\c\\text.txt");
        //..\c\text.txt
        Path pRel=pOrigen.relativize(pDestino);
        System.out.println(pRel);

        List<Integer> lista=List.of(2,3,4,5);
        
        
        //RandomAccess ra=new RandomAccess();
        //Paths.get("c:\\");
        //4134224225346
        
    }
}
