package com.pablo.veterinaria.proyectotres.domain.exceptions;

public class PetMultiVetException extends  Exception{

    private static final long serialVersionUID=-5546711432324682L;

    private String message;
    private Object[] args;
    public PetMultiVetException(String mje)
    {
        this.message = mje;
    }

    public PetMultiVetException(String message, Object[] args)
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
