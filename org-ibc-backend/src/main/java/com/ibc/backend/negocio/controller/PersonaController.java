package com.ibc.backend.negocio.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ibc.backend.negocio.dto.PersonaDto;
import com.ibc.backend.negocio.dto.PersonaListarDto;
import com.ibc.backend.negocio.modelo.Persona;
import com.ibc.backend.negocio.service.PersonaService;
import com.ibc.backend.negocio.utils.constantes.ConstantStatus;
import com.ibc.backend.negocio.utils.constantes.StatusEnum;
import com.ibc.backend.negocio.utils.response.Response;
import com.ibc.backend.negocio.utils.response.ResponseList;

@RestController
@RequestMapping("/persona")
@CrossOrigin("*")
@AllArgsConstructor
@Tag(name = "persona-controller", description = "Controlador de los personas")
@Slf4j
public class PersonaController {
    private final PersonaService personaService;

    @Operation(description = "## Funcionalidad\nEsta operación inserta las personas \n",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Cuerpo de la solicitud",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Persona.class),
                            examples = { @ExampleObject(value = "" +
                                    "{\r\n" + 
                                    "    \"nombres\": \"Pedro\",\r\n" + 
                                    "    \"apellidos\": \"Acuña\",\r\n" + 
                                    "    \"dni\": \"43377965\",\r\n" + 
                                    "    \"fechaNacimiento\": \"2023-03-27 15:46:20\"\r\n" + 
                                    "}" 
                            ) }
                    )
            )
    )
    @ResponseStatus(HttpStatus.OK)
    @ApiResponse(
            responseCode = "200",
            description = "Solicitud / Operación exitosa.",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = Response.class),
                    examples = { @ExampleObject(value = "" +
                            "{\r\n" + 
                            "    \"status\": \"Ok\",\r\n" + 
                            "    \"statusCode\": 200,\r\n" + 
                            "    \"data\": {\r\n" + 
                            "        \"numeroPedido\": null,\r\n" + 
                            "        \"codigoRespuesta\": \"00\",\r\n" + 
                            "        \"mensajeRespuesta\": \"Transacción Exitosa\"\r\n" + 
                            "    }\r\n" + 
                            "}") }
            )
    )	 
	@PostMapping("/save")
	public ResponseEntity<Response<Persona>>  register(@RequestBody  PersonaDto  persona
			)  {
    	log.info("[START] endpoint POST /save  {}",persona);
    	StatusEnum statusEnum = StatusEnum.getStatus(ConstantStatus.STATUS_200);
		return new ResponseEntity<>(Response.responseOk(personaService.save(persona), statusEnum) , HttpStatus.OK);
	}
	
    
    @Operation(description = "## Funcionalidad\nEsta operación inserta las personas \n",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Cuerpo de la solicitud",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Persona.class),
                            examples = { @ExampleObject(value = "" +
                                    "{\r\n" + 
                                    "    \"nombres\": \"Pedro\",\r\n" + 
                                    "    \"apellidos\": \"Acuña\",\r\n" + 
                                    "    \"dni\": \"43377965\",\r\n" + 
                                    "    \"fechaNacimiento\": \"2023-03-27 15:46:20\"\r\n" + 
                                    "}" 
                            ) }
                    )
            )
    )
    @ResponseStatus(HttpStatus.OK)
    @ApiResponse(
            responseCode = "200",
            description = "Solicitud / Operación exitosa.",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = Response.class),
                    examples = { @ExampleObject(value = "" +
                            "{\r\n" + 
                            "\r\n" + 
                            "    \"sede\":\"constructores\",\r\n" + 
                            "    \"ministerio\":\"re\",\r\n" + 
                            "    \"condicion\":\"miembro\",\r\n" + 
                            "    \"situacion\":\"situacion1\"\r\n" + 
                            "}") }
            )
    )	 
	@PostMapping("/search")
	public ResponseEntity<ResponseList<Persona>>  find(
    		@RequestBody  PersonaListarDto  persona
			)  {
    	
    	log.info("[START] endpoint POST /listar  {}",persona);
    	StatusEnum statusEnum = StatusEnum.getStatus(ConstantStatus.STATUS_200);
		return new ResponseEntity<>(ResponseList.responseOk(personaService.findAll(persona), statusEnum) , HttpStatus.OK);
	}

    @Operation(description = "## Funcionalidad\nEsta operación inserta las personas \n",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Cuerpo de la solicitud",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = Persona.class),
                            examples = { @ExampleObject(value = "" +
                                    "{\r\n" + 
                                    "    \"nombres\": \"Pedro\",\r\n" + 
                                    "    \"apellidos\": \"Acuña\",\r\n" + 
                                    "    \"dni\": \"43377965\",\r\n" + 
                                    "    \"fechaNacimiento\": \"2023-03-27 15:46:20\"\r\n" + 
                                    "}" 
                            ) }
                    )
            )
    )
    @ResponseStatus(HttpStatus.OK)
    @ApiResponse(
            responseCode = "200",
            description = "Solicitud / Operación exitosa.",
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = Response.class),
                    examples = { @ExampleObject(value = "" +
                            "{\r\n" + 
                            "\r\n" + 
                            "    \"sede\":\"constructores\",\r\n" + 
                            "    \"ministerio\":\"re\",\r\n" + 
                            "    \"condicion\":\"miembro\",\r\n" + 
                            "    \"situacion\":\"situacion1\"\r\n" + 
                            "}") }
            )
    )	 
	@GetMapping("/listar")
	public ResponseEntity<ResponseList<Persona>>  listar(
			)  {
    	
    	log.info("[START] endpoint POST /listar  {}");
    	StatusEnum statusEnum = StatusEnum.getStatus(ConstantStatus.STATUS_200);
		return new ResponseEntity<>(ResponseList.responseOk(personaService.listar(), statusEnum) , HttpStatus.OK);
	}
}
