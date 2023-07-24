package com.ibc.backend.negocio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ibc.backend.negocio.modelo.Parametro;
@Repository
public interface ParametroRepository extends JpaRepository<Parametro,Long> {
	Parametro findByDesParametro(String desParametro);
	
	List<Parametro> findByDesParametroIn(List<String> desParametro);
}
