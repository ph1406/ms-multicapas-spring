package com.pablo.veterinaria.proyectouno.application.domain.exception;

public class DuenoNoExisteException extends Exception {

    private static final long serialVersionUID=-2346032644682L;

    private String message;
    private Object[] args;
    public DuenoNoExisteException(String message)
    {
        this.message = message;
    }

    public DuenoNoExisteException(String message, Object[] args)
    {
        this.message = message;
        this.args=args;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
