package com.pablo.veterinaria.proyectouno.application.ports.in.mascota;

import com.pablo.veterinaria.proyectouno.application.domain.entity.Mascota;
import com.pablo.veterinaria.proyectouno.commons.UseCase;

import java.util.Optional;

public interface GetMascotaByNombreUseCase extends UseCase<String, Optional<Mascota>> {
}
