package com.Practica.pruebaapisql.exceptions;

public class EmptyUserException extends RuntimeException {
    public EmptyUserException() {
        super("No hay usuarios en el sistema");
    }
}
