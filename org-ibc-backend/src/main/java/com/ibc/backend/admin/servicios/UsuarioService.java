package com.ibc.backend.admin.servicios;

import java.util.Set;

import com.ibc.backend.admin.modelo.Usuario;
import com.ibc.backend.admin.modelo.UsuarioRol;

public interface UsuarioService {

    public Usuario guardarUsuario(Usuario usuario, Set<UsuarioRol> usuarioRoles) throws Exception;

    public Usuario obtenerUsuario(String username);

    public void eliminarUsuario(Long usuarioId);
}
