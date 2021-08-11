package com.jorgerubira.ejerciciosspringweb.services;

import com.jorgerubira.ejerciciosspringweb.domain.TareaKanban;
import com.jorgerubira.ejerciciosspringweb.exceptions.OperacionEnListaException;
import com.jorgerubira.ejerciciosspringweb.interfaces.IEjercicio04KanbanService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collector;
import org.springframework.beans.factory.annotation.Autowired;
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

    //*********************************NO PASA EL TEST****************************//
    @Override
    public void modificarTarea(String codigo, String descripcion, Integer horasEstamacion) throws OperacionEnListaException {
        Optional<TareaKanban> tareaOptional = getTarea(codigo);

        if (tareaOptional.isPresent()) {
            TareaKanban tareaKanban = new TareaKanban();
            tareaKanban.setDescripcion(descripcion);
            tareaKanban.setHorasEstimacion(horasEstamacion);
            
            listaKanbans.add(tareaKanban);
        }else{
            throw new OperacionEnListaException(codigo);
        }
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
        return listaKanbans;
    }

    @Override
    public Optional<TareaKanban> getTarea(String codigo) {
        return listaKanbans.stream()
                .filter(x -> x.getCodigo().equals(codigo))
                .findFirst();
    }
}
