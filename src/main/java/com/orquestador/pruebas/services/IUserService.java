package com.orquestador.pruebas.services;

import com.orquestador.pruebas.models.User;

public interface IUserService {

    User createUser(String idusuario, User user);
    User changeUserstatus(String idusuario);
}
