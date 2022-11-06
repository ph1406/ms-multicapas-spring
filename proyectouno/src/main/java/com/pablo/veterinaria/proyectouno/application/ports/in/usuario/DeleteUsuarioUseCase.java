package com.pablo.veterinaria.proyectouno.application.ports.in.usuario;

import com.pablo.veterinaria.proyectouno.commons.UseCase;

import java.util.Locale;

public interface DeleteUsuarioUseCase extends UseCase<Integer, String> {
    String execute(Integer integer, Locale local);
}
