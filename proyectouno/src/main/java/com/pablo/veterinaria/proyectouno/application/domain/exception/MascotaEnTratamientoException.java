package com.pablo.veterinaria.proyectouno.application.domain.exception;

public class MascotaEnTratamientoException extends Exception{
    private static final long serialVersionUID=-23467822364324682L;

    private String message;
    private Object[] args;
    public MascotaEnTratamientoException(String nombreMascota)
    {
        this.message =  String.format("Mascota ne tratamiento - nombre: %s ", nombreMascota);
    }

    public MascotaEnTratamientoException(String message, Object[] args)
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
