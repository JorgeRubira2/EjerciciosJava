package com.jorgerubira.ejerciciosjava;

import com.jorgerubira.ejerciciosjava.excepciones.FormatoNoValidoException;
import com.jorgerubira.ejerciciosjava.pojo.Persona;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Ejercicio10Ficheros {
    
    private final String rutaBase="C:\\Users\\Joche\\Documents\\NetBeansProjects\\EjerciciosJava\\src\\main\\java\\com\\jorgerubira\\resources\\";
    
    /**
     * Abre el fichero recibido y cuenta cuantos eventos hay. 
     * Se considera un evento si tiene una linea con información.
     * La primera línea es la cabecera y esta no se debe contar.
     * Puede haber líneas vacias, estas tampoco no se deben contar.
     * Si el fichero no existe devolver 0.
     * Importante. Cerrar el fichero al acabar.
     * Pistas: Cargar el fichero utilizar el método readAllLines y pasarlo por un stream.
     * Ejemplo del fichero: 
     */
    public int contarCuantosEventosHay(){
        String fichero="AgendaDeDeportes.csv";
        try {
            
            long numEventos = Files.lines(Path.of(rutaBase + fichero), Charset.defaultCharset()).count()-1;
            
             return (int)numEventos;
             
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio10Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        }
       
            return 0;
    }
    
    /**
     * Devuelve del ID del evento llamado 'Camino a Mercedes' del fichero enviado por parámetro
     * Esta información está en un csv. El formato del fichero se puede ver en el fichero com.jorgerubira.resources.AgendaDeDeportes.csv
     * Si estuviese ese evento o no encuentra el fichero devolver null.
     * Pistas: Cargar el fichero utilizar el método readAllLines y pasarlo por un stream.
     */
    public String buscarId(){
        String fichero="AgendaDeDeportes.csv";
        
        try {
            //Texto plano: Stream<String> lines(...), List<String> readAllLines(...), String readString(...)
            List<String> texto = Files.readAllLines(Paths.get(rutaBase + fichero), Charset.defaultCharset());
            String texto2 = texto.stream().filter(x->x.contains("Camino a Mercedes")).findAny().get();
            return texto2.split(";")[0];
            
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio10Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    /**
     * Cuantas cuantas veces aparece una palabra (o texto) en el fichero solicitado.
     * Deberá ser insensible a mayusculas y minusculas
     * Si estuviese ese evento o no encuentra el fichero devolver 0.
     * Pista facil: Cargar el fichero utilizar el método readAllText y pasarlo hacer un split.
     * Pista más eficiente: En vez de utilizar split ir buscando con indexOf. Solución más compleja con while.
     */
    public int contarCoincidencias(String fichero, String palabra){
        try {
            String texto = Files.readString(Paths.get(rutaBase + fichero));
            return texto.split(palabra).length;
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio10Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }   
    
    /**
     * Verifica el fichero y si tiene alguna línea no valida lanza una excepción FormatoNoValidoException.
     * Si el fichero no se encuentra lanzará un FileNotFoundException.
     */
    public void verificarFormato(File fichero) throws FormatoNoValidoException, FileNotFoundException {
        //No hacer aún
        throw new RuntimeException("Pendiente de hacer");
    }      

    /**
     * Recibe un fichero que tiene cada linea tiene el formato "Nombre;Nota" como por ejemplo "Ana;8.3"
     * Se pide devolver el promedio de notas de los alumnos.
     * El fichero no tiene cabecera.
     * Descartar las líneas que estén en blanco.
     * Si el fichero no se encuentra devolver Empty.
     */
    public Optional<Double> calcularPromedio(){
        String fichero = "Evaluaciones.csv";
        List<Double> promedio = new ArrayList<>();
        double result = 0;
        try {
          
            Files.lines(Paths.get(rutaBase + fichero), Charset.defaultCharset()).collect(Collectors.toList()).forEach((t) -> {
             promedio.add(Double.parseDouble(t.split(";")[1]));
          });
            
            for (Double num : promedio) {
                result+=num;
            }
            return Optional.of(result/promedio.size());
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio10Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return Optional.empty();
    }    
    
    /**
     * Realiza una lectura de un csv que tiene el formato "Nombre;Ciudad" como por ejemplo "Ana;Zaragoza"
     * y devuelve una lista de personas con los elementos que hay en el fichero.
     * El fichero tiene cabecera que habrá que descartar.
     * Descartar las líneas que estén en blanco.
     * Si el fichero no lanzar una FileNotFoundException.
     */
    public List<Persona> cargarPersona() throws FileNotFoundException{
        String fichero = "ListaPersonas.txt";
        List<Persona> lista = new ArrayList<>();
        try {
            Files.readAllLines(Paths.get(rutaBase + fichero), Charset.defaultCharset()).stream().skip(1).forEach((t) -> {
                if(!t.isBlank()){
                lista.add(new Persona(t.trim().split(";")[0], t.trim().split(";")[1]));
                }
            });
            
            return lista;
            
            
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio10Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }      
    

}
