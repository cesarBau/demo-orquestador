package com.orquestador.pruebas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orquestador.pruebas.models.Persona;
import com.orquestador.pruebas.models.dto.PersonaResponse;
import com.orquestador.pruebas.services.IPersonaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/person")
public class PersonaController {

    private static Logger logger = LoggerFactory.getLogger(PersonaController.class);

    private final IPersonaService iPersonaService;

    public PersonaController(IPersonaService iPersonaService) {
        this.iPersonaService = iPersonaService;
    }

    @PostMapping("/")
    public PersonaResponse createPersona(@RequestBody Persona entity) {
        logger.info("Consume controller createPersona");
        logger.info(entity.toString());
        PersonaResponse response = iPersonaService.createPersona(entity);
        return response;
    }

}
