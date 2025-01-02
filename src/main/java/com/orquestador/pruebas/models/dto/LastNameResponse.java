package com.orquestador.pruebas.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.orquestador.pruebas.models.LastName;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LastNameResponse extends LastName {

    private Integer id;

    public LastNameResponse() {
    }

    public LastNameResponse(Integer nombreId, String apellidoPaterno, String apellidoMaterno, Integer id) {
        super(nombreId, apellidoPaterno, apellidoMaterno);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "LastNameResponse [id=" + id + "]";
    }

}
