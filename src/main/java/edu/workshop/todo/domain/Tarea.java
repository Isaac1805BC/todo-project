package edu.workshop.todo.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import jakarta.annotation.Priority;

public class Tarea {
    private String name;
    private String description;
    private LocalDateTime creationDate;
    private LocalDateTime dueDate;
    private boolean state = false; 
    private List<SubTarea> subTasks = new ArrayList<>();

    public Tarea(String name, String description, LocalDateTime creationDate, LocalDateTime dueDate) {
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        this.state = false;
    }

    public void modifyTask(String name, String description, LocalDateTime dueDate, Boolean state, Priority priority) {
        Optional.ofNullable(name).ifPresent(n -> this.name = n);
        Optional.ofNullable(description).ifPresent(d -> this.description = d);
        Optional.ofNullable(dueDate).ifPresent(dd -> this.dueDate = dd);
        Optional.ofNullable(state).ifPresent(s -> this.state = s);
        // Si agregas el atributo priority, puedes hacer lo mismo:
        // Optional.ofNullable(priority).ifPresent(p -> this.priority = p);
    }

    public void addSubTask(SubTarea subTask) {
        subTasks.add(subTask);
    }

    public void removeSubTask(SubTarea subTask) {
        subTasks.remove(subTask);
    }

    public List<String> getSubTareas() {
        List<String> subTaskNames = new ArrayList<>();
        for (SubTarea subTask : subTasks) {
            subTaskNames.add(subTask.getNombre());
        }
        return subTaskNames;

    }
}
