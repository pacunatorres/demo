package com.ibc.backend.negocio.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HijoDto {
	    private String nombres;
	    private String apellidos;
	    private String dni;
	    private Date fechaNacimiento;
	    private String celular;
}