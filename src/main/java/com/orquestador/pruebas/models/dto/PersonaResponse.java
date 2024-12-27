package com.orquestador.pruebas.models.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.orquestador.pruebas.models.Name;

public class PersonaResponse extends Name {

    @JsonProperty("id")
    private Integer nombreId;
    @JsonProperty("apellidos")
    private List<LastNameResponse> apellidos;

    public PersonaResponse() {
    }

    public PersonaResponse(String usuarioId, String nombre, String segundoNombre, Integer nombreId,
            List<LastNameResponse> apellidos) {
        super(usuarioId, nombre, segundoNombre);
        this.nombreId = nombreId;
        this.apellidos = apellidos;
    }

    public Integer getNombreId() {
        return nombreId;
    }

    public void setNombreId(Integer nombreId) {
        this.nombreId = nombreId;
    }

    public List<LastNameResponse> getApellidos() {
        return apellidos;
    }

    public void setApellidos(List<LastNameResponse> apellidos) {
        this.apellidos = apellidos;
    }

}
