package edu.workshop.todo.domain;

import java.time.LocalDate;
import java.util.Optional;

public class SubTarea extends Tarea {
    private String nombre;
    private LocalDate fecha;
    private Boolean estado;

    public SubTarea(String nombre, String descripcion, LocalDate fecha, Boolean estado) {
        super(nombre, descripcion, fecha.atStartOfDay(), null); // Ajusta según el constructor de Tarea
        this.nombre = nombre;
        this.fecha = fecha;
        this.estado = estado;
    }

    public void modificarSubTarea(String nombre, String descripcion, LocalDate fecha, Boolean estado) {
        Optional.ofNullable(nombre).ifPresent(n -> this.nombre = n);
        Optional.ofNullable(fecha).ifPresent(f -> this.fecha = f);
        Optional.ofNullable(estado).ifPresent(e -> this.estado = e);
        // Si quieres modificar también los atributos de Tarea:
        super.modifyTask(nombre, descripcion, fecha != null ? fecha.atStartOfDay() : null, estado, null);
    }

    public String getNombre() {
        return nombre;
    }

}
