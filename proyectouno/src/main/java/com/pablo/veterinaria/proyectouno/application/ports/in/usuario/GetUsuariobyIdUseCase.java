package com.pablo.veterinaria.proyectouno.application.ports.in.usuario;

import com.pablo.veterinaria.proyectouno.application.domain.entity.Usuario;
import com.pablo.veterinaria.proyectouno.commons.UseCase;

import java.util.Optional;

public interface GetUsuariobyIdUseCase extends UseCase<Integer, Optional<Usuario>> {
}
