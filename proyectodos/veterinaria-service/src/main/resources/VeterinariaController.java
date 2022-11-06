package src.main.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import src.main.java.com.pablo.veterinaria.proyectodos.domain.model.entity.Veterinaria;
import src.main.java.com.pablo.veterinaria.proyectodos.domain.service.VeterinariaService;

import java.util.List;

@RestController
@RequestMapping("/veterinaria")
public class VeterinariaController {

    @Autowired
    private VeterinariaService service;

    @GetMapping("/all")
    public ResponseEntity<List<Veterinaria>> getAll()
    {
        return new ResponseEntity<List<Veterinaria>>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veterinaria> getVeterinariaById(@PathVariable("id") String id)
    {
        return new ResponseEntity<Veterinaria>(service.getByVeterinariaId(id).get(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Veterinaria> saveVeterinaria(@RequestBody Veterinaria vet)
    {
        return new ResponseEntity<Veterinaria>(service.saveVeterinaria(vet),HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteVeterinaria(@PathVariable("id") String id)
    {
        return new ResponseEntity<Boolean>(service.deleteVeterinaria(id),HttpStatus.OK);
    }


}
