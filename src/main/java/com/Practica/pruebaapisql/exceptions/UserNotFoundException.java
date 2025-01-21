package com.Practica.pruebaapisql.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("No se encontro el empleado con la ID: " + id);
    }
}
