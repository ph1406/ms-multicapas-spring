package src.main.java.com.pablo.veterinaria.proyectodos.domain.service;


import org.springframework.beans.factory.annotation.Autowired;
import src.main.java.com.pablo.veterinaria.proyectodos.domain.gateway.VeterinariaGateway;
import src.main.java.com.pablo.veterinaria.proyectodos.domain.model.entity.Veterinaria;

import java.util.List;
import java.util.Optional;

public class VeterinariaService {

    @Autowired
    VeterinariaGateway gateway;

    public List<Veterinaria> getAll(){
           return gateway.getAll();
    }

    public Optional<Veterinaria> getByVeterinariaId(String nombre)
    {
        return gateway.getVeterinariaById(nombre);
    }

    public  Veterinaria saveVeterinaria(Veterinaria vet)
    {
        return gateway.saveVeterinaria(vet);
    }

    public Boolean deleteVeterinaria(String idVet)
    {
        Boolean salida=false;

        Optional<Veterinaria> vet = gateway.getVeterinariaById(idVet);

        if(!vet.isEmpty())
        {
            gateway.deleteVeterinaria(idVet);
            salida=true;
        }

        return salida;
    }
}


