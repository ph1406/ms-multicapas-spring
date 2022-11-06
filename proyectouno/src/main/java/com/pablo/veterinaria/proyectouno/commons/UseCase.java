package com.pablo.veterinaria.proyectouno.commons;

import com.pablo.veterinaria.proyectouno.application.domain.exception.DuenoNoExisteException;
import com.pablo.veterinaria.proyectouno.application.domain.exception.MascotaEnTratamientoException;

public interface UseCase<Input, Output> {
    Output execute(Input input) throws MascotaEnTratamientoException, DuenoNoExisteException;
}
