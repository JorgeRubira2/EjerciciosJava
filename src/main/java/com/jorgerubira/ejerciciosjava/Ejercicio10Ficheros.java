package com.jorgerubira.ejerciciosjava;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.jorgerubira.ejerciciosjava.excepciones.FormatoNoValidoException;
import com.jorgerubira.ejerciciosjava.pojo.Persona;

public class Ejercicio10Ficheros {
    
    private final String rutaBase="C:\\Users\\acer\\Documents\\Adrián\\Curso Hiberus\\EjerciciosJava\\src\\main\\java\\com\\jorgerubira\\resources";
    
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
        	long numEventos = Files.lines(Paths.get(rutaBase +"\\" + fichero), Charset.forName("ISO-8859-1")).count() -1;
            return (int) numEventos;
        }catch (Exception e) {
        	return 0;
		}
    }
    
    /**
     * Devuelve del ID del evento llamado 'Camino a Mercedes' del fichero enviado por parámetro
     * Esta información está en un csv. El formato del fichero se puede ver en el fichero com.jorgerubira.resources.AgendaDeDeportes.csv
     * Si estuviese ese evento o no encuentra el fichero devolver null.
     * Pistas: Cargar el fichero utilizar el método readAllLines y pasarlo por un stream.
     */
    public String buscarId(){
        String fichero="AgendaDeDeportes.csv";
        String ruta = rutaBase + "\\" + fichero;
        try{
        	List<String> lineas=Files.lines(Paths.get(ruta), Charset.forName("ISO-8859-1"))
        			.filter(x -> x.contains("Camino a Mercedes"))
        			.collect(Collectors.toList());
        	String resultado[] = lineas.get(0).split(";");
        	return resultado[0];//recupera el primer campo que es el Id
        }catch(Exception e){
        	return null;
        }
    }

    /**
     * Cuantas cuantas veces aparece una palabra (o texto) en el fichero solicitado.
     * Deberá ser insensible a mayusculas y minusculas
     * Si estuviese ese evento o no encuentra el fichero devolver 0.
     * Pista facil: Cargar el fichero utilizar el método readString y pasarlo hacer un split.
     * Pista más eficiente: En vez de utilizar split ir buscando con indexOf. Solución más compleja con while.
     */
    public int contarCoincidencias(String fichero, String palabra){
    	String ruta = rutaBase + "\\" + fichero;
    	try{
    		int contar =0;
    		palabra = palabra.toLowerCase();//paso a minusuclas para comparar
    		String coincidencia=Files.readString(Paths.get(ruta), Charset.forName("ISO-8859-1")).toLowerCase();//lee las palabras y las pasa a minusculas
    		int posicion=coincidencia.indexOf(palabra);
    		while(posicion>=0){
    			contar++;
    			posicion=coincidencia.indexOf(palabra,posicion+1);
    		}
    		return contar;
    	}catch(Exception e){
    		return 0;
    	}
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
    	String ruta = rutaBase + "\\" + fichero;
    	try{
    		OptionalDouble  promedio = Files.lines(Paths.get(ruta), Charset.forName("ISO-8859-1"))
    				.mapToDouble(x->Double.parseDouble(x.split(";")[1]))
    				.average();
    		if(promedio.isPresent())
    			return Optional.of(promedio.getAsDouble());
    		else
    			return Optional.empty();
    	}catch(Exception e){
    		e.printStackTrace();
    		return Optional.empty();
    	}
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
    	String ruta = rutaBase + "\\" + fichero;
    	try{
    		Stream<String> lista=Files.lines(Paths.get(ruta),Charset.forName("ISO-8859-1"));
    		return lista.skip(1)//quita cabecera
    				.filter(x->"".equals(x)==false)//quita las lineas que estan en blanco
    				.map(x->x.split(";"))
    				.map(x->new Persona(x[0],x[1]))// nombre; ciudad
    				.collect(Collectors.toList());
    	}catch(IOException e){
    		e.printStackTrace();
    		return null;
    	}

    }      


}
