package com.pablo.veterinaria.proyectouno.infraestructure.mappers;


import com.pablo.veterinaria.proyectouno.application.domain.entity.Usuario;
import com.pablo.veterinaria.proyectouno.infraestructure.models.UsuarioDAO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel="spring", uses={MascotaMapper.class})
public interface UsuarioMapper
{

    @Mappings({
            @Mapping(source="id", target="id"),
            @Mapping(source="nombreCompleto", target="nombreCompleto"),
            @Mapping(source="telefono", target="telefono"),
            @Mapping(source="mail", target="mail"),
            @Mapping(source="estado", target="estado")

    })
    Usuario toUsuario(UsuarioDAO dao);

    List<Usuario> toUsuarios(List<UsuarioDAO> daos);

    @InheritInverseConfiguration
    @Mapping(target="mascotas", ignore = true)
     UsuarioDAO toUsuarioDao(Usuario dao);

}
