package com.ibc.backend.negocio.utils.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class Respuesta {

    @JsonProperty("Codigo")
    @NotNull
    Integer codigo;

    @JsonProperty("Mensaje")
    @NotNull
    String mensaje;
    
    @JsonProperty("DocId")
    @NotNull
    String docId;
}
