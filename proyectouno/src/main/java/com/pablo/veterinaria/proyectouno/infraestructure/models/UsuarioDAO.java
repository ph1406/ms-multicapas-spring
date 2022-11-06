package com.pablo.veterinaria.proyectouno.infraestructure.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="usuario")
public class UsuarioDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    @Column(nullable = false)
    public String nombreCompleto;

    @Column(nullable = false)
    public String telefono;

    @Column(nullable = false)
    public String mail;

    @Column(nullable = false)
    public boolean estado;

    @OneToMany(mappedBy = "dueno")
    @JsonIgnore
    @ToString.Exclude
    private List<MascotaDAO> mascotas;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
