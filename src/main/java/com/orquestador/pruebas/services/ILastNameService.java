package com.orquestador.pruebas.services;

import com.orquestador.pruebas.models.LastName;
import com.orquestador.pruebas.models.dto.LastNameResponse;

public interface ILastNameService {

    LastNameResponse createLastName(LastName entity);

}
