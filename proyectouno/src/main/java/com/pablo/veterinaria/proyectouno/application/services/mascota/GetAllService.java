package com.pablo.veterinaria.proyectouno.application.services.mascota;

import com.pablo.veterinaria.proyectouno.application.domain.entity.Mascota;
import com.pablo.veterinaria.proyectouno.application.ports.in.mascota.GetAllUseCase;
import com.pablo.veterinaria.proyectouno.application.ports.out.mascota.MascotaGateway;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GetAllService implements GetAllUseCase {

    @Autowired
    private MascotaGateway gateway;

    @Override
    public List<Mascota> execute(Void unused) {
        return gateway.getAll();
    }
}
