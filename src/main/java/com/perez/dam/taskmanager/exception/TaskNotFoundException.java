package com.perez.dam.taskmanager.exception;


public class TaskNotFoundException extends RuntimeException {

    public TaskNotFoundException(String id) {
        super("No se encontró la tarea con ID: " + id);
    }
}
