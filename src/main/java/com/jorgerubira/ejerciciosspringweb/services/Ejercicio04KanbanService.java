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

    @Override
    public void crearTarea(String descripcion, Integer horasEstimacion) {
        String codigo = UUID.randomUUID().toString();
        String propietario  = null;
        Integer horasTrabajadas=0;
        String estado="Roadmap";
        TareaKanban t = new TareaKanban(codigo,descripcion,propietario,horasEstimacion,horasTrabajadas,estado);
        tareas.add(t);
    }

    @Override
    public void modificarTarea(String codigo, String descripcion, Integer horasEstamacion) throws OperacionEnListaException {
        Optional<TareaKanban> t = tareas.stream()
                .filter(x -> x.getCodigo().equals(codigo))
                .findFirst();
        if (t.isPresent()) {
            t.get().setDescripcion(descripcion);
            t.get().setHorasEstimacion(horasEstamacion);
        }
    }

    @Override
    public void asignarPersona(String codigo, String persona) throws OperacionEnListaException {
        Optional<TareaKanban> t = tareas.stream()
                .filter(x -> x.getCodigo().equals(codigo))
                .findFirst();
        if (t.isPresent()) {
           t.get().setPropietario(persona);
        }
    }

    @Override
    public void imputarHorasTrabajadas(String codigo, int horas) throws OperacionEnListaException {
        Optional<TareaKanban> t = tareas.stream()
                .filter(x -> x.getCodigo().equals(codigo))
                .findFirst();
        if(t.isPresent()){
            t.get().setHorasTrabajadas(t.get().getHorasTrabajadas()+horas);
        }
    }

    @Override
    public void cambiarEstado(String codigo, String estado) throws OperacionEnListaException {
        Optional<TareaKanban> t = tareas.stream()
                .filter(x -> x.getCodigo().equals(codigo))
                .findFirst();
         if(t.isPresent()){
            t.get().setEstado(estado);
        }
    }

    @Override
    public List<TareaKanban> getTareas() {
        if (tareas.isEmpty()) {
            return null;
        }
        return tareas;
    }

    @Override
    public Optional<TareaKanban> getTarea(String codigo) {
        Optional<TareaKanban> t = tareas.stream()
                .filter(x -> x.getCodigo().equals(codigo))
                .findFirst();
        return t;
    }

}
