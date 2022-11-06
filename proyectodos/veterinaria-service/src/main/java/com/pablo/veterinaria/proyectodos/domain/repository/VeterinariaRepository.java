package src.main.java.com.pablo.veterinaria.proyectodos.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import src.main.java.com.pablo.veterinaria.proyectodos.domain.gateway.VeterinariaGateway;
import src.main.java.com.pablo.veterinaria.proyectodos.domain.model.entity.Veterinaria;

import java.util.List;
import java.util.Optional;

public class VeterinariaRepository implements VeterinariaGateway {

    @Autowired
    public VeterinariaCrudRepository crudRepository;


    @Override
    public List<Veterinaria> getAll() {
        return crudRepository.findAll();
    }

    @Override
    public Optional<Veterinaria> getVeterinariaById(String id) {
        return crudRepository.findById(id);
    }

    @Override
    public Veterinaria saveVeterinaria(Veterinaria vet) {
        return crudRepository.save(vet);
    }

    @Override
    public Boolean deleteVeterinaria(String id)
    {
        Optional<Veterinaria> vet = crudRepository.findById(id);
        Boolean salida = false;
        if (!vet.isEmpty())
        {
            crudRepository.deleteById(id);
            salida = true;
        }


        return salida;
    }
}
