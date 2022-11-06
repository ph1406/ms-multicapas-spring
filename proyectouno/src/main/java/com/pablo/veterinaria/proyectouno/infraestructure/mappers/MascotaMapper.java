package com.pablo.veterinaria.proyectouno.infraestructure.mappers;


import com.pablo.veterinaria.proyectouno.application.domain.entity.Mascota;
import com.pablo.veterinaria.proyectouno.infraestructure.models.MascotaDAO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel="spring", uses={UsuarioMapper.class})
public interface MascotaMapper {

    @Mappings({
            @Mapping(source = "nombre", target = "nombre"),
            @Mapping(source = "tipoAnimal", target = "tipoAnimal"),
            @Mapping(source = "raza", target = "raza"),
            @Mapping(source = "tratamientoActivo", target = "tratamientoActivo"),
            @Mapping(source = "idUsuario", target = "idUsuario")
    })
    Mascota toMascota(MascotaDAO dao);

    List<Mascota> toMascotas(List<MascotaDAO> daos);

    @InheritInverseConfiguration
    @Mapping(target="dueno",ignore = true)
    MascotaDAO toMascotaDao(Mascota dao);

}
