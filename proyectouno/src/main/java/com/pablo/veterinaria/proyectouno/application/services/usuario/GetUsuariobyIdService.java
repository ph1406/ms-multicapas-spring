package com.pablo.veterinaria.proyectouno.application.services.usuario;

import com.pablo.veterinaria.proyectouno.application.domain.entity.Usuario;
import com.pablo.veterinaria.proyectouno.application.ports.in.usuario.GetUsuariobyIdUseCase;
import com.pablo.veterinaria.proyectouno.application.ports.out.usuario.UsuarioGateway;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class GetUsuariobyIdService implements GetUsuariobyIdUseCase {

    @Autowired
    private UsuarioGateway gateway;

    @Override
    public Optional<Usuario> execute(Integer id) {
        return gateway.getUsuariobyId(id);
    }
}
