package com.ibc.backend.negocio.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "hijo")
@org.hibernate.annotations.Table(appliesTo = "hijo", comment = "Tabla principal de hijos")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Hijo implements Serializable {
	private static final long serialVersionUID = 1L;
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Long id;

	    @Column(name = "nombres")
	    private String nombres;
	    
	    @Column(name = "apellidos")
	    private String apellidos;

	    @Column(name = "padre")
	    private Long padre;
	    
	    @Column(name = "fecha_nacimiento")
	    private Date fechaNacimiento;
	    
	    @Column(name = "celular")
	    private String celular;
	    
	    
	    
	
}