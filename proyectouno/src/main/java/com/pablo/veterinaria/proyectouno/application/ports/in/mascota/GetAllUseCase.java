package com.pablo.veterinaria.proyectouno.application.ports.in.mascota;

import com.pablo.veterinaria.proyectouno.application.domain.entity.Mascota;
import com.pablo.veterinaria.proyectouno.commons.UseCase;

import java.util.List;

public interface GetAllUseCase extends UseCase<Void, List<Mascota>> {
}
