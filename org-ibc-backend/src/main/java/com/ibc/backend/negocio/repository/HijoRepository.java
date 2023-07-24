package com.ibc.backend.negocio.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ibc.backend.negocio.modelo.Hijo;

@Repository
public interface HijoRepository  extends JpaRepository<Hijo,Long> {
	List<Hijo> findByPadre(Long  idPather);

		   
}
