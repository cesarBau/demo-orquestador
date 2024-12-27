package com.orquestador.pruebas.services;

import com.orquestador.pruebas.models.Name;
import com.orquestador.pruebas.models.dto.NameResponse;

public interface INameService {

    NameResponse createName(Name entity);

}
