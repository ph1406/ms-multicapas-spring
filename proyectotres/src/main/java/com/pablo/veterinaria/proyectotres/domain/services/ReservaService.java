package com.pablo.veterinaria.proyectotres.domain.services;

import com.pablo.veterinaria.proyectotres.domain.entity.Reserva;
import com.pablo.veterinaria.proyectotres.domain.exceptions.MaxReservaException;
import com.pablo.veterinaria.proyectotres.domain.exceptions.PetMultiVetException;
import com.pablo.veterinaria.proyectotres.domain.exceptions.TratamientoNoTerminadoException;
import com.pablo.veterinaria.proyectotres.domain.gateway.ReservaGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.List;
import java.util.Optional;

public class ReservaService {

    @Autowired
    private ReservaGateway gateway;
    @Autowired
    MessageSource msg;


    public List<Reserva> getAll()    {  return gateway.getAll();    }
    public Optional<Reserva> getReservaById(Integer idReserva)
    {
        return gateway.getReservaById(idReserva);
    }
    public String saveReserva(Reserva reserva) throws MaxReservaException, PetMultiVetException {

        List<Reserva> lstReservaExistente = gateway.getReservaBynombreMascota(reserva.getNombreMascota());

        if(lstReservaExistente.size()>=2)
        {
            String maxReserva = msg.getMessage("error.mascota.reservamax", null, null);
            throw new MaxReservaException(maxReserva);
        }
        for(Reserva r : lstReservaExistente)
        {
            if(!r.getIdVeterinaria().equals(reserva.getIdVeterinaria()))
            {
                String msgVetMultiple = msg.getMessage("error.mascota.multivet", null, null);
                throw new PetMultiVetException(msgVetMultiple);
            }
        }

        String msjRes = msg.getMessage("reserva.save.message", null, null);
        msjRes = msjRes.format(msjRes, reserva.getIdReserva());

        return msjRes;
    }
    public String deleteReserva(Integer idReserva) throws TratamientoNoTerminadoException {
        String mje="";

        Optional<Reserva> res = gateway.getReservaById(idReserva);

        if(!res.isEmpty())
        {
            int codEstadoRes = res.get().getIdEstado();
            if(codEstadoRes==3 || codEstadoRes==4)
            {
                String mjeEx = msg.getMessage("error.reserva.soloinactivas",null,null);
               throw new TratamientoNoTerminadoException(mjeEx);
            }
        }

        Boolean borro = gateway.deleteReserva(idReserva);

        mje=msg.getMessage("reserva.delete.mesage", null,null);


        return mje;
    }
    public List<Reserva> getReservaByIdEstado(Integer idEstado)
    {
        return gateway.getReservaByIdEstado(idEstado);
    }

    public  List<Reserva> getReservaBynombreMascota(String nombre){ return gateway.getReservaBynombreMascota(nombre); }

}
