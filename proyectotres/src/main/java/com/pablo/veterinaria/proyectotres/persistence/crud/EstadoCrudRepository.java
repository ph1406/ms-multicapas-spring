package com.pablo.veterinaria.proyectotres.persistence.crud;

import com.pablo.veterinaria.proyectotres.persistence.models.EstadoDAO;
import org.springframework.data.repository.CrudRepository;

public interface EstadoCrudRepository extends CrudRepository<EstadoDAO,Integer> {
}
