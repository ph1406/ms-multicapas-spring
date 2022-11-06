package src.main.java.com.pablo.veterinaria.proyectodos.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import src.main.java.com.pablo.veterinaria.proyectodos.domain.model.entity.Veterinario;
import src.main.java.com.pablo.veterinaria.proyectodos.domain.service.VeterinarioService;

import java.util.List;

@RestController
@RequestMapping("/veterinario")
public class VeterinarioController {

    @Autowired
    private VeterinarioService service;


    @GetMapping("/all")
    public ResponseEntity<List<Veterinario>> getAll() {
      return new ResponseEntity<List<Veterinario>>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veterinario> getVeterinadioById(@PathVariable("id") String id) {
        return new ResponseEntity<Veterinario>(service.getVeterinarioById(id).get(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Veterinario> saveVeterinario(@RequestBody Veterinario vet)
    {
        return new ResponseEntity<Veterinario>(service.saveVeterinario(vet), HttpStatus.OK);
    }

    @PostMapping("/delete/{id}")
    public  ResponseEntity<Boolean> deleteVeterianrio(@PathVariable("id") String id)
    {
        return new ResponseEntity<Boolean>(service.deleteVeterinario(id),HttpStatus.OK);
    }

}
