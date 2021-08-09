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

    private List<TareaKanban> tareas = new ArrayList<>();

    @Override
    public void crearTarea(String descripcion, Integer horasEstimacion) {
        tareas.add(new TareaKanban(UUID.randomUUID().toString(), descripcion, null, horasEstimacion, 0, "Roadmap"));
    }

    @Override
    public void modificarTarea(String codigo, String descripcion, Integer horasEstamacion) throws OperacionEnListaException {
        Optional<TareaKanban> tar = this.getTarea(codigo);
        if (tar.isPresent()){
            tareas.removeIf(x->codigo.equals(x.getCodigo()));
            tar.get().setDescripcion(descripcion);
            tar.get().setHorasEstimacion(horasEstamacion);
            tareas.add(tar.get());
        } else {
            throw new OperacionEnListaException(codigo);
        }
    }

    @Override
    public void asignarPersona(String codigo, String persona) throws OperacionEnListaException {
        Optional<TareaKanban> tar = this.getTarea(codigo);
        if (tar.isPresent()){
            tareas.removeIf(x->codigo.equals(x.getCodigo()));
            tar.get().setPropietario(persona);
            tareas.add(tar.get());
        } else {
            throw new OperacionEnListaException(codigo);
        }
    }

    @Override
    public void imputarHorasTrabajadas(String codigo, int horas) throws OperacionEnListaException {
        Optional<TareaKanban> tar = this.getTarea(codigo);
        if (tar.isPresent()){
            tareas.removeIf(x->codigo.equals(x.getCodigo()));
            tar.get().setHorasTrabajadas(tar.get().getHorasTrabajadas()+horas);
            tareas.add(tar.get());
        } else {
            throw new OperacionEnListaException(codigo);
        }
    }

    @Override
    public void cambiarEstado(String codigo, String persona) throws OperacionEnListaException {
        Optional<TareaKanban> tar = this.getTarea(codigo);
        if (tar.isPresent()){
            tareas.removeIf(x->codigo.equals(x.getCodigo()));
            tar.get().setEstado(persona);
            tareas.add(tar.get());
        } else {
            throw new OperacionEnListaException(codigo);
        }
    }

    @Override
    public List<TareaKanban> getTareas() {
        return tareas;
    }

    @Override
    public Optional<TareaKanban> getTarea(String codigo) {
        return tareas.stream()
                .filter(x -> codigo.equals(x.getCodigo()))
                .findFirst();
    }

}
