package com.ibc.backend.admin.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibc.backend.admin.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {

    public Usuario findByUsername(String username);

}
