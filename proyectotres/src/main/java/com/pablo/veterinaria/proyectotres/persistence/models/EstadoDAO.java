package com.pablo.veterinaria.proyectotres.persistence.models;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="estado")
public class EstadoDAO {

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
