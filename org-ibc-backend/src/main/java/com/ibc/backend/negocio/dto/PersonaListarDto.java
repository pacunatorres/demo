package com.ibc.backend.negocio.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonaListarDto {
	    private String sede;
	    private String ministerio;
	    private String condicion;
	    private String situacion;
}