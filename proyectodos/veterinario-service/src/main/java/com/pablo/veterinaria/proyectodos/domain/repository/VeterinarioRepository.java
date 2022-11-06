package src.main.java.com.pablo.veterinaria.proyectodos.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import src.main.java.com.pablo.veterinaria.proyectodos.domain.gateway.VeterinarioGateway;
import src.main.java.com.pablo.veterinaria.proyectodos.domain.model.entity.Veterinario;

import java.util.List;
import java.util.Optional;

public class VeterinarioRepository implements VeterinarioGateway {

    @Autowired
    private VeterinarioCrudRepository crudRepository;


    @Override
    public List<Veterinario> getAll() {
        return crudRepository.findAll();
    }

    @Override
    public Optional<Veterinario> getVeterinarioById(String id) {
        return crudRepository.findById(id);
    }

    @Override
    public Veterinario saveVeterinario(Veterinario vet) {
        return crudRepository.save(vet);
    }

    @Override
    public Boolean deleteVeterinario(String id) {

        Boolean salida=false;

        Optional<Veterinario> vet = crudRepository.findById(id);

        if(!vet.isEmpty())
        {
            crudRepository.deleteById(id);
            salida=true;
        }

        return salida;
    }
}
