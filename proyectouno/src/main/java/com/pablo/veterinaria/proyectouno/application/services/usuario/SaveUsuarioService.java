package com.pablo.veterinaria.proyectouno.application.services.usuario;

import com.pablo.veterinaria.proyectouno.application.domain.entity.Usuario;
import com.pablo.veterinaria.proyectouno.application.ports.in.usuario.SaveUsuarioUseCase;
import com.pablo.veterinaria.proyectouno.application.ports.out.usuario.UsuarioGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.Locale;

public class SaveUsuarioService implements SaveUsuarioUseCase {

    @Autowired
    private UsuarioGateway gateway;

    @Autowired
    MessageSource msg;



    @Override
    public String execute(Usuario usuario, Locale locale) {

        gateway.saveUsuario(usuario);

        return String.format(msg.getMessage("usuario.create.message", null, locale), String.valueOf(usuario.getId()));
    }

    @Override
    public String execute(Usuario usuario) {
        gateway.saveUsuario(usuario);

        return String.format(msg.getMessage("usuario.create.message", null, null), String.valueOf(usuario.getId()));
    }
}
