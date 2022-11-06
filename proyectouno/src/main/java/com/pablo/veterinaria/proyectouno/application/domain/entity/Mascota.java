package com.pablo.veterinaria.proyectouno.application.domain.entity;

import org.springframework.hateoas.RepresentationModel;

public class Mascota extends RepresentationModel<Mascota> {

    public String nombre;
    public String tipoAnimal;
    public String raza;
    public boolean tratamientoActivo;
    public int idUsuario;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoAnimal() {
        return tipoAnimal;
    }

    public void setTipoAnimal(String tipoAnimal) {
        this.tipoAnimal = tipoAnimal;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public boolean isTratamientoActivo() {
        return tratamientoActivo;
    }

    public void setTratamientoActivo(boolean tratamientoActivo) {
        this.tratamientoActivo = tratamientoActivo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}
