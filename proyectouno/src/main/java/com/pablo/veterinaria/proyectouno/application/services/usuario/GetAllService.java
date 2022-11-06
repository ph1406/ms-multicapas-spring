package com.pablo.veterinaria.proyectouno.application.services.usuario;

import com.pablo.veterinaria.proyectouno.application.domain.entity.Usuario;
import com.pablo.veterinaria.proyectouno.application.ports.in.usuario.GetAllUseCase;
import com.pablo.veterinaria.proyectouno.application.ports.out.usuario.UsuarioGateway;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class GetAllService implements GetAllUseCase {

    @Autowired
    private UsuarioGateway gateway;



    @Override
    public List<Usuario> execute(Void unused) {
        return gateway.getAll();
    }
}
