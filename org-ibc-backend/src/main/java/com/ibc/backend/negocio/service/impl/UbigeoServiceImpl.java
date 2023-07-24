package com.ibc.backend.negocio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ibc.backend.negocio.modelo.Ubigeo;
import com.ibc.backend.negocio.repository.UbigeoRepository;
import com.ibc.backend.negocio.service.UbigeoService;

import java.util.List;

@Service
public class UbigeoServiceImpl implements UbigeoService {

    @Autowired
    private UbigeoRepository ubigeoRepository;

    @Override
    public Ubigeo findByCodUbigeo(Integer codeUbigeo) {
        return ubigeoRepository.findByCodUbigeo(codeUbigeo);
    }

    @Override
    public Ubigeo findUbigeo(String departament,String province,String district) {

        List<Ubigeo> ubigeoList =ubigeoRepository.searchUbigeo(departament,province,district);

        return ubigeoList.get(0);
    }
}
