package com.ibc.backend.negocio.service;

import com.ibc.backend.negocio.modelo.Ubigeo;
public interface UbigeoService {

    Ubigeo findByCodUbigeo(Integer codeUbigeo);

    Ubigeo findUbigeo(String departament,String province,String district);
}
