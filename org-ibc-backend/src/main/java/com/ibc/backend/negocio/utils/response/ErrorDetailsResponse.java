package com.ibc.backend.negocio.utils.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDetailsResponse {

    @JsonProperty("policy")
    private String policy;

    @JsonProperty("scope")
    private String scope;

    @JsonProperty("remoteIp")
    private String remoteIp;

}
