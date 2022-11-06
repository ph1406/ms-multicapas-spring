package com.pablo.veterinaria.proyectouno.infraestructure.adapters.in;


import com.pablo.veterinaria.proyectouno.application.domain.entity.Usuario;
import com.pablo.veterinaria.proyectouno.application.services.usuario.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> getAll()
    {
        GetAllService service = new GetAllService();

        return new ResponseEntity<List<Usuario>>(service.execute(null), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable("id") Integer id)
    {
        GetUsuariobyIdService service = new GetUsuariobyIdService();

        Usuario user = service.execute(id).get();

        user.add(linkTo(methodOn(UsuarioController.class).getUsuarioById(id)).withSelfRel(),
                linkTo(methodOn(UsuarioController.class).deleteUsuario(id, null)).withSelfRel(),
                linkTo(methodOn(UsuarioController.class).saveUsuario(user, null)).withSelfRel(),
                linkTo(methodOn(UsuarioController.class).getByNombreCompletoContains(user.getNombreCompleto())).withSelfRel());


        return new ResponseEntity<Usuario>(user, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<String> saveUsuario(@RequestBody Usuario user,
                                              @RequestHeader(value="Accept-Language", required = false) Locale local)
    {
        SaveUsuarioService service = new SaveUsuarioService();

        String usuarioSave = service.execute(user);
        return new ResponseEntity<String>(usuarioSave, HttpStatus.CREATED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteUsuario(@PathVariable("id") Integer id,
                                                 @RequestHeader(value="Accept-Language", required = false) Locale local)
    {
        DeleteUsuarioService service = new DeleteUsuarioService();

        return new ResponseEntity(service.execute(id, local), HttpStatus.ACCEPTED);
    }

    @GetMapping("/nombre/{nombre}")
    public ResponseEntity<List<Usuario>> getByNombreCompletoContains(@PathVariable("nombre") String nombre)
    {
        FindBynombreCompletoContainsService service = new FindBynombreCompletoContainsService();

        return new ResponseEntity<List<Usuario>>(service.execute(nombre), HttpStatus.OK);
    }



}
