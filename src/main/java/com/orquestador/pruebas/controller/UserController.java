package com.orquestador.pruebas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.orquestador.pruebas.models.User;
import com.orquestador.pruebas.services.IUserService;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private final IUserService iuserService;

    public UserController(IUserService iuserService) {
        this.iuserService = iuserService;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public User postMethodName(@RequestBody User usuario) {
        logger.info(usuario.toString());
        return iuserService.createUser(usuario.idusuario(), usuario);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public User inactivateUser(@PathVariable String id){
        logger.info(id);
        return iuserService.changeUserstatus(id);
    }

}
