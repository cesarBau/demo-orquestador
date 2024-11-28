package com.orquestador.pruebas.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record EstatusSuscripcion(Integer id,String descripcion) {

}
