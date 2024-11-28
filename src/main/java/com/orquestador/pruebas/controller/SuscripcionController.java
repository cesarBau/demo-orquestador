package com.orquestador.pruebas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.orquestador.pruebas.models.Suscripcion;
import com.orquestador.pruebas.services.ISuscripcionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/suscription")
public class SuscripcionController {

    @Autowired
    private final ISuscripcionService isuscripcionService;

    public SuscripcionController(ISuscripcionService isuscripcionService) {
        this.isuscripcionService = isuscripcionService;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Suscripcion activeSuscription(@RequestBody Suscripcion suscripcion) {
        return isuscripcionService.createSuscripcion(suscripcion);
    }

    @DeleteMapping("/")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Suscripcion cancelSuscription(@RequestBody Suscripcion suscripcion) {
        return isuscripcionService.cancelSuscripcion(suscripcion);
    }

}
