package com.pablo.veterinaria.proyectouno.application.services.mascota;

import com.pablo.veterinaria.proyectouno.application.domain.entity.Mascota;
import com.pablo.veterinaria.proyectouno.application.ports.in.mascota.GetMascotaByNombreUseCase;
import com.pablo.veterinaria.proyectouno.application.ports.out.mascota.MascotaGateway;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class GetMascotaByNombreService implements GetMascotaByNombreUseCase {
    @Autowired
    private MascotaGateway gateway;

    @Override
    public Optional<Mascota> execute(String nombre) {
        return gateway.getMascotaByNombre(nombre);
    }
}
