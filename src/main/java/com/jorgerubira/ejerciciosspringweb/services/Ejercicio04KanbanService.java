package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.domain.TareaKanban;
import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio04KanbanService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


/**
 * Implementa la interface IEjercicio04KanbanService
 */
public class Ejercicio04KanbanService implements IEjercicio04KanbanService {

    private List<TareaKanban> tareas = new ArrayList<>();

    @Override
    public void crearTarea(String descripcion, Integer horasEstimacion) {
        TareaKanban tarea = new TareaKanban();
        tarea.setCodigo(UUID.randomUUID().toString());
        tarea.setEstado("Planning");
        tarea.setDescripcion(descripcion);
        tarea.setHorasEstimacion(horasEstimacion);
        tarea.setHorasTrabajadas(0);
        tareas.add(tarea);
        //        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarTarea(String codigo, String descripcion, Integer horasEstamacion) throws OperacionEnListaException {
        TareaKanban tarea = tareas.stream()
                .filter(t-> codigo.equals(t.getCodigo()))
                .findFirst().get();

        tarea.setDescripcion(descripcion);
        tarea.setHorasEstimacion(horasEstamacion);
    }

    @Override
    public void asignarPersona(String codigo, String persona) throws OperacionEnListaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void imputarHorasTrabajadas(String codigo, int horas) throws OperacionEnListaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cambiarEstado(String codigo, String persona) throws OperacionEnListaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TareaKanban> getTareas() {
        return tareas;
    }

    @Override
    public Optional<TareaKanban> getTarea(String codigo) {
        return tareas.stream()
                        .filter(t-> codigo.equals(t.getCodigo()))
                        .findFirst();
    }
    
}
