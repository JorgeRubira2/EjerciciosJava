/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jorgerubira.ejerciciosspringweb.interfaces;

import com.jorgerubira.ejerciciosspringweb.domain.TareaKanban;
import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import java.util.List;
import java.util.Optional;

/**
 * Gestiona una lista de tareas.
 * Colores:
 *    Si horas estidadas + 1.2 < horas trabajadas -> rojo
 *    Si horas estidadas < horas trabajadas -> naranja
 *    Si horas estidadas >= horas trabajadas -> verde
 */
public interface IEjercicio04KanbanService {
    
    /**
     * Inserta una tarea nueva en la lista
     * El campo codigo se obtendrá al azar. 
     * El estado por defecto es Roadmap.
     * El numero de hora trabajadas por defecto es 0.
     * La persona por defecto es null.
     */
    public void crearTarea(String descripcion, Integer horasEstimacion);
    
    /**
     * Modifica la tarea de la misma que tenga el código introducido.
     * Devuelve una excepción si el código no encuentra la tarea
     */
    public void modificarTarea(String codigo, String descripcion, Integer horasEstimacion) throws OperacionEnListaException;
    
    /**
     * Asigna una persona a la tarea del codigo introducido
     * Devuelve una excepción si el código no encuentra la tarea
     */
    public void asignarPersona(String codigo, String persona) throws OperacionEnListaException;

    /**
     * Incrementa el tiempo trabajado en la tarea del codigo introducido.
     * Devuelve una excepción si el código no encuentra la tarea
     */
    public void imputarHorasTrabajadas(String codigo, int horas) throws OperacionEnListaException;

    /**
     * Cambiar de estado de la tarea del codigo introducido.
     * Devuelve una excepción si el código no encuentra la tarea
     */
    public void cambiarEstado(String codigo, String estado) throws OperacionEnListaException;

    /**
     * Devuelve todas las tareas del tablero
     */
    public List<TareaKanban> getTareas();
    
    /**
     * Devuelve la tarea con el código introducido
     */
    public Optional<TareaKanban> getTarea(String codigo);

}
