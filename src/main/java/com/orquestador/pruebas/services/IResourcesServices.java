package com.orquestador.pruebas.services;

import com.orquestador.pruebas.models.Resources;
import com.orquestador.pruebas.models.User;

public interface IResourcesServices {

    Resources create(User user);
    Resources cancel(String idusuario);
    Resources consutl(String idusuario);
    
}
