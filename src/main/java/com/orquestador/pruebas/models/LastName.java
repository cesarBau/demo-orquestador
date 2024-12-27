package com.orquestador.pruebas.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LastName {

    @JsonProperty("nombre_id")
    private Integer nombreId;
    @JsonProperty("apellido_paterno")
    private String apellidoPaterno;
    @JsonProperty("apellido_materno")
    private String apellidoMaterno;

    public LastName() {
    }

    public LastName(Integer nombreId, String apellidoPaterno, String apellidoMaterno) {
        this.nombreId = nombreId;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
    }

    public Integer getNombreId() {
        return nombreId;
    }

    public void setNombreId(Integer nombreId) {
        this.nombreId = nombreId;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

}
