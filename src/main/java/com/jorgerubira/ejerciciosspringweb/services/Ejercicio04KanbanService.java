package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.domain.TareaKanban;
import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio04KanbanService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;


/**
 * Implementa la interface IEjercicio04KanbanService
 */
@Service
public class Ejercicio04KanbanService implements IEjercicio04KanbanService {

    private List<TareaKanban> tareas = new ArrayList<>(); 
    /*
    public Ejercicio04KanbanService(){ 
        tareas.add(new TareaKanban("1234Cod", "desc", "yo", 2, 5, "Done"));
    } 
*/
    
    @Override
    public void crearTarea(String descripcion, Integer horasEstimacion) {
        //Es un add que tiene que tener estados concretos (mirar en la clase TareaKanban
        tareas.add(new TareaKanban(UUID.randomUUID().toString(), descripcion, null, horasEstimacion, 0, "Roadmap"));
    }

    @Override
    public void modificarTarea(String codigo, String descripcion, Integer horasEstimacion) throws OperacionEnListaException {
        Optional<TareaKanban> nuevaTarea = tareas.stream().filter(x->x.getCodigo().equals(codigo)).findFirst();
        
        if (nuevaTarea.isPresent()){
            nuevaTarea.get().setDescripcion(descripcion);
            nuevaTarea.get().setHorasEstimacion(horasEstimacion);
        }
            
    }

    @Override
    public void asignarPersona(String codigo, String persona) throws OperacionEnListaException {
       Optional<TareaKanban> nuevaPersona = tareas.stream().filter(x->x.getCodigo().equals(codigo)).findFirst();
        
        if (nuevaPersona.isPresent()){
            nuevaPersona.get().setPropietario(persona);
        }
    }

    @Override
    public void imputarHorasTrabajadas(String codigo, int horas) throws OperacionEnListaException {
        Optional<TareaKanban> horasTrabajadas = tareas.stream().filter(x->x.getCodigo().equals(codigo)).findFirst();
        
        if (horasTrabajadas.isPresent()){
            horasTrabajadas.get().setHorasTrabajadas(horas);
        }
    }

    @Override
    public void cambiarEstado(String codigo, String estado) throws OperacionEnListaException {
        Optional<TareaKanban> nuevoEstado = tareas.stream().filter(x->x.getCodigo().equals(codigo)).findFirst();
        
        if (nuevoEstado.isPresent()){
            nuevoEstado.get().setEstado(estado);
        }
    }

    @Override
    public List<TareaKanban> getTareas() {
        return tareas;
    }

    @Override
    public Optional<TareaKanban> getTarea(String codigo) {
        Optional<TareaKanban> tarea = tareas.stream().filter(x->x.getCodigo().equals(codigo)).findFirst();
        return tarea;
    }
    
}
