package src.main.java.com.pablo.veterinaria.proyectodos.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import src.main.java.com.pablo.veterinaria.proyectodos.domain.gateway.VeterinarioGateway;
import src.main.java.com.pablo.veterinaria.proyectodos.domain.model.entity.Veterinario;

import java.util.List;
import java.util.Optional;

public class VeterinarioService {

    @Autowired
    private VeterinarioGateway gateway;


    public List<Veterinario> getAll(){
        return gateway.getAll();
    }
    public Optional<Veterinario> getVeterinarioById(String id)
    {
        return gateway.getVeterinarioById(id);
    }
    public Veterinario saveVeterinario(Veterinario vet)
    {
        return gateway.saveVeterinario(vet);
    }
    public Boolean deleteVeterinario(String id)
    {
        return gateway.deleteVeterinario(id);
    }


}
