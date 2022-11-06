package com.pablo.veterinaria.proyectouno.application.ports.in.usuario;

import com.pablo.veterinaria.proyectouno.application.domain.entity.Usuario;
import com.pablo.veterinaria.proyectouno.commons.UseCase;

import java.util.Locale;

public interface SaveUsuarioUseCase extends UseCase<Usuario, String> {
    String execute(Usuario usuario, Locale locale);
}
