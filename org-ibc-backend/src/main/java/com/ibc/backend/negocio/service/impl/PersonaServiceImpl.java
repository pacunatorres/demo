package com.ibc.backend.negocio.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibc.backend.negocio.dto.PersonaDto;
import com.ibc.backend.negocio.dto.PersonaListarDto;
import com.ibc.backend.negocio.mapper.GeneralMapper;
import com.ibc.backend.negocio.modelo.Parametro;
import com.ibc.backend.negocio.modelo.Persona;
import com.ibc.backend.negocio.repository.HijoRepository;
import com.ibc.backend.negocio.repository.ParametroRepository;
import com.ibc.backend.negocio.repository.PersonaRepository;
import com.ibc.backend.negocio.service.PersonaService;


@Service
public class PersonaServiceImpl implements  PersonaService, Serializable {
	@Autowired
    private PersonaRepository personaRepository;
	@Autowired
    private ParametroRepository parametroRepository;
	@Autowired
    private HijoRepository hijoRepository;
    @Override
    public List<Persona> findAll() {
        return personaRepository.findAll();
    }

	@Override
	public Persona save(PersonaDto n) {
		Persona personabd =  personaRepository.findByDni(n.getDni());
		System.out.println("nndd == "+n);
		System.out.println("personabd = ");
			Persona persona = GeneralMapper.personaDtoToPersona(n,personaRepository,parametroRepository,hijoRepository,personabd);
			System.out.println("persona:: = ");
			
			return persona;
	}
	public Persona update(Persona n) {
		if(n==null) {
			return null;
		}
		Persona persona =  personaRepository.findByDni(n.getDni());
		if(persona!=null)
		{
			persona.setNombres(n.getNombres());
			persona.setTelefono(n.getTelefono());
			persona.setCelular(n.getCelular());
			return personaRepository.save(persona);}
		else {
			return personaRepository.save(n);
		}
	}
	
	public Parametro update(Parametro n) {
		if(n==null) {
			return null;
		}
		Parametro parametro =  parametroRepository.findByDesParametro(n.getDesParametro());
		if(parametro!=null)
		{return parametroRepository.save(parametro);}
		else {
			return parametroRepository.save(n);
		}
	}


	@Override
	@Transactional
	public void saveAll(List<Persona> lista) {
		personaRepository.saveAll(lista);
	}

	@Override
	public List<Persona> findAll(PersonaListarDto persona) {
		List<String> lista = new ArrayList<String>();
		lista.add(persona.getCondicion());
		lista.add(persona.getMinisterio());
		lista.add(persona.getSede());
		lista.add(persona.getSituacion());
		System.out.println("lista = "+lista);
		List<Parametro> listaParametros = parametroRepository.findByDesParametroIn(lista);
		List<Parametro> ministerio = null;
		List<Parametro> condicion = null;
		List<Parametro> sede = null;
		List<Parametro> situacion = null;
		Long ministerioId = null;
		Long condicionId = null;
		Long sedeId = null;
		Long situacionId = null;
		System.out.println("ministerio11 = "+ministerio);
		if(persona.getMinisterio()!=null)
		ministerio =  listaParametros.stream().filter(c-> c.getDesParametro().contains(persona.getMinisterio()))
				.collect(Collectors.toList());
		if(persona.getCondicion()!=null)
			condicion =  listaParametros.stream().filter(c-> c.getDesParametro().contains(persona.getCondicion()))
					.collect(Collectors.toList());
		if(persona.getSede()!=null)
			sede =  listaParametros.stream().filter(c-> c.getDesParametro().contains(persona.getSede()))
					.collect(Collectors.toList());
		if(persona.getSituacion()!=null)
			situacion =  listaParametros.stream().filter(c-> c.getDesParametro().contains(persona.getSituacion()))
					.collect(Collectors.toList());
		
		System.out.println("ministerio = "+ministerio);
		if(ministerio!=null && ministerio.size()>0) {
			ministerioId = ministerio.get(0).getId();
		}
		
		if(condicion!=null && condicion.size()>0) {
			condicionId = condicion.get(0).getId();
		}
		if(sede!=null && sede.size()>0) {
			sedeId = sede.get(0).getId();
		}
		if(situacion!=null && situacion.size()>0) {
			situacionId = situacion.get(0).getId();
		}
//		return personaRepository.findByMinisterioIdOrCondicionId(ministerioId, condicionId);
		return personaRepository.findByMinisterioIdAndCondicionIdAndSedeIdAndSituacionId(ministerioId, condicionId, sedeId, situacionId);
	}

	

	public List<Persona>  listar() {
		
		
		return  personaRepository.findByEstado(Long.parseLong("1"));
		
	}
}
