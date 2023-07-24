package com.ibc.backend.negocio.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ibc.backend.negocio.dto.ExportExcel;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelHelper {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = {
    		"Empresa,aseguradora o fondo",
    		"Numero de solicitud",
            "Fecha y hora de creación de solicitud",
            "Tipo de documento del afiliado",
            "Número de documento del afiliado",
            
            "Nombres y Apellidos del afiliado",
            "Código del afiliado",
            "Número de póliza",
            "Plan de salud",
            "Nombres y Apellidos del paciente",
            
            "Tipo de documento del paciente",
            "Numero de documento del paciente",
            "Producto",
            "Empresa",
            "Al continuar autoriza la atencion del paciente",
            
            "% Cobertura del convenio",
            "Motivo de Cobertura de convenio",
            "Clínica",
            "Diagnóstico",
            "# adjuntos ",
            
            "Indicar si la entrega de la receta es obligatoria",
            "Atención de medicamentos",
            "Pautas para la atención",
            "Número principal del afiliado",
            "Número adicional del afiliado",
            
            "Dirección del afiliado",
            "Fecha llamada",
            "Solicitud urgente",
            "Asignado",
            "Usuario Asignado",
            
            "Usuario que registro la llamada",
            //"Estado", (QUITAR  campo)
            "Nombre del convenio asignado",
            "Fecha y hora de registro de la llamada",
            //"Usuario que registro la llamada", (QUITAR CAMPO)
            "Tipo de atención en la llamada",
            "Resultado de la llamada"};

    static String SHEET = "Convenios";

    public static ByteArrayInputStream tutorialsToExcel(List<ExportExcel> exportExcelList) {

        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet(SHEET);

            // Header
            Row headerRow = sheet.createRow(0);

            for (int col = 0; col < HEADERs.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(HEADERs[col]);
            }

            int rowIdx = 1;
            for (ExportExcel exportExcel : exportExcelList) {
                Row row = sheet.createRow(rowIdx++);
//                row.createCell(0).setCellValue(exportExcel.getEmpasefondo()); //agregado
                row.createCell(1).setCellValue(exportExcel.getNumber());
                row.createCell(2).setCellValue(exportExcel.getCreateAt());
                row.createCell(3).setCellValue(exportExcel.getTypeDocumentAffiliate());
                row.createCell(4).setCellValue(exportExcel.getNumDocumentAffiliate());
                row.createCell(5).setCellValue(exportExcel.getFullName()); //inver
                row.createCell(6).setCellValue(exportExcel.getCodeAfiliate());//inver
                row.createCell(7).setCellValue(exportExcel.getPoliza());
                row.createCell(8).setCellValue(exportExcel.getHealPLan());
                row.createCell(9).setCellValue(exportExcel.getFullNameTitular());
                row.createCell(10).setCellValue(exportExcel.getTypeDocumentTitular());
                row.createCell(11).setCellValue(exportExcel.getDniTitular());
                row.createCell(12).setCellValue(exportExcel.getProduct());
//                row.createCell(13).setCellValue(exportExcel.getEmpresa());// agregado
                row.createCell(14).setCellValue(exportExcel.getAutorization());
                row.createCell(15).setCellValue(exportExcel.getCoverage2());
                row.createCell(16).setCellValue(exportExcel.getClinic());
//                row.createCell(17).setCellValue(exportExcel.getMotivoConverturaConvenio());// agregado
                row.createCell(18).setCellValue(exportExcel.getDiagnostic());
                row.createCell(19).setCellValue(exportExcel.getQuantityDocuments());
                
//                row.createCell(20).setCellValue(exportExcel.getMandatoryRecipe());// agregado -
                row.createCell(21).setCellValue(exportExcel.getTypeAttention());
                row.createCell(22).setCellValue(exportExcel.getSteps());
                row.createCell(23).setCellValue(exportExcel.getPhoneAffiliate());
//                row.createCell(24).setCellValue(exportExcel.getPhoneSecond());// agregado
                row.createCell(25).setCellValue(exportExcel.getAddresAffiliate());
                row.createCell(26).setCellValue(exportExcel.getDayContact());
//                row.createCell(22).setCellValue(exportExcel.getTurnContact());
                row.createCell(27).setCellValue(exportExcel.getUrgent());
                row.createCell(28).setCellValue(exportExcel.getAsigned());
                row.createCell(29).setCellValue(exportExcel.getUserASigned());
//                row.createCell(30).setCellValue(exportExcel.getUserRegistering());// agregado
//                row.createCell(31).setCellValue(exportExcel.getNombreConvenio());// agregado
//                row.createCell(32).setCellValue(exportExcel.getCallRegister());(QUITANDO)
                row.createCell(32).setCellValue(exportExcel.getDateCall());
//                row.createCell(34).setCellValue(exportExcel.getUserCall());(QUITANDO)
                row.createCell(33).setCellValue(exportExcel.getTypeAttentionCall());
                row.createCell(34).setCellValue(exportExcel.getResultAttention());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("fail to import data to Excel file: " + e.getMessage());
        }
    }
}