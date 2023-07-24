package com.ibc.backend.negocio.service;

import java.util.List;

import com.ibc.backend.negocio.dto.PersonaDto;
import com.ibc.backend.negocio.dto.PersonaListarDto;
import com.ibc.backend.negocio.modelo.Persona;


public interface PersonaService {

	List<Persona> findAll();
	Persona save(PersonaDto n);
	void saveAll(List<Persona> list);
	List<Persona> findAll(PersonaListarDto persona);

	public List<Persona>  listar();
}
