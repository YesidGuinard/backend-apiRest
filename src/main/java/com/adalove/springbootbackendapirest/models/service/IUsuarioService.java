package com.adalove.springbootbackendapirest.models.service;

import com.adalove.springbootbackendapirest.models.entity.Role;
import com.adalove.springbootbackendapirest.models.entity.Usuario;

public interface IUsuarioService {
    public Usuario findByUserApellidoHabilitado(String userApellido, Boolean enabled);
}
