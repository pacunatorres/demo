package com.ibc.backend.admin.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ibc.backend.admin.modelo.Rol;

public interface RolRepository extends JpaRepository<Rol,Long> {
}
