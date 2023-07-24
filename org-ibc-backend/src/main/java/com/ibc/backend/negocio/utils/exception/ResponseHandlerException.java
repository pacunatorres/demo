package com.ibc.backend.negocio.utils.exception;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.ibc.backend.negocio.utils.constantes.ConstantStatus;
import com.ibc.backend.negocio.utils.constantes.StatusEnum;
import com.ibc.backend.negocio.utils.response.Response;

@RestControllerAdvice
@Slf4j
public class ResponseHandlerException {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ApiResponse(
            responseCode = "400",
            description = "Falta parametros de entrada.",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = Response.class),
                    examples = { @ExampleObject(value = "" +
                            "{" +
                            "   \"status\": \"Error\"," +
                            "   \"statusCode\": 400," +
                            "   \"error\": {" +
                            "       \"errorMessage\": \"La solicitud posee una sintaxis incorrecta o falta parametro(s) requerido(s).\"" +
                            "   }" +
                            "}") }
            )
    )
    public final <T> ResponseEntity<Response<T>> handleBadRequest(final BadRequestException e) {
        StatusEnum statusEnum = StatusEnum.getStatus(ConstantStatus.STATUS_400);
        log.error("errorMessage: {}", e.getMessage());
        log.error("errorStackTrace: {}", e.getStackTrace());
        return new ResponseEntity<>(Response.responseHandle(statusEnum), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ApiResponse(
            responseCode = "401",
            description = "Autorizacion denegada / token incorrecto.",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = Response.class),
                    examples = { @ExampleObject(value = "" +
                            "{" +
                            "   \"status\": \"Error\"," +
                            "   \"statusCode\": 401," +
                            "   \"error\": {" +
                            "       \"errorMessage\": \"Token de autenticación no encontrado o no autorizado.\"" +
                            "   }" +
                            "}") }
            )
    )
    public final <T> ResponseEntity<Response<T>> handleNotFound(final UnauthorizedException e) {
        StatusEnum statusEnum = StatusEnum.getStatus(ConstantStatus.STATUS_401);
        log.error("errorMessage: {}", e.getMessage());
        log.error("errorStackTrace: {}", e.getStackTrace());
        return new ResponseEntity<>(Response.responseHandle(statusEnum), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ApiResponse(
            responseCode = "404",
            description = "Recurso solicitado no encontrado.",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = Response.class),
                    examples = { @ExampleObject(value = "" +
                            "{" +
                            "   \"status\": \"Error\"," +
                            "   \"statusCode\": 404," +
                            "   \"error\": {" +
                            "       \"errorMessage\": \"El servidor no puede encontrar el recurso solicitado.\"" +
                            "   }" +
                            "}") }
            )
    )
    public final <T> ResponseEntity<Response<T>> handleNotFound(final NotFoundException e) {
        StatusEnum statusEnum = StatusEnum.getStatus(ConstantStatus.STATUS_404);
        log.error("errorMessage: {}", e.getMessage());
        log.error("errorStackTrace: {}", e.getStackTrace());
        return new ResponseEntity<>(Response.responseHandle(statusEnum), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ApiResponse(
            responseCode = "500",
            description = "Error interno por funcionalidad.",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = Response.class),
                    examples = { @ExampleObject(value = "" +
                            "{" +
                            "   \"status\": \"Error\"," +
                            "   \"statusCode\": 500," +
                            "   \"error\": {" +
                            "       \"errorMessage\": \"Se ha producido un error interno en el servidor.\"" +
                            "   }" +
                            "}") }
            )
    )
    public final <T> ResponseEntity<Response<T>> handleException(final Exception e) {
        StatusEnum statusEnum = StatusEnum.getStatus(ConstantStatus.STATUS_500);
        log.error("errorMessage: {}", e.getMessage());
        log.error("errorStackTrace: {}", e.getStackTrace());
        return new ResponseEntity<>(Response.responseHandle(statusEnum), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

