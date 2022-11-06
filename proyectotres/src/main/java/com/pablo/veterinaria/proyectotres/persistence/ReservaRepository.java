package com.pablo.veterinaria.proyectotres.persistence;


import com.pablo.veterinaria.proyectotres.domain.entity.Reserva;
import com.pablo.veterinaria.proyectotres.domain.gateway.ReservaGateway;
import com.pablo.veterinaria.proyectotres.persistence.crud.ReservaCrudRepository;
import com.pablo.veterinaria.proyectotres.persistence.mappers.ReservaMapper;
import com.pablo.veterinaria.proyectotres.persistence.models.ReservaDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class ReservaRepository implements ReservaGateway {

    private ReservaCrudRepository crudRepository;
    private ReservaMapper mapper;

    public ReservaRepository(ReservaCrudRepository crudRepository, ReservaMapper mapper) {
        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Reserva> getAll() {

        List<ReservaDAO> lstdao = (List<ReservaDAO>) crudRepository.findAll();
        return mapper.toReservas(lstdao);
    }

    @Override
    public Optional<Reserva> getReservaById(Integer idReserva) {
        return crudRepository.findById(idReserva).map(td->mapper.toReserva(td));
    }

    @Override
    public Reserva saveReserva(Reserva reserva) {
        ReservaDAO dao = mapper.toReservaDAO(reserva);
        return mapper.toReserva(crudRepository.save(dao));
    }

    @Override
    public Boolean deleteReserva(Integer idReserva) {

        Boolean salida=false;
        Optional<ReservaDAO> dao = crudRepository.findById(idReserva);

        if(!dao.isEmpty())
        {
            crudRepository.deleteById(idReserva);
            salida=true;
        }

        return salida;
    }

    @Override
    public List<Reserva> getReservaByIdEstado(Integer idEstado) {
        List<ReservaDAO> lst = crudRepository.getReservaByIdEstado(idEstado);
        return mapper.toReservas(lst);
    }

    @Override
    public List<Reserva> getReservaBynombreMascota(String nombre) {
        List<ReservaDAO> lst = crudRepository.getReservaBynombreMascota(nombre);
        return mapper.toReservas(lst);
    }
}
