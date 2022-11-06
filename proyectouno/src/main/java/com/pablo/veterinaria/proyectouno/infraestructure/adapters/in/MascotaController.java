package com.pablo.veterinaria.proyectouno.infraestructure.adapters.in;


import com.pablo.veterinaria.proyectouno.application.domain.entity.Mascota;
import com.pablo.veterinaria.proyectouno.application.domain.exception.DuenoNoExisteException;
import com.pablo.veterinaria.proyectouno.application.domain.exception.MascotaEnTratamientoException;
import com.pablo.veterinaria.proyectouno.application.services.mascota.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/mascota")
public class MascotaController {


    @GetMapping("/all")
    public ResponseEntity<List<Mascota>> getAll()
    {
        GetAllService service = new GetAllService();

        return new ResponseEntity<List<Mascota>>(service.execute(null), HttpStatus.OK);

    }

    @GetMapping("/{nombre}")
    public ResponseEntity<Mascota> getNombreMascota(@PathVariable("nombre") String nombre) throws DuenoNoExisteException, MascotaEnTratamientoException {
        GetMascotaByNombreService service = new GetMascotaByNombreService();
        Mascota masSel = service.execute(nombre).get();

        masSel.add(linkTo(methodOn(MascotaController.class).saveMascota(masSel)).withSelfRel(),
                linkTo(methodOn(MascotaController.class).deleteMascota(masSel.getNombre())).withSelfRel(),
                linkTo(methodOn(MascotaController.class).getNombreMascota(masSel.getNombre())).withSelfRel(),
                linkTo(methodOn(MascotaController.class).findByRaza(masSel.getRaza())).withSelfRel());


        return new ResponseEntity<Mascota>(masSel, HttpStatus.OK);

    }

    @GetMapping("/raza/{raza}")
    public ResponseEntity<List<Mascota>> findByRaza(String raza)
    {
        FindByRazaService service = new FindByRazaService();

        List<Mascota> lst = service.execute(raza);

        return new ResponseEntity<List<Mascota>>(lst, HttpStatus.OK);
    }


    @PostMapping("/save")
    public ResponseEntity<String> saveMascota(@RequestBody Mascota mas) throws DuenoNoExisteException {
        SaveMascotaService service = new SaveMascotaService();

        String  saved=service.execute(mas);

        return new ResponseEntity<String>(saved, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteMascota(@PathVariable("nombre") String nombre) throws MascotaEnTratamientoException {
        DeleteMascotaService service = new DeleteMascotaService();

        String masDel = service.execute(nombre);

        return new ResponseEntity<String>(masDel, HttpStatus.OK);
    }


}
