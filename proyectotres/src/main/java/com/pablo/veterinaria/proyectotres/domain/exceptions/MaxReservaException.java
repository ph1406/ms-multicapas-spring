package com.pablo.veterinaria.proyectotres.domain.exceptions;

public class MaxReservaException extends Exception{
    private static final long serialVersionUID=-234601264324682L;

    private String message;
    private Object[] args;
    public MaxReservaException(String mje)
    {
        this.message = mje;
    }

    public MaxReservaException(String message, Object[] args)
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
