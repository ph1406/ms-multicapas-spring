package src.main.java.com.pablo.veterinaria.proyectodos.domain.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.RepresentationModel;

@Document
public class Veterinario  extends RepresentationModel<Veterinario> {

    @Id
    private String id;
    private String licenciaProfecional;
    private String nombreCompleto;
    private String telefono;
    private String especialidad;
    private String horarioAtencion;

    public String getLicenciaProfecional() {
        return licenciaProfecional;
    }

    public void setLicenciaProfecional(String licenciaProfecional) {
        this.licenciaProfecional = licenciaProfecional;
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

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getHorarioAtencion() {
        return horarioAtencion;
    }

    public void setHorarioAtencion(String horarioAtencion) {
        this.horarioAtencion = horarioAtencion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
