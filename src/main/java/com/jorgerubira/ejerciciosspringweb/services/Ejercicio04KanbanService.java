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
    
     List<TareaKanban> tareas = new ArrayList<>();

    public Ejercicio04KanbanService() {
       /* crearTarea("Descripción de la tarea",29);
        crearTarea("medio1",29);
        crearTarea("medio2",37);
        crearTarea("Adios",44);
        
        tareas.get(0).setEstado("RoadMap");
        tareas.get(1).setEstado("Waiting");
        tareas.get(2).setEstado("Working");
        tareas.get(3).setEstado("Done");
*/
    }
     
     
 
    @Override
    public void crearTarea(String descripcion, Integer horasEstimacion) {
        
        tareas.add(new TareaKanban(UUID.randomUUID().toString(),descripcion,null,horasEstimacion,0,"RoadMap"));
        
    }

    @Override
    public void modificarTarea(String codigo, String descripcion, Integer horasEstamacion) throws OperacionEnListaException {
        
        Optional <TareaKanban> tar= tareas.stream()
                .filter(x->x.getCodigo().equals(codigo))
                .findFirst();
        
        if(tar.isPresent()){
            tar.get()
                    .setDescripcion(descripcion);
            tar.get()
                    .setHorasEstimacion(horasEstamacion);
            
        }
        else{          
            throw new OperacionEnListaException(codigo);
            
        }

        
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void asignarPersona(String codigo, String persona) throws OperacionEnListaException {
        
        
        Optional <TareaKanban> tar= tareas.stream()
                .filter(x->x.getCodigo().equals(codigo))
                .findFirst();
        if(tar.isPresent()){
            tar.get()
                    .setPropietario(persona);
        }else{
            throw new OperacionEnListaException(codigo);
            
        }

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void imputarHorasTrabajadas(String codigo, int horas) throws OperacionEnListaException {
        
        Optional <TareaKanban> tar= tareas.stream()
                .filter(x->x.getCodigo().equals(codigo))
                .findFirst();
        
        
        if(tar.isPresent()){
            tar.get()
                    .setHorasTrabajadas(tar.get().getHorasTrabajadas()+horas);
            
        }else{
            throw new OperacionEnListaException(codigo);
            
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cambiarEstado(String codigo, String persona) throws OperacionEnListaException {
        
        Optional <TareaKanban> tar= tareas.stream()
                .filter(x->x.getCodigo().equals(codigo))
                .findFirst();
        
        if(tar.isPresent()){
            tar.get()
                    .setEstado(persona);
        }
        
        
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TareaKanban> getTareas() {
       
       return tareas;
    }

    @Override
    public Optional<TareaKanban> getTarea(String codigo) {
        
        
        
        return tareas.stream().filter(x->x.getCodigo().equals(codigo))
                .findFirst();
        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
