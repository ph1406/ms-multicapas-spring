package com.pablo.veterinaria.proyectouno.application.services.usuario;

import com.pablo.veterinaria.proyectouno.application.ports.in.usuario.DeleteUsuarioUseCase;
import com.pablo.veterinaria.proyectouno.application.ports.out.usuario.UsuarioGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.util.Locale;

public class DeleteUsuarioService implements DeleteUsuarioUseCase {

    @Autowired
    private UsuarioGateway gateway;

    @Autowired
    MessageSource msg;

    @Override
    public String execute(Integer integer, Locale local) {
        Boolean res = gateway.deleteUsuario(integer);

        if(res==false)
        {
            return String.format(msg.getMessage("usuario.delete.error.message", null,local));
        }



        return String.format(msg.getMessage("usuario.delete.message", null, local), String.valueOf(integer));

    }

    @Override
    public String execute(Integer integer) {
        Boolean res = gateway.deleteUsuario(integer);

        if(res==false)
        {
            return String.format(msg.getMessage("usuario.delete.error.message", null,null));
        }



        return String.format(msg.getMessage("usuario.delete.message", null, null), String.valueOf(integer));

    }
}
