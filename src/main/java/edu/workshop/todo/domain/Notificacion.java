package edu.workshop.todo.domain;

import java.time.LocalDateTime;

public class Notificacion {
    private String mensaje;
    private LocalDateTime fechaCreacion;

    public Notificacion(String mensaje) {
        this.mensaje = mensaje;
        this.fechaCreacion = LocalDateTime.now();
    }

    public void enviarMensaje(String mensaje, Usuario usuario){

    }

}
