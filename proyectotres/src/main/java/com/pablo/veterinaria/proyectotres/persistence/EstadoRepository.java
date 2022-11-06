package com.pablo.veterinaria.proyectotres.persistence;

import com.pablo.veterinaria.proyectotres.domain.entity.Estado;
import com.pablo.veterinaria.proyectotres.domain.gateway.EstadoGateway;
import com.pablo.veterinaria.proyectotres.persistence.crud.EstadoCrudRepository;
import com.pablo.veterinaria.proyectotres.persistence.mappers.EstadoMapper;
import com.pablo.veterinaria.proyectotres.persistence.models.EstadoDAO;

import java.util.List;
import java.util.Optional;

public class EstadoRepository implements EstadoGateway {

    public EstadoCrudRepository crudRepository;
    public EstadoMapper mapper;

    public EstadoRepository(EstadoCrudRepository crudRepository, EstadoMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Estado> getAll() {

        List<EstadoDAO> lst = (List<EstadoDAO>)crudRepository.findAll();

        return mapper.toEstados(lst);
    }

    @Override
    public Optional<Estado> getEstadoById(Integer idEstado)
    {
        return crudRepository.findById(idEstado).map(td->mapper.toEstado(td));
    }

    @Override
    public Estado saveEstado(Estado estado) {
        EstadoDAO dao = mapper.toEstadoDAO(estado);
        return mapper.toEstado(crudRepository.save(dao));
    }

    @Override
    public Boolean deleteEstado(Integer idEstado) {
        Boolean salida=false;
        Optional<EstadoDAO> dao = crudRepository.findById(idEstado);
        if(!dao.isEmpty())
        {
            crudRepository.deleteById(idEstado);
            salida=true;
        }
        return salida;
    }
}
