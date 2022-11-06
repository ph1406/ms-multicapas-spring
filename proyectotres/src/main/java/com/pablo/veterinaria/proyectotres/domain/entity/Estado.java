package com.pablo.veterinaria.proyectotres.domain.entity;

import org.springframework.hateoas.RepresentationModel;


public class Estado extends RepresentationModel<Estado> {

    private Integer idEstado;
    private String nombreEstado;

    public Integer getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(Integer idEstado) {
        this.idEstado = idEstado;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }
}
