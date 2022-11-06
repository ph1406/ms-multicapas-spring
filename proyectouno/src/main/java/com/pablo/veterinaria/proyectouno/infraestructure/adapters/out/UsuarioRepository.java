package com.pablo.veterinaria.proyectouno.infraestructure.adapters.out;

import com.pablo.veterinaria.proyectouno.application.domain.entity.Usuario;
import com.pablo.veterinaria.proyectouno.application.ports.out.usuario.UsuarioGateway;
import com.pablo.veterinaria.proyectouno.infraestructure.crud.UsuarioCrudRepository;
import com.pablo.veterinaria.proyectouno.infraestructure.mappers.UsuarioMapper;
import com.pablo.veterinaria.proyectouno.infraestructure.models.UsuarioDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public class UsuarioRepository implements UsuarioGateway {


    private UsuarioCrudRepository crudRepository;
    private UsuarioMapper mapper;

    public UsuarioRepository(UsuarioCrudRepository crudRepository, UsuarioMapper mapper) {


        this.crudRepository = crudRepository;
        this.mapper = mapper;
    }

    @Override
    public List<Usuario> getAll() {

        List<UsuarioDAO> lst = (List<UsuarioDAO>) crudRepository.findAll();
        List<Usuario> lstSalida = mapper.toUsuarios(lst);
        return lstSalida;
    }

    @Override
    public Optional<Usuario> getUsuariobyId(Integer id) {

        return crudRepository.findById(id).map(td->mapper.toUsuario(td));


    }

    @Override
    public Usuario saveUsuario(Usuario usuario) {

        UsuarioDAO udao = crudRepository.save(mapper.toUsuarioDao(usuario));
        return mapper.toUsuario(udao);
    }

    @Override
    public Boolean deleteUsuario(Integer id) {

        Boolean salida=false;
        Optional<UsuarioDAO> usr = crudRepository.findById(id);

        if(!usr.isEmpty())
        {
            crudRepository.deleteById(id);
            salida=true;
        }
        return salida;
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {

        UsuarioDAO udao = crudRepository.save(mapper.toUsuarioDao(usuario));
        return mapper.toUsuario(udao);
    }

    @Override
    public List<Usuario> findBynombreCompletoContains(String nombre) {
        List<UsuarioDAO> lst = (List<UsuarioDAO>) crudRepository.findBynombreCompletoContains(nombre);
        List<Usuario> lstSalida = mapper.toUsuarios(lst);
        return lstSalida;
    }
}
