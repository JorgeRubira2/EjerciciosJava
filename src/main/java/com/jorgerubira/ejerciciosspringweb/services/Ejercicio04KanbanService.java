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
    
    private List<TareaKanban> listaTareas = new ArrayList<TareaKanban>();
    
    public static enum Estados {
            ROADMAP("Roadmap"),WAITING("Waiting"), WORKING("Working"),DONE ("Done");
            private String estado;
            private Estados (String s){ estado=s;}
            public String getEstado( ){ return this.estado;}
        }
    
    

            
    @Override
    public void crearTarea(String descripcion, Integer horasEstimacion) {
        TareaKanban tarea = new TareaKanban();
        
        tarea.setCodigo(UUID.randomUUID().toString());
        tarea.setEstado(Ejercicio04KanbanService.Estados.ROADMAP.getEstado()); //estaria mejor en TareaKanban
        tarea.setDescripcion(descripcion);
        tarea.setHorasEstimacion(horasEstimacion);
        tarea.setHorasTrabajadas(0);
        tarea.setPropietario(null);
        
        listaTareas.add(tarea);
    }

    @Override
    public void modificarTarea(String codigo, String descripcion, Integer horasEstamacion) throws OperacionEnListaException {
        Optional<TareaKanban> tarea = this.getTarea(codigo);
        
        if (tarea.isPresent()){
            int indice = listaTareas.indexOf(tarea.get());
            TareaKanban auxTarea = tarea.get();
            auxTarea.setDescripcion(descripcion);
            auxTarea.setHorasEstimacion(horasEstamacion);
            listaTareas.remove(tarea.get());
            listaTareas.add(indice,auxTarea);
        } else {
            throw new OperacionEnListaException(codigo);
        }
        
        
    }

    @Override
    public void asignarPersona(String codigo, String persona) throws OperacionEnListaException {
        Optional<TareaKanban> tarea = this.getTarea(codigo);
        
        if (tarea.isPresent()){
            int indice = listaTareas.indexOf(tarea.get());
            TareaKanban auxTarea = tarea.get();
            auxTarea.setPropietario(persona);
            listaTareas.remove(tarea.get());
            listaTareas.add(indice,auxTarea);
            
        } else {
            throw new OperacionEnListaException(codigo);
        }
        
        
    }

    @Override
    public void imputarHorasTrabajadas(String codigo, int horasTrabajadas) throws OperacionEnListaException {
        Optional<TareaKanban> tarea = this.getTarea(codigo);
        
        if (tarea.isPresent()){
            int indice = listaTareas.indexOf(tarea.get());
            TareaKanban auxTarea = tarea.get();
            auxTarea.setHorasTrabajadas(auxTarea.getHorasTrabajadas() + horasTrabajadas );
            listaTareas.remove(tarea.get());
            listaTareas.add(indice,auxTarea);
            
        } else {
            throw new OperacionEnListaException(codigo);
        }
    }

    @Override
    public void cambiarEstado(String codigo, String estado) throws OperacionEnListaException {
        Optional<TareaKanban> tarea = this.getTarea(codigo);
        
        if (tarea.isPresent()){
            int indice = listaTareas.indexOf(tarea.get());
            TareaKanban auxTarea = tarea.get();
            auxTarea.setEstado(estado);
            listaTareas.remove(tarea.get());
            listaTareas.add(indice,auxTarea);
            
        } else {
            throw new OperacionEnListaException(codigo);
        }
    }

    @Override
    public List<TareaKanban> getTareas() {
        return listaTareas;
    }

    @Override
    public Optional<TareaKanban> getTarea(String codigo) {
        return   listaTareas.stream()
                .filter(x -> x.getCodigo().equals(codigo))
                .findFirst();
    }
    
}