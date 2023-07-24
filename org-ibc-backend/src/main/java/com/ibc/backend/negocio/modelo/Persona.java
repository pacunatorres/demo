package com.ibc.backend.negocio.modelo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "persona")
@org.hibernate.annotations.Table(appliesTo = "persona", comment = "Tabla principal de persona")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Long id;

	    @Column(name = "nombres")
	    private String nombres;
	    
	    @Column(name = "apellidos")
	    private String apellidos;
	    
	    @Column(name = "dni")
	    private String dni;
	    

	    @Column(name = "fechaNacimiento")
	    private Date fechaNacimiento;
	    
	    @CreatedDate
	    @Column(name = "fechaCreacion")
	    private Date fechaCreacion;
	    
	    
	    @ManyToOne
	    @JoinColumn(name = "sexo", referencedColumnName = "id")
	    private Parametro sexo;
	    
	    @ManyToOne
	    @JoinColumn(name = "origen", referencedColumnName = "id")
	    private Parametro origen;
	    
	    @ManyToOne
	    @JoinColumn(name = "madre", referencedColumnName = "id")
	    private Persona madre;
	    
	    @ManyToOne
	    @JoinColumn(name = "padre", referencedColumnName = "id")
	    private Persona padre;
	    
	    @ManyToOne
	    @JoinColumn(name = "apoderado", referencedColumnName = "id")
	    private Persona apoderado;
	    
	    @ManyToOne
	    @JoinColumn(name = "estadocivil", referencedColumnName = "id")
	    private Parametro estadocivil;

	    @ManyToOne
	    @JoinColumn(name = "conyugue", referencedColumnName = "id")
	    private Persona conyugue;
	    
	    @Column(name = "fechabcivil")
	    private Date fechabcivil;
	    
	    @Column(name = "lugarbcivil")
	    private String lugarbcivil;
	    
	    @Column(name = "fechabreligioso")
	    private Date fechabreligioso;
	    
	    @Column(name = "lugarbreligioso")
	    private String lugarbreligioso;
	    
	    @Column(name = "certificadoboda")
	    private Boolean certificadoboda;
	    
	    @Column(name = "foto")
	    private String foto;
	    
	    @Column(name = "direccion")
	    private String direccion;
	    
	    @Column(name = "urbanizacion")
	    private String urbanizacion;
	    
	    @Column(name = "etapa")
	    private String etapa;
	    
	    @ManyToOne
	    @JoinColumn(name = "ubigeo", referencedColumnName = "cod_ubigeo")
	    private Ubigeo ubigeo;
	    
	    @Column(name = "celular")
	    private String celular;
	    
	    @Column(name = "telefono")
	    private String telefono;
	    
	    @Column(name = "email")
	    private String email;
	    
	    @Column(name = "profesion")
	    private String profesion;
	    
	    @Column(name = "grado")
	    private String grado;
	    
	    @Column(name = "nombreempresa")
	    private String nombreempresa;
	    
	    @Column(name = "cargoocupa")
	    private String cargoocupa;
	    
	    @Column(name = "asistegc")
	    private Boolean asistegc;
	    
	    @Column(name = "bautizo")
	    private Boolean bautizo;
	    
	    @ManyToOne
	    @JoinColumn(name = "condicion", referencedColumnName = "id")
	    private Parametro condicion;
	    
//	    @ManyToOne
//	    @JoinColumn(name = "discipulador", referencedColumnName = "id")
//	    private Parametro discipulador;
	    
	    @ManyToOne
	    @JoinColumn(name = "ministerio", referencedColumnName = "id")
	    private Parametro ministerio;
	    
	    @Column(name = "fechabautizo")
	    private Date fechabautizo;
	    
	    @Column(name = "bautizadoenibc")
	    private Boolean bautizadoenibc;
	    
	    
	    @Column(name = "discipulaa")
	    private String discipulaa;

	    
	    @ManyToOne
	    @JoinColumn(name = "sede", referencedColumnName = "id")
	    private Parametro sede;
	    
	    @Column(name = "fechaconversion")
	    private Date fechaconversion;
	    
	    @Column(name = "iglesiaprocedencia")
	    private String iglesiaprocedencia;
	    
	    
	    @Column(name = "fechatransferencia")
	    private Date fechatransferencia;
	    
	    @ManyToOne
	    @JoinColumn(name = "situacion", referencedColumnName = "id")
	    private Parametro situacion;
	    
	    
	    @Column(name = "estado")
	    private Long estado;

}