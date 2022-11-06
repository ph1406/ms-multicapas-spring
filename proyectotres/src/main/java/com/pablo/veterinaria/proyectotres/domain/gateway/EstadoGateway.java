package com.pablo.veterinaria.proyectotres.domain.gateway;

import com.pablo.veterinaria.proyectotres.domain.entity.Estado;

import java.util.List;
import java.util.Optional;

public interface EstadoGateway {

    List<Estado> getAll();
    Optional<Estado> getEstadoById(Integer idEstado);
    Estado saveEstado(Estado estado);
    Boolean deleteEstado(Integer idEstado);

}
