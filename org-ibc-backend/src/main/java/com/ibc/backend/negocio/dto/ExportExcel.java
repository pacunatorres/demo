package com.ibc.backend.negocio.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExportExcel {

    private String number;
    private String createAt;
    private String typeDocumentAffiliate;
    private String numDocumentAffiliate;
    private String codeAfiliate;
    private String fullName;
    private String poliza;
    private String healPLan;
    private String fullNameTitular;
    private String typeDocumentTitular;
    private String dniTitular;
    private String product;
    private String autorization;
    private String coverage1;
    private String coverage2;
    private String clinic;
    private String diagnostic;
    private String datePrescription;
    private String steps;
    private String typePrescription;
    private Integer quantityDocuments;
    private String typeAttention;
    private String phoneAffiliate;
    private String addresAffiliate;
    private String dayContact;
    private String turnContact;
    private String urgent;

    private String state;
    private String asigned;
    private String userASigned;
    private String callRegister;
    private String dateCall;
    private String userCall;
    private String typeAttentionCall;
    private String resultAttention;
}
