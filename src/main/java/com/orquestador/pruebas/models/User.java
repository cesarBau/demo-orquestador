package com.orquestador.pruebas.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record User(String idproveedor,  String idusuario, LocalDateTime fechaCreacion, Integer estatusUsuario, LocalDateTime update) {

}
