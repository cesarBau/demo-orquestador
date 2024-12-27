package com.orquestador.pruebas.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Name {

    @JsonProperty("usuario_id")
    private String usuarioId;
    String nombre;
    @JsonProperty("segundo_nombre")
    private String segundoNombre;

    public Name() {
    }

    public Name(String usuarioId, String nombre, String segundoNombre) {
        this.usuarioId = usuarioId;
        this.nombre = nombre;
        this.segundoNombre = segundoNombre;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

}
