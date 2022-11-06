package com.pablo.veterinaria.proyectouno.infraestructure.adapters.out;

import com.pablo.veterinaria.proyectouno.application.domain.entity.Mascota;
import com.pablo.veterinaria.proyectouno.application.ports.out.mascota.MascotaGateway;
import com.pablo.veterinaria.proyectouno.infraestructure.crud.MascotaCrudRepository;
import com.pablo.veterinaria.proyectouno.infraestructure.mappers.MascotaMapper;
import com.pablo.veterinaria.proyectouno.infraestructure.models.MascotaDAO;

import java.util.List;
import java.util.Optional;

public class MascotaRepository implements MascotaGateway {

    private MascotaCrudRepository crudRepository;
    private MascotaMapper mapper;


    public MascotaRepository(MascotaCrudRepository crudRepository, MascotaMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Mascota> getAll() {

        List<MascotaDAO> lst = (List<MascotaDAO> )crudRepository.findAll();
        return mapper.toMascotas(lst);
    }

    @Override
    public Optional<Mascota> getMascotaByNombre(String nombre) {

        return crudRepository.findById(nombre).map(td-> mapper.toMascota(td));
    }

    @Override
    public Mascota saveMascota(Mascota mascota) {

        MascotaDAO mas = crudRepository.save(mapper.toMascotaDao(mascota));
        return mapper.toMascota(mas);
    }

    @Override
    public Boolean deleteMascota(String nombre) {

        Optional<MascotaDAO> mas = crudRepository.findById(nombre);
        Boolean salida=false;
        if(!mas.isEmpty())
        {
            crudRepository.deleteById(nombre);
            salida=true;
        }

        return salida;
    }

    @Override
    public Mascota createMascota(Mascota mascota) {

        MascotaDAO mas = crudRepository.save(mapper.toMascotaDao(mascota));
        return mapper.toMascota(mas);
    }

    @Override
    public List<Mascota> getMascotaByRaza(String raza) {

        List<MascotaDAO> lstMas = crudRepository.findMascotaByRaza(raza);
        return mapper.toMascotas(lstMas);
    }
}
