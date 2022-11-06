package com.pablo.veterinaria.proyectouno.infraestructure.crud;

import com.pablo.veterinaria.proyectouno.infraestructure.models.MascotaDAO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MascotaCrudRepository extends CrudRepository<MascotaDAO, String> {

    List<MascotaDAO> findMascotaByRaza(String raza);
}
