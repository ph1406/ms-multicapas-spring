package com.pablo.veterinaria.proyectouno.application.services.mascota;

import com.pablo.veterinaria.proyectouno.application.domain.entity.Mascota;
import com.pablo.veterinaria.proyectouno.application.ports.in.mascota.FindByRazaUseCase;
import com.pablo.veterinaria.proyectouno.application.ports.out.mascota.MascotaGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.List;

public class FindByRazaService implements FindByRazaUseCase {


    @Autowired
    private MascotaGateway gateway;
    @Autowired
    MessageSource msg;

    @Override
    public List<Mascota> execute(String s) {
        return null;
    }
}
