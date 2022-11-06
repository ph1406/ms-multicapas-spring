package com.pablo.veterinaria.proyectotres.persistence.mappers;


import com.pablo.veterinaria.proyectotres.domain.entity.Estado;
import com.pablo.veterinaria.proyectotres.persistence.models.EstadoDAO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EstadoMapper {

    @Mappings({
            @Mapping(source = "idEstado", target = "idEstado"),
            @Mapping(source = "nombreEstado", target = "nombreEstado")
    })
    Estado toEstado(EstadoDAO estado);

    List<Estado> toEstados(List<EstadoDAO> estados);

    @InheritInverseConfiguration
    EstadoDAO toEstadoDAO(Estado estado);

}
