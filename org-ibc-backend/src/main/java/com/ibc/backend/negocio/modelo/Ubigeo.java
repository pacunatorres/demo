package com.ibc.backend.negocio.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "ubigeo")
@org.hibernate.annotations.Table(appliesTo = "ubigeo", comment = "Tabla general de ubigeos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ubigeo implements Serializable {

    @Id
    @Column(name = "cod_ubigeo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codUbigeo;

    @Column(name = "departament")
    private String departament;

    @Column(name = "province")
    private String province;

    @Column(name = "district")
    private String district;
}
