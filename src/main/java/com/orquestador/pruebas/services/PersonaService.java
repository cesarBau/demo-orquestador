package com.orquestador.pruebas.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.orquestador.pruebas.models.LastName;
import com.orquestador.pruebas.models.Name;
import com.orquestador.pruebas.models.Persona;
import com.orquestador.pruebas.models.dto.LastNameResponse;
import com.orquestador.pruebas.models.dto.NameResponse;
import com.orquestador.pruebas.models.dto.PersonaResponse;

@Service
public class PersonaService implements IPersonaService {

    private Logger logger = LoggerFactory.getLogger(PersonaService.class);

    private final INameService iNameService;
    private final ILastNameService iLastNameService;

    public PersonaService(INameService iNameService, ILastNameService iLastNameService) {
        this.iNameService = iNameService;
        this.iLastNameService = iLastNameService;
    }

    @Override
    public PersonaResponse createPersona(Persona entity) {
        logger.info("Consume service createPersona");
        logger.info("Create to name for persona");
        Name entityName = new Name(entity.getUsuarioId(), entity.getNombre(), entity.getSegundoNombre());
        NameResponse name = iNameService.createName(entityName);
        logger.info("Create to lastname for persona");
        LastName entityLastName = new LastName(name.getId(), entity.getApellidoPaterno(), entity.getApellidoMaterno());
        LastNameResponse lastName = iLastNameService.createLastName(entityLastName);
        logger.info("Create to persona");
        List<LastNameResponse> lastsNames = new ArrayList<>();
        lastsNames.add(lastName);
        PersonaResponse response = new PersonaResponse(entity.getUsuarioId(), name.getNombre(),
                name.getSegundoNombre(), name.getId(),
                lastsNames);
        logger.info(response.toString());
        return response;
    }

}
