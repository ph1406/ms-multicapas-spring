package com.pablo.veterinaria.proyectotres.persistence.mappers;


import com.pablo.veterinaria.proyectotres.domain.entity.Reserva;
import com.pablo.veterinaria.proyectotres.persistence.models.ReservaDAO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ReservaMapper {

    @Mappings({
            @Mapping(source="idReserva", target = "idReserva"),
            @Mapping(source="fechaReserva", target = "fechaReserva"),
            @Mapping(source="nombreMascota", target = "nombreMascota"),
            @Mapping(source="idDueno", target = "idDueno"),
            @Mapping(source="idVeterinaria", target = "idVeterinaria"),
            @Mapping(source="valorReserva", target = "valorReserva"),
            @Mapping(source="formaPago", target = "formaPago"),
            @Mapping(source="idEstado", target = "idEstado"),
            @Mapping(source="descripcion", target = "descripcion"),
    })
    Reserva toReserva(ReservaDAO reserva);

    List<Reserva> toReservas(List<ReservaDAO> reservas);

    @InheritInverseConfiguration
    @Mapping(target="estado", ignore=true)
    ReservaDAO toReservaDAO(Reserva dao);

}
