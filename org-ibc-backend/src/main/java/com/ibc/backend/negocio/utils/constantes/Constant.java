package com.ibc.backend.negocio.utils.constantes;

public class Constant {

    private Constant() {
        throw new IllegalStateException("Constant class");
    }

    /* UTILIDADES */
    public static final String POST_PATH = "%s/%s";
    public static final String SEPARATOR_SPLIT = "-";
    public static final String EXTENSION_POINT = ".";
    public static final long EXPIRATION_DAYS = 1;
    public static final String STATUS_SUCESSFUL = "successful";

    /* REGEX */
    public static final String VALIDATE_FILE_NAME = "^[0-9a-zA-Z]{2,20}(-)[0-9a-zA-Z]{2,20}(-)[0-9a-zA-Z.]{2,20}$";

    /* ESTADOS DOCUMENTOS/ARCHIVOS */
    public static final String POR_VALIDAR_STATE = "Por validar";

    /* CANALES */
    public static final String CANAL_MOVIL = "CM";
    public static final String CANAL_AUTOMY = "CA";

    public static final String STATUS_BAD_REQUEST_VALID = "El campo %s %s";
    public static final String STATUS_ERROR_CD = "No se pudo procesar el pedido.";

    /* BAD REQUEST MESSAGE */
    public static final String BR_CANAL_MESSAGE = "No se pudo encontra el canal: '%s'";
    public static final String BR_DOCUMENTO_MESSAGE = "No se pudo encontrar el documento: '%s'";
    public static final String BR_ARCHIVO_MESSAGE = "No se pudo encontra el archivo: '%s'";
    public static final String BR_STATUS_MESSAGE = "No se pudo encontrar el codigo de estado: '%s'";

}
