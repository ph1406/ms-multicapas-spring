package src.main.java.com.pablo.veterinaria.proyectodos.domain.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.RepresentationModel;

@Document
public class Veterinaria  extends RepresentationModel<Veterinaria> {

    @Id
    private String registroNacional;
    private String nombreVeterinaria;
    private String direccionVeterinaria;
    private Boolean certificadoSanitario;

    public String getRegistroNacional() {
        return registroNacional;
    }

    public void setRegistroNacional(String registroNacional) {
        this.registroNacional = registroNacional;
    }

    public Boolean getCertificadoSanitario() {
        return certificadoSanitario;
    }

    public void setCertificadoSanitario(Boolean certificadoSanitario) {
        this.certificadoSanitario = certificadoSanitario;
    }

    public String getNombreVeterinaria() {
        return nombreVeterinaria;
    }

    public void setNombreVeterinaria(String nombreVeterinaria) {
        this.nombreVeterinaria = nombreVeterinaria;
    }

    public String getDireccionVeterinaria() {
        return direccionVeterinaria;
    }

    public void setDireccionVeterinaria(String direccionVeterinaria) {
        this.direccionVeterinaria = direccionVeterinaria;
    }
}
