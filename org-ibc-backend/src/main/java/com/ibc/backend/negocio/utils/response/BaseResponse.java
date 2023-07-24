package com.ibc.backend.negocio.utils.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BaseResponse {

    @JsonProperty("status")
    private String status;

    @JsonProperty("statusCode")
    private Integer statusCode;

}
