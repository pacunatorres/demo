package com.ibc.backend.negocio.utils.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ibc.backend.negocio.utils.constantes.StatusEnum;

import lombok.Data;

import java.util.List;

@Data
public class ResponseList<T>  extends BaseResponse {

    @JsonProperty("data")
    private List<T> data;

    public static <T> ResponseList<T> responseOk(List<T> data, StatusEnum statusEnum) {
        ResponseList<T> response = new ResponseList<>();
        response.setStatus(statusEnum.getStatus());
        response.setStatusCode(statusEnum.getStatusCode());
        response.setData(data);
        return response;
    }
}
