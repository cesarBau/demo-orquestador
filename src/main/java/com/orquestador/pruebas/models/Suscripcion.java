package com.orquestador.pruebas.models;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Suscripcion(Integer id, String idproveedor, LocalDateTime fechaCreacion, LocalDateTime fechaActivacion,
        LocalDateTime fechaCancelacion, EstatusSuscripcion estatusSuscripcion, LocalDateTime update) {

}
