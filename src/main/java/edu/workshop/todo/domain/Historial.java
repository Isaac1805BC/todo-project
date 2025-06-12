package edu.workshop.todo.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Historial {
    
    private LocalDateTime fechaCreacion;
    private ArrayList<Tarea> tareas= new ArrayList<>();

    public Historial() {
        this.fechaCreacion = LocalDateTime.now();
    }

    public void agregarTarea(Tarea tarea) {
        tareas.add(tarea);
    }
}
