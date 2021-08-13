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

/**
 * public class TareaKanban {
 *
 * private String codigo; //Se generará al azar al insertar.
 * UUID.randomUUID().toString(); private String descripcion; //Descripcion de la
 * tarea private String propietario; //Persona que está realizando esta tarea.
 * private Integer horasEstimacion; //Tiempo estimado en la tarea. Opcional
 * private Integer horasTrabajadas; //Tiempo de trabajo en la tarea. private
 * String estado; //Roadmap (Pensada), Waiting (Se hace en breve), Working
 * (Realizandose), Done (Finalizada).  *
 * }
 */
@Service
public class Ejercicio04KanbanService implements IEjercicio04KanbanService {

    private List<TareaKanban> listaTareaKanban = new ArrayList<>();

    @Override
    public void crearTarea(String descripcion, Integer horasEstimacion) {
        /**
         * Inserta una tarea nueva en la lista 
         * El campo codigo se obtendrá al azar.
         * El estado por defecto es Roadmap. 
         * El numero de hora trabajadas por defecto es 0.
         * La persona por defecto es null.
         */

        listaTareaKanban.add(new TareaKanban(UUID.randomUUID().toString(), descripcion, null, horasEstimacion, 0, "Roadmap"));

    }

    @Override
    public void modificarTarea(String codigo, String descripcion, Integer horasEstamacion) throws OperacionEnListaException {
        /**
         * Modifica la tarea de la misma que tenga el código introducido.
         * Devuelve una excepción si el código no encuentra la tarea
         */

        Optional<TareaKanban> modificar = listaTareaKanban.stream()
                .filter(t -> t.getCodigo().equals(codigo))
                .findFirst();

        if (modificar.isPresent()) {
            modificar.get().setDescripcion(descripcion);
            modificar.get().setHorasEstimacion(horasEstamacion);
        } else {
            throw new OperacionEnListaException(codigo);
        }

    }

    @Override
    public void asignarPersona(String codigo, String persona) throws OperacionEnListaException {
        /**
         * Asigna una persona a la tarea del codigo introducido Devuelve una
         * excepción si el código no encuentra la tarea
         */
        Optional<TareaKanban> asignarPers = listaTareaKanban.stream()
                .filter(t -> t.getCodigo().equals(codigo))
                .findFirst();

        if (asignarPers.isPresent()) {
            asignarPers.get().setPropietario(persona);
        } else {
            throw new OperacionEnListaException(codigo);
        }

    }

    @Override
    public void imputarHorasTrabajadas(String codigo, int horas) throws OperacionEnListaException {
        /**
         * Incrementa el tiempo trabajado en la tarea del codigo introducido.
         * Devuelve una excepción si el código no encuentra la tarea
         */
        Optional<TareaKanban> imputarHoras = listaTareaKanban.stream()
                .filter(t -> t.getCodigo().equals(codigo))
                .findFirst();

        if (imputarHoras.isPresent()) {
            imputarHoras.get().setHorasTrabajadas(horas);
        } else {
            throw new OperacionEnListaException(codigo);
        }

    }

    @Override
    public void cambiarEstado(String codigo, String persona) throws OperacionEnListaException {
        /**
         * Cambiar de estado de la tarea del codigo introducido. Devuelve una
         * excepción si el código no encuentra la tarea
         */

        Optional<TareaKanban> estado = listaTareaKanban.stream()
                .filter(t -> t.getCodigo().equals(codigo))
                .findFirst();

        if (estado.isPresent()) {
            estado.get().setEstado(persona);
        } else {
            throw new OperacionEnListaException(codigo);
        }
    }

    @Override
    public List<TareaKanban> getTareas() {
        return listaTareaKanban;
    }

    @Override
    public Optional<TareaKanban> getTarea(String codigo) {
        return listaTareaKanban.stream()
                .filter(TareaKanban -> codigo == TareaKanban.getCodigo())
                .findFirst();
    }

}
