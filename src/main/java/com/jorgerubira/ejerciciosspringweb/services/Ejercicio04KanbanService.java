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
    
    private List<TareaKanban> listaTareas = new ArrayList<>();

    public Ejercicio04KanbanService() {
        crearTarea("Desc 1", 5);
        crearTarea("Desc 2", 10);
        crearTarea("Desc 3", 15);
        crearTarea("Desc 4", 20);
        
        listaTareas.get(0).setEstado("Working");
    }  
    
    @Override
    public void crearTarea(String descripcion, Integer horasEstimacion) {
        //codigo;descripcion;propietario; horasEstimacion;horasTrabajadas;estado;        
        //UUID.randomUUID().toString(),descripcion,null, horasEstimacion,0,"Roadmap"    
        
        listaTareas.add(new TareaKanban(UUID.randomUUID().toString(), descripcion, null, horasEstimacion, 0, "Roadmap"));
    }

    @Override
    public void modificarTarea(String codigo, String descripcion, Integer horasEstamacion) throws OperacionEnListaException {
        Optional<TareaKanban> tarea = this.getTarea(codigo);
        if (tarea.isPresent()){
            listaTareas.removeIf(x->codigo.equals(x.getCodigo()));
            tarea.get().setDescripcion(descripcion);
            tarea.get().setHorasEstimacion(horasEstamacion);
            listaTareas.add(tarea.get());
        } else {
            throw new OperacionEnListaException(codigo);
        }
    }

    @Override
    public void asignarPersona(String codigo, String persona) throws OperacionEnListaException {
        Optional<TareaKanban> opTareas = getTarea(codigo);
        
        if (opTareas.isPresent()) {
            TareaKanban tarea = opTareas.get();
            tarea.setPropietario(persona);
            
        }
        
    }

    @Override
    public void imputarHorasTrabajadas(String codigo, int horas) throws OperacionEnListaException {
        Optional<TareaKanban> opTareas = getTarea(codigo);
        
        if (opTareas.isPresent()) {
            TareaKanban tarea = opTareas.get();
            tarea.setHorasTrabajadas(horas);   
        }
    }

    @Override
    public void cambiarEstado(String codigo, String estado) throws OperacionEnListaException {
        Optional<TareaKanban> opTareas = getTarea(codigo);
        TareaKanban tarea = opTareas.get();
        tarea.setEstado(estado);
    }

    @Override
    public List<TareaKanban> getTareas() {
        return listaTareas;
    }

    @Override
    public Optional<TareaKanban> getTarea(String codigo) {
        return listaTareas.stream()
                .filter(x->x.getCodigo().equalsIgnoreCase(codigo))
                .findFirst();
    }
    
}
