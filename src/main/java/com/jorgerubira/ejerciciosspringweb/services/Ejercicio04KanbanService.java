package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.domain.TareaKanban;
import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio04KanbanService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;


/**
 * Implementa la interface IEjercicio04KanbanService
 */
@Service
public class Ejercicio04KanbanService implements IEjercicio04KanbanService {
        List<TareaKanban> tareas=new ArrayList<>();
        
    public String codigoAzar(){
        return UUID.randomUUID().toString();
    }

    @Override
    public void crearTarea(String descripcion, Integer horasEstimacion) {
        TareaKanban nuevo=new TareaKanban(codigoAzar(),descripcion,null,horasEstimacion,0,"Roadmap");
        tareas.add(nuevo);
    }

    @Override
    public void modificarTarea(String codigo, String descripcion, Integer horasEstamacion) throws OperacionEnListaException {
        if(getTarea(codigo).isPresent()){
            tareas.forEach(x->
                            {if(x.getCodigo().equals(codigo)){
                                x.setDescripcion(descripcion);
                                x.setHorasEstimacion(horasEstamacion);
                                }
                            });
        }
        
    }

    @Override
    public void asignarPersona(String codigo, String persona) throws OperacionEnListaException {
        if(getTarea(codigo).isPresent()){
            tareas.forEach(x->
                            {if(x.getCodigo().equals(codigo)){
                                x.setPropietario(persona);                   
                                }
                            });
        }
    }

    @Override
    public void imputarHorasTrabajadas(String codigo, int horas) throws OperacionEnListaException {
        if(getTarea(codigo).isPresent()){
            tareas.forEach(x->
                            {if(x.getCodigo().equals(codigo)){
                                x.setHorasTrabajadas(horas+x.getHorasTrabajadas());                   
                                }
                            });
        }
    }

    @Override
    public void cambiarEstado(String codigo, String persona) throws OperacionEnListaException {
        if(getTarea(codigo).isPresent()){
            tareas.forEach(x->
                            {if(x.getCodigo().equals(codigo)){
                                x.setEstado(persona);                   
                                }
                            });
        }
    }

    @Override
    public List<TareaKanban> getTareas() {
        return tareas;
    }

    @Override
    public Optional<TareaKanban> getTarea(String codigo) {
        Optional<TareaKanban> devolver;
        List<TareaKanban>aux=tareas.stream().filter(x->x.getCodigo().equals(codigo)).collect(Collectors.toList());
        if(aux.size()>0){
            devolver=Optional.ofNullable(aux.get(0));
        }
        else{
            devolver=Optional.ofNullable(null);
        }
        return devolver;
        
    }
    
}
