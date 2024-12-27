package com.orquestador.pruebas.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.orquestador.pruebas.models.LastName;

public class LastNameResponse extends LastName {

    
    private Integer id;
    @JsonIgnore
    private String message;

    public LastNameResponse() {
    }

    public LastNameResponse(Integer nombreId, String apellidoPaterno, String apellidoMaterno, Integer id,
            String message) {
        super(nombreId, apellidoPaterno, apellidoMaterno);
        this.id = id;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    @JsonProperty("apellido_id")
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "LastNameResponse [id=" + id + ", message=" + message + "]";
    }

}
