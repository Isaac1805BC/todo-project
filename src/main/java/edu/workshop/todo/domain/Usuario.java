package edu.workshop.todo.domain;

import java.util.ArrayList;

public class Usuario {
    private String correoElectronico;
    private String contraseña;
    private String Nombre;
    private ArrayList<GrupoDeListas> grupoDeListas;
    private Calendario  calendario;
    private Estadistica estadistica;
    private TemporizadorPomodoro temporizadorPomodoro;
    private ArrayList<Notificacion> notificaciones;
    private Historial historial;
    private ArrayList<ListaDeTareas> listaDeTareas; 

    public Usuario(String newCorreoElectronico,String newContraseña,String newNombre,Calendario newCalendario,Estadistica newEstadistica, TemporizadorPomodoro newTemporizadorPomodoro, Historial newHistorial ){
        correoElectronico = newCorreoElectronico;
        contraseña = newContraseña;
        Nombre = newNombre; 
        calendario = newCalendario;
        estadistica = newEstadistica;
        temporizadorPomodoro = newTemporizadorPomodoro;
        historial = newHistorial;
        grupoDeListas = new ArrayList<>();
        notificaciones = new ArrayList<>();
        listaDeTareas = new ArrayList<>();
    }
    
    public void crearLista(){

    }
}