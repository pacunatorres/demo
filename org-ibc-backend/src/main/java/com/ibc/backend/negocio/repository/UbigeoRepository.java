package com.ibc.backend.negocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.ibc.backend.negocio.modelo.Ubigeo;
import java.util.List;

@Repository
public interface UbigeoRepository extends JpaRepository<Ubigeo,Integer> {

    Ubigeo findByCodUbigeo(Integer codeUbigeo);

    @Query("select u from Ubigeo u where u.departament = :departament and u.province = :province and u.district = :district")
    List<Ubigeo> searchUbigeo(@Param("departament")String departament,
                              @Param("province")String province,
                              @Param("district")String district);
}
