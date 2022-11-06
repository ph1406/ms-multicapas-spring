package com.pablo.veterinaria.proyectouno.infraestructure.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="mascota")
public class MascotaDAO {

    @Id
    public String nombre;

    @Column(nullable = false)
    public String tipoAnimal;

    @Column(nullable = false)
    public String raza;

    @Column(nullable = false)
    public boolean tratamientoActivo;

    @Column(nullable = false)
    public int idUsuario;

    @ManyToOne
    @JoinColumn(name="idUsuario", insertable = false, updatable = false)
    @JsonIgnore
    private UsuarioDAO dueno;


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
