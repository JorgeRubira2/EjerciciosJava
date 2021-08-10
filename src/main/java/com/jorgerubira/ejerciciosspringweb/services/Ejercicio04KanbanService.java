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

    private List<TareaKanban> lista = new ArrayList<>();

    @Override
    public void crearTarea(String descripcion, Integer horasEstimacion) {

        TareaKanban tarea = new TareaKanban(UUID.randomUUID().toString(), descripcion, null, horasEstimacion, 0, "Roadmap");
        lista.add(tarea);

    }

    @Override
    public void modificarTarea(String codigo, String descripcion, Integer horasEstamacion) throws OperacionEnListaException {

        Optional<TareaKanban> tarea = lista.stream().filter(x -> codigo.equals(x.getCodigo())).findFirst();
        if (tarea.isPresent()) {
            tarea.get().setDescripcion(descripcion);
            tarea.get().setHorasEstimacion(horasEstamacion);

        }

    }

    @Override
    public void asignarPersona(String codigo, String persona) throws OperacionEnListaException {

        Optional<TareaKanban> tarea = lista.stream().filter(x -> codigo.equals(x.getCodigo())).findFirst();
        if (tarea.isPresent()) {
            tarea.get().setPropietario(persona);

        }

    }

    @Override
    public void cambiarEstado(String codigo, String estado) throws OperacionEnListaException {

        Optional<TareaKanban> tarea = lista.stream().filter(x -> x.getCodigo().equals(codigo)).findFirst();
        if (tarea.isPresent()) {
            tarea.get().setEstado(estado);

        }

    }

    @Override
    public List<TareaKanban> getTareas() {
        return lista;

    }

    @Override
    public Optional<TareaKanban> getTarea(String codigo) {

        Optional<TareaKanban> tarea = lista.stream().filter(x -> x.getCodigo().equals(codigo)).findFirst();
        if (tarea.isPresent()) {
            return tarea;
        }
        return null;
    }

    @Override
    public void imputarHorasTrabajadas(String codigo, int horas) throws OperacionEnListaException {
        Optional<TareaKanban> tarea = lista.stream().filter(x -> x.getCodigo().equals(codigo)).findFirst();
        if (tarea.isPresent()) {
            int horasTrabajadas = tarea.get().getHorasTrabajadas();
            tarea.get().setHorasTrabajadas(horas + horasTrabajadas);
        }

    }
}
