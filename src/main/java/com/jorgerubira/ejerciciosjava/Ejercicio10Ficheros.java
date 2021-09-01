package com.jorgerubira.ejerciciosjava;

import com.jorgerubira.ejerciciosjava.excepciones.FormatoNoValidoException;
import com.jorgerubira.ejerciciosjava.pojo.Persona;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ejercicio10Ficheros {

    private final String rutaBase = "C:\\Users\\Jesus\\Documents\\NetBeansProjects\\EjerciciosJava\\src\\main\\java\\com\\jorgerubira\\resources\\";

    /**
     * Abre el fichero recibido y cuenta cuantos eventos hay. Se considera un
     * evento si tiene una linea con información. La primera línea es la
     * cabecera y esta no se debe contar. Puede haber líneas vacias, estas
     * tampoco no se deben contar. Si el fichero no existe devolver 0.
     * Importante. Cerrar el fichero al acabar. Pistas: Cargar el fichero
     * utilizar el método readAllLines y pasarlo por un stream. Ejemplo del
     * fichero:
     */
    public int contarCuantosEventosHay() {
        String fichero = "AgendaDeDeportes.csv";
        List<String> lineas = new ArrayList<>();
        String ruta = rutaBase + fichero;
        System.out.println(ruta);

        try {
            lineas = Files.readAllLines(Paths.get(ruta), Charset.forName("ISO-8859-1"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lineas.size() - 1;
    }

    /**
     * Devuelve del ID del evento llamado 'Camino a Mercedes' del fichero
     * enviado por parámetro Esta información está en un csv. El formato del
     * fichero se puede ver en el fichero
     * com.jorgerubira.resources.AgendaDeDeportes.csv Si estuviese ese evento o
     * no encuentra el fichero devolver null. Pistas: Cargar el fichero utilizar
     * el método readAllLines y pasarlo por un stream.
     */
    public String buscarId() {
        String fichero = "AgendaDeDeportes.csv";
        List<String> lineas = new ArrayList<>();
        String ruta = rutaBase + fichero;
        try {
            lineas = Files.readAllLines(Paths.get(ruta), Charset.forName("ISO-8859-1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Optional<String> aux = lineas.stream().filter(x -> x.contains("Camino a Mercedes")).findFirst();
        String[] resultado = aux.get().split(";");
        return resultado[0];
    }

    /**
     * Cuantas cuantas veces aparece una palabra (o texto) en el fichero
     * solicitado. Deberá ser insensible a mayusculas y minusculas Si estuviese
     * ese evento o no encuentra el fichero devolver 0. Pista facil: Cargar el
     * fichero utilizar el método readAllText y pasarlo hacer un split. Pista
     * más eficiente: En vez de utilizar split ir buscando con indexOf. Solución
     * más compleja con while.
     */
    public int contarCoincidencias(String fichero, String palabra) {
        String aux = "";
        try {
            aux = Files.readString(Paths.get(rutaBase + fichero), Charset.forName("ISO-8859-1"));
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio10Ficheros.class.getName()).log(Level.SEVERE, null, ex);
        }
        String resultado[] = aux.split(palabra);
        return resultado.length;
    }

    /**
     * Verifica el fichero y si tiene alguna línea no valida lanza una excepción
     * FormatoNoValidoException. Si el fichero no se encuentra lanzará un
     * FileNotFoundException.
     */
    public void verificarFormato(File fichero) throws FormatoNoValidoException, FileNotFoundException {
        //No hacer aún
        throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Recibe un fichero que tiene cada linea tiene el formato "Nombre;Nota"
     * como por ejemplo "Ana;8.3" Se pide devolver el promedio de notas de los
     * alumnos. El fichero no tiene cabecera. Descartar las líneas que estén en
     * blanco. Si el fichero no se encuentra devolver Empty.
     */
    public Optional<Double> calcularPromedio() {
        String fichero = "Evaluaciones.csv";
        List<String> lineas = new ArrayList<>();
        List<Double> media = new ArrayList<>();
        Optional<Double> result = Optional.ofNullable(null);
        String ruta = rutaBase + fichero;
        File file = new File(ruta);
        if (file.exists()) {
            try {
                lineas = Files.readAllLines(Paths.get(ruta), Charset.forName("ISO-8859-1"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            return result;
        }

        throw new RuntimeException("Pendiente de hacer");
    }

    /**
     * Realiza una lectura de un csv que tiene el formato "Nombre;Ciudad" como
     * por ejemplo "Ana;Zaragoza" y devuelve una lista de personas con los
     * elementos que hay en el fichero. El fichero tiene cabecera que habrá que
     * descartar. Descartar las líneas que estén en blanco. Si el fichero no
     * lanzar una FileNotFoundException.
     */
    public List<Persona> cargarPersona() throws FileNotFoundException {
        String fichero = "ListaPersonas.txt";
        throw new RuntimeException("Pendiente de hacer");
    }

}
