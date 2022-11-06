package com.pablo.veterinaria.proyectotres.web.controller;

import com.pablo.veterinaria.proyectotres.domain.entity.Reserva;
import com.pablo.veterinaria.proyectotres.domain.exceptions.MaxReservaException;
import com.pablo.veterinaria.proyectotres.domain.exceptions.PetMultiVetException;
import com.pablo.veterinaria.proyectotres.domain.exceptions.TratamientoNoTerminadoException;
import com.pablo.veterinaria.proyectotres.domain.services.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/reserva")
public class ReservaController {

    @Autowired
    private ReservaService service;

    @GetMapping("/all")
    public ResponseEntity<List<Reserva>> getAll()
    {
        return new ResponseEntity<List<Reserva>>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/all/estado/{estado}")
    public  ResponseEntity<List<Reserva>> getAllEstado(@PathVariable("estado") Integer idEstado)
    {
        return new ResponseEntity<List<Reserva>>(service.getReservaByIdEstado(idEstado), HttpStatus.OK);
    }

    @GetMapping("/all/estado/{nombre}")
    public  ResponseEntity<List<Reserva>> getAllMascota(@PathVariable("nombre") String nombre)
    {
        return new ResponseEntity<List<Reserva>>(service.getReservaBynombreMascota(nombre), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getById(@PathVariable("id") Integer id) throws TratamientoNoTerminadoException, MaxReservaException, PetMultiVetException {
        Reserva res = service.getReservaById(id).get();

        res.add(linkTo(methodOn(ReservaController.class).getById(id)).withSelfRel(),
                linkTo(methodOn(ReservaController.class).delete(id)).withSelfRel(),
                linkTo(methodOn(ReservaController.class).save(res)).withSelfRel()
        );

        return new ResponseEntity<Reserva>(res, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody Reserva reserva) throws MaxReservaException, PetMultiVetException {
        String res = service.saveReserva(reserva);

        return new ResponseEntity<String>(res, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Integer id) throws TratamientoNoTerminadoException {
        String res = service.deleteReserva(id);

        return new ResponseEntity<String>(res, HttpStatus.OK);

    }





}
