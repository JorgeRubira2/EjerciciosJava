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
    
    @Override
    public void crearTarea(String descripcion, Integer horasEstimacion) {
        //codigo;descripcion;propietario; horasEstimacion;horasTrabajadas;estado;        
        //UUID.randomUUID().toString(),descripcion,null, horasEstimacion,0,"Roadmap"    
        
        TareaKanban tareas = new TareaKanban();
        
        tareas.setCodigo(UUID.randomUUID().toString());
        tareas.setDescripcion(descripcion);
        tareas.setPropietario(null);
        tareas.setHorasEstimacion(horasEstimacion);
        tareas.setHorasTrabajadas(0);
        tareas.setEstado("Roadmap");
    }

    @Override
    public void modificarTarea(String codigo, String descripcion, Integer horasEstamacion) throws OperacionEnListaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cambiarEstado(String codigo, String persona) throws OperacionEnListaException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TareaKanban> getTareas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<TareaKanban> getTarea(String codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
