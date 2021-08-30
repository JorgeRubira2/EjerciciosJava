package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.domain.TareaKanban;
import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio04KanbanService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


/**
 * Implementa la interface IEjercicio04KanbanService
 */
@Service
public class Ejercicio04KanbanService implements IEjercicio04KanbanService {

//    private List<TareaKanban> tareas = new ArrayList<>();

    private List<TareaKanban> tareas = List.of(
            new TareaKanban(UUID.randomUUID().toString(),"Tarea 1",null, 0, 0, "Roadmap"),
            new TareaKanban(UUID.randomUUID().toString(),"Tarea 2",null, 0, 0, "Waiting"),
            new TareaKanban(UUID.randomUUID().toString(),"Tarea 3",null, 0, 0, "Working"),
            new TareaKanban(UUID.randomUUID().toString(),"Tarea 4",null, 0, 0, "Waiting"),
            new TareaKanban(UUID.randomUUID().toString(),"Tarea 5",null, 0, 0, "Done"),
            new TareaKanban(UUID.randomUUID().toString(),"Tarea 6",null, 0, 0, "Roadmap"),
            new TareaKanban(UUID.randomUUID().toString(),"Tarea 7",null, 0, 0, "Done"),
            new TareaKanban(UUID.randomUUID().toString(),"Tarea 8",null, 0, 0, "Working"),
            new TareaKanban(UUID.randomUUID().toString(),"Tarea 9",null, 0, 0, "Waiting"),
            new TareaKanban(UUID.randomUUID().toString(),"Tarea 10",null, 0, 0, "Roadmap"));

    @Override
    public void crearTarea(String descripcion, Integer horasEstimacion) {
        TareaKanban tarea = new TareaKanban();
        tarea.setCodigo(UUID.randomUUID().toString());
        tarea.setEstado("Roadmap");
        tarea.setDescripcion(descripcion);
        tarea.setHorasEstimacion(horasEstimacion);
        tarea.setHorasTrabajadas(0);
        tarea.setPropietario(null);
        tareas.add(tarea);
        //        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void modificarTarea(String codigo, String descripcion, Integer horasEstamacion) throws OperacionEnListaException {
        Optional<TareaKanban> optionalTarea = getTarea(codigo);
        if(optionalTarea.isPresent()){
            TareaKanban tarea = optionalTarea.get();
            tarea.setDescripcion(descripcion);
            tarea.setHorasEstimacion(horasEstamacion);
        }
    }

    @Override
    public void asignarPersona(String codigo, String persona) throws OperacionEnListaException {
        Optional<TareaKanban> optionalTarea = getTarea(codigo);
        if(optionalTarea.isPresent()){
            TareaKanban tarea = optionalTarea.get();
            tarea.setPropietario(persona);
        }
    }

    @Override
    public void imputarHorasTrabajadas(String codigo, int horas) throws OperacionEnListaException {
        Optional<TareaKanban> optionalTarea = getTarea(codigo);
        if(optionalTarea.isPresent()){
            TareaKanban tarea = optionalTarea.get();
            tarea.setHorasTrabajadas(tarea.getHorasTrabajadas()+horas);
        }
    }

    @Override
    public void cambiarEstado(String codigo, String estado) throws OperacionEnListaException {
        Optional<TareaKanban> optionalTarea = getTarea(codigo);
        if(optionalTarea.isPresent()){
            TareaKanban tarea = optionalTarea.get();
            tarea.setEstado(estado);
        }
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
