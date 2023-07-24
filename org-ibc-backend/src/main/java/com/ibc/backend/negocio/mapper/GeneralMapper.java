package com.ibc.backend.negocio.mapper;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import com.ibc.backend.negocio.dto.HijoDto;
import com.ibc.backend.negocio.dto.PersonaDto;
import com.ibc.backend.negocio.modelo.Hijo;
import com.ibc.backend.negocio.modelo.Parametro;
import com.ibc.backend.negocio.modelo.Persona;
import com.ibc.backend.negocio.repository.HijoRepository;
import com.ibc.backend.negocio.repository.ParametroRepository;
import com.ibc.backend.negocio.repository.PersonaRepository;
import com.ibc.backend.negocio.utils.Utils;


public class GeneralMapper {


    private static String setTime(Date firstDate) {
			Date secondDate = new Date();
			 long diff = secondDate.getTime() - firstDate.getTime();
			 TimeUnit time = TimeUnit.SECONDS; 
		     long diffrence = time.convert(diff, TimeUnit.MILLISECONDS);
		     String  mensaje = "";
		     if(diffrence<100) {
		    	 mensaje = diffrence +" seg";
		     }else if(diffrence/60 <100) {
		    	 mensaje = diffrence/60 +" min";
		     }else if(diffrence/3600 <100) {
		    	 mensaje = diffrence/3600 +" hrs";
		     }else  {
		    	 mensaje = diffrence/(3600*24) +" days";
		     }
		     return mensaje;
		     
    }
    
    public  static Persona personaDtoToPersona(PersonaDto p, PersonaRepository personaRepository ,ParametroRepository parametroRepository ,HijoRepository hijoRepository 
    		, Persona per) {
    	System.out.println("p.getListaHijos = "+p.getListaHijos());
    	
    	try {
    		System.out.println("p.perper3 d= ");
//    		System.out.println("p.perper = "+per);
    		System.out.println("p.perper 3d= ");
    	if(per==null) {
    		
    		Persona persona =   Persona.builder()
        	    	.apellidos(p.getApellidos())
        	    	.apoderado(personaDtoToPersonaObj(p.getApoderado(),personaRepository))
        	    	.asistegc(p.getAsistegc())
        	    	.bautizadoenibc(p.getBautizadoenibc())
        	    	.bautizo(p.getBautizo())
        	    	.cargoocupa(p.getCargoocupa())
        	    	.celular(p.getCelular())
        	    	.certificadoboda(p.getCertificadoboda())
        	    	.condicion(addParam(p.getCondicion(),parametroRepository))
        	    	.direccion(p.getDireccion())
        	    	.discipulaa(p.getDiscipulaa())
        	    	.dni(p.getDni())
        	    	.email(p.getEmail())
        	    	.estadocivil(addParam(p.getEstadocivil(),parametroRepository))
        	    	.etapa(p.getEtapa())
        	    	.fechabautizo(Utils.stringToDate(p.getFechabautizo()))
        	    	.fechabcivil(Utils.stringToDate(p.getFechabcivil()))
        	    	.fechabreligioso(Utils.stringToDate(p.getFechabreligioso()))
        	    	.fechaconversion(Utils.stringToDate(p.getFechaconversion()))
        	    	.fechaNacimiento(Utils.stringToDate(p.getFechaNacimiento()))
        	    	.fechatransferencia(Utils.stringToDate(p.getFechatransferencia()))
        	    	.foto(p.getFoto())
        	    	.grado(p.getGrado())
        	    	.iglesiaprocedencia(p.getIglesiaprocedencia())
        	    	.lugarbcivil(p.getLugarbcivil())
        	    	.lugarbreligioso(p.getLugarbreligioso())
        	    	.madre(personaDtoToPersonaObj(p.getMadre(),personaRepository))
        	    	.ministerio(addParam(p.getMinisterio(),parametroRepository))
        	    	.nombreempresa(p.getNombreempresa())
        	    	.nombres(p.getNombres())
        	    	.origen(addParam(p.getOrigen(),parametroRepository))
        	    	.padre(personaDtoToPersonaObj(p.getPadre(),personaRepository))
        	    	.profesion(p.getProfesion())
        	    	.sede(addParam(p.getSede(),parametroRepository))
        	    	.sexo(addParam(p.getSexo(),parametroRepository))
        	    	.telefono(p.getTelefono())
        	    	.urbanizacion(p.getUrbanizacion())
        	    	.build();
    		 persona = personaRepository.save(persona);
        	addHijos(persona.getId() , hijoRepository , p.getListaHijos());
        	return persona;
    	}else {
    		System.out.println("p.perperttt= ");
    		addHijos(per.getId() , hijoRepository , p.getListaHijos());
    		Persona persona = 
        	 Persona.builder()
        			.id(per.getId())
        	    	.apellidos(p.getApellidos())
        	    	.apoderado(personaDtoToPersonaObj(p.getApoderado(),personaRepository))
        	    	.asistegc(p.getAsistegc())
        	    	.bautizadoenibc(p.getBautizadoenibc())
        	    	.bautizo(p.getBautizo())
        	    	.cargoocupa(p.getCargoocupa())
        	    	.celular(p.getCelular())
        	    	.certificadoboda(p.getCertificadoboda())
        	    	.condicion(addParam(p.getCondicion(),parametroRepository))
        	    	.direccion(p.getDireccion())
        	    	.discipulaa(p.getDiscipulaa())
        	    	.dni(p.getDni())
        	    	.email(p.getEmail())
        	    	.estadocivil(addParam(p.getEstadocivil(),parametroRepository))
        	    	.etapa(p.getEtapa())
        	    	.fechabautizo(Utils.stringToDate(p.getFechabautizo()))
        	    	.fechabcivil(Utils.stringToDate(p.getFechabcivil()))
        	    	.fechabreligioso(Utils.stringToDate(p.getFechabreligioso()))
        	    	.fechaconversion(Utils.stringToDate(p.getFechaconversion()))
        	    	.fechaNacimiento(Utils.stringToDate(p.getFechaNacimiento()))
        	    	.fechatransferencia(Utils.stringToDate(p.getFechatransferencia()))
        	    	.foto(p.getFoto())
        	    	.grado(p.getGrado())
        	    	.iglesiaprocedencia(p.getIglesiaprocedencia())
        	    	.lugarbcivil(p.getLugarbcivil())
        	    	.lugarbreligioso(p.getLugarbreligioso())
        	    	.madre(personaDtoToPersonaObj(p.getMadre(),personaRepository))
        	    	.ministerio(addParam(p.getMinisterio(),parametroRepository))
        	    	.nombreempresa(p.getNombreempresa())
        	    	.nombres(p.getNombres())
        	    	.origen(addParam(p.getOrigen(),parametroRepository))
        	    	.padre(personaDtoToPersonaObj(p.getPadre(),personaRepository))
        	    	.profesion(p.getProfesion())
        	    	.sede(addParam(p.getSede(),parametroRepository))
        	    	.sexo(addParam(p.getSexo(),parametroRepository))
        	    	.telefono(p.getTelefono())
        	    	.urbanizacion(p.getUrbanizacion())
        	    	.build();
    		System.out.println("p.savee= ");
    		personaRepository.save(persona);
    		System.out.println("p.saveeddd= ");
    		return persona;
    	}
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
    	return null;

    	

    }
    
    public  static Parametro addParam(String  descripcion, ParametroRepository parametroRepository) {

    	Parametro param = parametroRepository.findByDesParametro(descripcion);
    	if(param==null) {
    		Parametro par = new Parametro();
    		par.setDesParametro(descripcion);
    		return parametroRepository.save(par);
    	}else {
    		return param;
    	}
    }
    public  static void  addHijos(Long  idPather, HijoRepository hijoRepository , List<HijoDto> listaHijos) {
        	List<Hijo> hijosListaBD = hijoRepository.findByPadre(idPather );
        	System.out.println("hijosListaBD= "+hijosListaBD);
    	 List<Hijo> hijosListaIN = new ArrayList<Hijo>();
    	
    	 if(listaHijos!=null)
    	listaHijos.stream() .filter( h -> !hijosListaBD.stream().map(p-> p.getNombres()).collect(Collectors.toList()).contains(h.getNombres()))
    	.forEach( e-> {
    		Hijo hijo = new Hijo();
    		hijo.setApellidos(e.getApellidos());
    		hijo.setNombres(e.getNombres());
    		hijo.setPadre(idPather);
    		hijo.setCelular(e.getCelular());
    		hijo.setFechaNacimiento(e.getFechaNacimiento());
    		hijosListaIN.add(hijo);
    		
    	
    });
    	 System.out.println("listaString=ee ");
    	
    	hijoRepository.saveAll(hijosListaIN);
    	 System.out.println("listaString=edde ");
    	if(listaHijos!=null) {
    		System.out.println("listaString=edrrrde ");
        	List<String> listaString = listaHijos.stream().map(m -> m.getNombres()).collect(Collectors.toList());
        	System.out.println("listaString= "+listaString);
        	List<Hijo> hijosListaUpdate= hijosListaBD.stream().filter(f -> listaString.contains(f.getNombres()))
        	.peek(k -> {
        		System.out.println("nombre= "+k.getNombres());
        		HijoDto hijoDto = listaHijos.stream().filter( e-> e.getNombres().contentEquals(k.getNombres())).collect(Collectors.toList()).get(0);
        		k.setCelular(hijoDto.getCelular());
        		k.setFechaNacimiento(hijoDto.getFechaNacimiento());
        		k.setApellidos(hijoDto.getApellidos());
        	}).collect(Collectors.toList());
        	System.out.println("hijosListaUpdate= "+hijosListaUpdate.size());
        	hijoRepository.saveAll(hijosListaUpdate);
    	}
    	System.out.println("listaString=333 ");
    	
    }
    public  static Persona personaDtoToPersonaObj(PersonaDto  personaDto, PersonaRepository personaRepository) {
    	if(personaDto==null) {
    		return null;
    	}
    	
    	Persona personabd = personaRepository.findByDni(personaDto.getDni());
    	if(personabd==null) {
    		return  personaRepository.save(Persona.builder().dni(personaDto.getDni())
    		.nombres(personaDto.getNombres())
    		.apellidos(personaDto.getApellidos())
    		.telefono(personaDto.getTelefono())
    		.celular(personaDto.getCelular())
    		.build());
    	}else {
    		personabd.setApellidos(personaDto.getApellidos());
    		personabd.setNombres(personaDto.getNombres());
    		personabd.setTelefono(personaDto.getTelefono());
    		personabd.setCelular(personaDto.getCelular());
    		return personaRepository.save(personabd);
    	}
    }
    public  static Persona HijoDtoToPersonaObj(PersonaDto  personaDto, PersonaRepository personaRepository) {
    	if(personaDto==null) {
    		return null;
    	}
    	
    	Persona personabd = personaRepository.findByDni(personaDto.getDni());
    	if(personabd==null) {
    		return  personaRepository.save(Persona.builder().dni(personaDto.getDni())
    		.nombres(personaDto.getNombreempresa())
    		.telefono(personaDto.getTelefono())
    		.celular(personaDto.getCelular())
    		.build());
    	}else {
    		personabd.setNombres(personaDto.getNombres());
    		personabd.setTelefono(personaDto.getTelefono());
    		personabd.setCelular(personaDto.getCelular());
    		return personaRepository.save(personabd);
    	}
    }
    
    public  static Persona hijosLista(PersonaDto  personaDto) {
    	if(personaDto.getListaHijos()==null) {
    		return null;
    	}
    	List<Persona> lista = new ArrayList<Persona>();
    	personaDto.getListaHijos().forEach( e-> {
    		
    		Persona.builder()
    		.apellidos(e.getApellidos())
    		.nombres(e.getNombres())
    		.celular(e.getCelular())
    		.dni(e.getDni())
    		.fechaNacimiento(e.getFechaNacimiento())
    		.build();
    		
    		
    	});
    	
    	
   
    		return  Persona.builder().dni(personaDto.getDni())
    		.nombres(personaDto.getNombreempresa())
    		.telefono(personaDto.getTelefono())
    		.celular(personaDto.getCelular())
    		.build();
    	
    }
    
    
    
}
