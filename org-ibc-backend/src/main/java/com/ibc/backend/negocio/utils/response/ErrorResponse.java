package com.ibc.backend.negocio.utils.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    @JsonProperty("errorMessage")
    private String errorMessage;

    @JsonProperty("errorCode")
    private String errorCode;

    @JsonProperty("errorDetails")
    private ErrorDetailsResponse errorDetails;

    public ErrorResponse(String errorMessage) {
        this.errorMessage = errorMessage;
    }

}
