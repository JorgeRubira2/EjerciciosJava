//package com.jorgerubira.ejerciciosspringweb.controllers;
//
//import com.jorgerubira.ejerciciosspringweb.entities.Datos;
//import com.jorgerubira.ejerciciosspringweb.repositories.ImportarCSVRepository;
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Path;
//import java.nio.file.StandardCopyOption;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import java.util.stream.Stream;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.multipart.MultipartFile;
//
//@Controller
//@RequestMapping("/ej12")
//public class Ejercicio12ImportarCSV {
//
//    @Autowired(required = false)
//    private ImportarCSVRepository repoImportarCSV;
//    
//    //@Value("${carpetas.recursos.hiberus}")
//    private String rutaRecursos="C:\\zzCursoHiberus";
//
//    @GetMapping("/importarDatos")
//    public String importarDatos(){
//        return "ej12/formulario";
//    }
//    
//    @PostMapping("/tratarDatos")
//    public String tratarDatos(Model m, MultipartFile fichero){ //, HttpServletResponse response){
//        
//        if (fichero.getOriginalFilename().toLowerCase().endsWith(".csv")==false){
//            m.addAttribute("error", "Formato incorrecto");
//            return "ej12/formulario";
//        }
//        
//        String ruta = rutaRecursos + "\\ej12\\" + fichero.getOriginalFilename();
//        File f=new File(ruta);
//        f.getParentFile().mkdirs();
//        
////        try{
////            Files.copy(fichero.getInputStream(), f.toPath(), StandardCopyOption.REPLACE_EXISTING);    
////            Stream<String> lineas = Files.lines(Path.of(ruta));
////            lineas.skip(1)
////                    .parallel()
////                    .filter(x -> x != null)
////                    .filter(x -> "",equals(x) == false)
////                    .map(x -> x.split(";"))
////                    .forEach(x -> { try {
////                                           repoImportarCSV.save(new Datos(null, 
////                                                   Integer.parseInt(x(0)),
////                                                   x(1), 
////                                                   x(2), 
////                                                   x(3), 
////                                                   x(4), 
////                                                   x(5), 
////                                                   Integer.parseInt(x(6)), 
////                                                   Integer.parseInt(x(7)), 
////                                                   Integer.parseInt(x(8)), 
////                                                   Integer.parseInt(x(9)), 
////                                                   new SimpleDateFormat("DD/MM/YYYY").parse(x(10))));
////                                        } catch (ParseException ex) {
////                                            m.addAttribute("error", "Error inesperado");
////                                            Logger logger = Logger.getLogger(Ejercicio12ImportarCSV.class.getName().log(Level.SEVERE, null, ex));
////                                        }
////                    });
//            
////            m.addAttribute("alert", "Fichero subido con éxito");
////        }catch(IOException e){
////            e.printStackTrace();
////            m.addAttribute("error", "Error inesperado");
////        } finally {
////            f.delete();
////        }
//        return "ej12/formulario";
////    }
//}
