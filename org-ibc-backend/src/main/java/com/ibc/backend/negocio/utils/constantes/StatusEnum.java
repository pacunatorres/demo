package com.ibc.backend.negocio.utils.constantes;

import lombok.Getter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.ibc.backend.negocio.utils.exception.BadRequestException;

@Getter
public enum StatusEnum {

    STATUS_200("OK", "Ok", 200, null),
    STATUS_201("CREATED", "Successful operation", 201, null),
    STATUS_204("NO_CONTENT", "Ok", 204, null),
    STATUS_400("BAD_REQUEST", "Error", 400, "La solicitud posee una sintaxis incorrecta o falta parametro(s) requerido(s)."),
    STATUS_401("UNAUTHORIZED", "Error", 401, "Token de autenticación no encontrado o no autorizado."),
    STATUS_404("NOT_FOUND", "Error", 404, "El servidor no puede encontrar el recurso solicitado."),
    STATUS_500("INTERNAL_SERVER_ERROR", "Error", 500, "Se ha producido un error interno en el servido.");

    private String type;
    private String status;
    private Integer statusCode;
    private String errorMessage;

    StatusEnum(String type, String status, Integer statusCode, String errorMessage) {
        this.type = type;
        this.status = status;
        this.statusCode = statusCode;
        this.errorMessage = errorMessage;
    }

    private static final Map<Integer, StatusEnum> CONSTANTS_STATUS = new HashMap<>();

    static {
        for (StatusEnum s: values()) {
            CONSTANTS_STATUS.put(s.statusCode, s);
        }
    }

    public static StatusEnum getStatus(Integer statusCode) {
        StatusEnum statusEnum = CONSTANTS_STATUS.get(statusCode);
        if (Objects.isNull(statusEnum)) {
            throw new BadRequestException(String.format(Constant.BR_STATUS_MESSAGE, statusCode));
        }
        return statusEnum;
    }

    public static StatusEnum getStatus(Integer statusCode, String status) {
        StatusEnum statusEnum = CONSTANTS_STATUS.get(statusCode);
        if (Objects.isNull(statusEnum)) {
            throw new BadRequestException(String.format(Constant.BR_STATUS_MESSAGE, statusCode));
        }
        statusEnum.status = status;
        return statusEnum;
    }

}
