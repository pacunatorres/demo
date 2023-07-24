package com.ibc.backend.negocio.dto;

import java.util.List;
import com.ibc.backend.negocio.modelo.Ubigeo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDto {
	    private String nombres;
	    private String apellidos;
	    private String dni;
	    private String fechaNacimiento;
	    private String fechaCreacion;
	    private String sexo;
	    private String origen;
	    private PersonaDto madre;
	    private PersonaDto padre;
	    private PersonaDto apoderado;
	    private String estadocivil;
	    private PersonaDto conyugue;
	    private String fechabcivil;
	    private String lugarbcivil;
	    private String fechabreligioso;
	    private String lugarbreligioso;
	    private Boolean certificadoboda;
	    private String foto;
	    private String direccion;
	    private String urbanizacion;
	    private String etapa;
	    private Ubigeo ubigeo;
	    private String celular;
	    private String telefono;
	    private String email;
	    private String profesion;
	    private String grado;
	    private String nombreempresa;
	    private String cargoocupa;
	    private Boolean asistegc;
	    private Boolean bautizo;
	    private String condicion;
	    private String ministerio;
	    private String fechabautizo;
	    private Boolean bautizadoenibc;
	    private String discipulaa;
	    private String sede;
	    private String fechaconversion;
	    private String iglesiaprocedencia;
	    private String fechatransferencia;
	    
	    private List<HijoDto> listaHijos;
}