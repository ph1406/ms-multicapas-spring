package com.pablo.veterinaria.proyectotres.domain.exceptions;

public class FechaOcupadaException extends  Exception{
    private static final long serialVersionUID=-2346711164324682L;

    private String message;
    private Object[] args;
    public FechaOcupadaException(String mje)
    {
        this.message = mje;
    }

    public FechaOcupadaException(String message, Object[] args)
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
