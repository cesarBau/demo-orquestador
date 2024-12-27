package com.orquestador.pruebas.services;

import com.orquestador.pruebas.models.Persona;
import com.orquestador.pruebas.models.dto.PersonaResponse;

public interface IPersonaService {

    PersonaResponse createPersona(Persona entity);

}
