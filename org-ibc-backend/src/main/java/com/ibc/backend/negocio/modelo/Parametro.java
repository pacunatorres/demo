package com.ibc.backend.negocio.modelo;

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
@Table(name = "parametro")
@org.hibernate.annotations.Table(appliesTo = "parametro", comment = "Tabla principal de parametros")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Parametro {

	private static final long serialVersionUID = 1L;
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Long id;

	   @Column(name = "id_pather")
	    private String idPather;
	    
	    
	    @Column(name = "tip_parametro")
	    private String tipParametro;
	    
	    @Column(name = "cod_parametro")
	    private String codParametro;
	    
	    @Column(name = "des_parametro")
	    private String desParametro;
	    

}
