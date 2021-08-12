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

    private List<TareaKanban> listaKanbans = new ArrayList<>();

    
    @Override
    public void crearTarea(String descripcion, Integer horasEstimacion) {
        
        TareaKanban tarea = new TareaKanban();

        tarea.setCodigo(UUID.randomUUID().toString());
        tarea.setDescripcion(descripcion);
        tarea.setPropietario(null);
        tarea.setHorasEstimacion(horasEstimacion);
        tarea.setHorasTrabajadas(0);
        tarea.setEstado("Roadmap");

        listaKanbans.add(tarea);
    }
    
    
    @Override
    public void modificarTarea(String codigo, String descripcion, Integer horasEstamacion) throws OperacionEnListaException {

        Optional<TareaKanban> tareaOptional = listaKanbans.stream()
                .filter(x -> x.getCodigo().equals(codigo))
                .findFirst();

        if (tareaOptional.isPresent()) {

            TareaKanban tareaKanban = tareaOptional.get();
            tareaKanban.setDescripcion(descripcion);
            tareaKanban.setHorasEstimacion(horasEstamacion);

            listaKanbans.add(tareaKanban);

        } else {
            throw new OperacionEnListaException(codigo);
        }
    }

    
    @Override
    public void asignarPersona(String codigo, String persona) throws OperacionEnListaException {
        
        Optional<TareaKanban> tareaPersona = listaKanbans.stream()
                .filter(x -> x.getCodigo().equals(codigo))
                .findFirst();

        if (tareaPersona.isPresent()) {

            TareaKanban tareaKanban = tareaPersona.get();
            tareaKanban.setPropietario(persona);

            listaKanbans.add(tareaKanban);
        } else {
            throw new OperacionEnListaException(codigo);
        }
    }

    
    @Override
    public void imputarHorasTrabajadas(String codigo, int horas) throws OperacionEnListaException {
        
        Optional<TareaKanban> horasTrabajadas = listaKanbans.stream()
                .filter(x -> x.getCodigo().equals(codigo))
                .findFirst();

        if (horasTrabajadas.isPresent()) {

            TareaKanban tareaKanban = horasTrabajadas.get();
            tareaKanban.setHorasTrabajadas(tareaKanban.getHorasTrabajadas() + horas);

            listaKanbans.add(tareaKanban);
        } else {
            throw new OperacionEnListaException(codigo);
        }
    }

    
    @Override
    public void cambiarEstado(String codigo, String persona) throws OperacionEnListaException {
        
        Optional<TareaKanban> cambioEstado = listaKanbans.stream()
                .filter(x -> x.getCodigo().equals(codigo))
                .findFirst();

        if (cambioEstado.isPresent()) {

            TareaKanban tareaKanban = cambioEstado.get();
            tareaKanban.setEstado(persona);

            listaKanbans.add(tareaKanban);
            
        } else {
            throw new OperacionEnListaException(codigo);
        }
    }

    
    @Override
    public List<TareaKanban> getTareas() {
        
        return listaKanbans;
    }

    @Override
    public Optional<TareaKanban> getTarea(String codigo) {
        
        return listaKanbans.stream()
                .filter(x -> x.getCodigo().equals(codigo))
                .findFirst();
    }
}
