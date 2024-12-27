package com.orquestador.pruebas.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = false)
public class Persona {

    @JsonProperty("usuario_id")
    private String usuarioId;
    String nombre;
    @JsonProperty("segundo_nombre")
    private String segundoNombre;
    @JsonProperty("apellido_paterno")
    String apellidoPaterno;
    @JsonProperty("apellido_materno")
    String apellidoMaterno;

    public Persona() {
    }

    public Persona(String usuarioId, String nombre, String segundoNombre, String apellidoPaterno,
            String apellidoMaterno) {
        this.usuarioId = usuarioId;
        this.nombre = nombre;
        this.segundoNombre = segundoNombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
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

    @Override
    public String toString() {
        return "Persona [usuarioId=" + usuarioId + ", nombre=" + nombre + ", segundoNombre=" + segundoNombre
                + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + "]";
    }

}
