package com.ibc.backend.negocio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ibc.backend.negocio.modelo.Persona;

@Repository
public interface PersonaRepository  extends JpaRepository<Persona,Long> {
	Persona findByDni(String  dni);
	List<Persona> findByMinisterioId(Long   ministerio);
	List<Persona> findByMinisterioIdOrCondicionIdOrSedeIdOrSituacionId(Long   ministerio, Long condicion
			, Long sede, Long situacion);
    @Query("select distinct a from Persona a where ( :ministerio is null or  a.ministerio.id = :ministerio )  and ( :condicion is null or a.condicion.id = :condicion )" +
            " and ( :sede is null or  a.sede.id = :sede )  and       ( :situacion is null or  a.situacion.id = :situacion ) ")
    List<Persona> findByMinisterioIdAndCondicionIdAndSedeIdAndSituacionId(@Param("ministerio") Long ministerio,
                                    @Param("condicion") Long condicion,
                                    @Param("sede") Long sede,
                                    @Param("situacion") Long situacion
    		);  
    
    List<Persona> findByEstado( Long estado);
}
