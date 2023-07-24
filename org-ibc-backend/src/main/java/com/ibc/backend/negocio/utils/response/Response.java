package com.ibc.backend.negocio.utils.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibc.backend.negocio.utils.constantes.StatusEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> extends BaseResponse {

	 @JsonProperty("data")
	    private T data;

	    @JsonProperty("error")
	    @Schema(name = "error", description = "Error validado")
	    private ErrorResponse error;

	    public static <T> Response<T> responseOk(T data, StatusEnum statusEnum) {
	        Response<T> response = new Response<>();
	        response.setStatus(statusEnum.getStatus());
	        response.setStatusCode(statusEnum.getStatusCode());
	        response.setData(data);
	        return response;
	    }

	    public static <T> Response<T> responseHandle(StatusEnum statusEnum) {
	        Response<T> response = new Response<>();
	        response.setStatus(statusEnum.getStatus());
	        response.setStatusCode(statusEnum.getStatusCode());
	        response.setError(new ErrorResponse(statusEnum.getErrorMessage()));
	        return response;
	    }


}
