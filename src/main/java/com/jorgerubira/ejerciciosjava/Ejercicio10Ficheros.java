package main.java.com.jorgerubira.ejerciciosjava;

import com.jorgerubira.ejerciciosjava.excepciones.FormatoNoValidoException;
import com.jorgerubira.ejerciciosjava.pojo.Persona;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Optional;

public class Ejercicio10Ficheros {
    
    /**
     * Abre el fichero recibido y cuenta cuantos eventos hay. 
     * Se considera un evento si tiene una linea con informaci�n.
     * La primera l�nea es la cabecera y esta no se debe contar.
     * Puede haber l�neas vacias, estas tampoco no se deben contar.
     * Si el fichero no existe devolver 0.
     * Importante. Cerrar el fichero al acabar.
     * Pistas: Cargar el fichero utilizar el m�todo readAllLines y pasarlo por un stream.
     * Ejemplo del fichero: 
     */
    public int contarCuantosEventosHay(File fichero){
        throw new RuntimeException("Pendiente de hacer");
    }
    
    /**
     * Devuelve del ID del evento llamado 'Camino a Mercedes' del fichero enviado por par�metro
     * Esta informaci�n est� en un csv. El formato del fichero se puede ver en el fichero com.jorgerubira.resources.AgendaDeDeportes.csv
     * Si estuviese ese evento o no encuentra el fichero devolver null.
     * Pistas: Cargar el fichero utilizar el m�todo readAllLines y pasarlo por un stream.
     */
    public String buscarId(File fichero){
        throw new RuntimeException("Pendiente de hacer");
    }
    
    /**
     * Cuantas cuantas veces aparece una palabra (o texto) en el fichero solicitado.
     * Deber� ser insensible a mayusculas y minusculas
     * Si estuviese ese evento o no encuentra el fichero devolver 0.
     * Pista facil: Cargar el fichero utilizar el m�todo readAllText y pasarlo hacer un split.
     * Pista m�s eficiente: En vez de utilizar split ir buscando con indexOf. Soluci�n m�s compleja con while.
     */
    public int contarCoincidencias(File fichero){
        throw new RuntimeException("Pendiente de hacer");
    }   
    
    /**
     * Verifica el fichero y si tiene alguna l�nea no valida lanza una excepci�n FormatoNoValidoException.
     * Si el fichero no se encuentra lanzar� un FileNotFoundException.
     */
    public void verificarFormato(File fichero) throws  FileNotFoundException {
        throw new RuntimeException("Pendiente de hacer");
    }      

    /**
     * Recibe un fichero que tiene cada linea tiene el formato "Nombre;Nota" como por ejemplo "Ana;8.3"
     * Se pide devolver el promedio de notas de los alumnos.
     * El fichero no tiene cabecera.
     * Descartar las l�neas que est�n en blanco.
     * Si el fichero no se encuentra devolver Empty.
     */
    public Optional<Double> calcularPromedio(File fichero){
        throw new RuntimeException("Pendiente de hacer");
    }    
    
    /**
     * Realiza una lectura de un csv que tiene el formato "Nombre;Ciudad" como por ejemplo "Ana;Zaragoza"
     * y devuelve una lista de personas con los elementos que hay en el fichero.
     * El fichero tiene cabecera que habr� que descartar.
     * Descartar las l�neas que est�n en blanco.
     * Si el fichero no lanzar una FileNotFoundException.
     */
    public List<Persona> cargarPersona(File fichero) throws FileNotFoundException{
        throw new RuntimeException("Pendiente de hacer");
    }      
    

}