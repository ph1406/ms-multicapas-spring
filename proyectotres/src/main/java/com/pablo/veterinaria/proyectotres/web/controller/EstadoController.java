package com.pablo.veterinaria.proyectotres.web.controller;

import com.pablo.veterinaria.proyectotres.domain.entity.Estado;
import com.pablo.veterinaria.proyectotres.domain.services.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import java.util.List;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    private EstadoService service;

    @GetMapping("/all")
    public ResponseEntity<List<Estado>> getAll()
    {
       return new ResponseEntity<List<Estado>>(service.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Estado> getById(@PathVariable("id") Integer id)
    {
        Estado est = service.getEstadoById(id).get();

        est.add(linkTo(methodOn(EstadoController.class).getById(id)).withSelfRel(),
                linkTo(methodOn(EstadoController.class).deleteEstado(id)).withSelfRel(),
                linkTo(methodOn(EstadoController.class).saveEstado(est)).withSelfRel());


        return new ResponseEntity<>(est, HttpStatus.OK);
    }
    @PostMapping("/save")
    public ResponseEntity<Estado> saveEstado(@RequestBody Estado estado)
    {
        Estado est = service.saveEstado(estado);

        if(est==null)
        {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Estado>(est, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteEstado(@PathVariable("id") Integer id)
    {
        return new ResponseEntity<Boolean>(service.deleteEstado(id), HttpStatus.OK);
    }





}
