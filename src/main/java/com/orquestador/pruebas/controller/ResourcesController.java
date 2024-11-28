package com.orquestador.pruebas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orquestador.pruebas.models.Resources;
import com.orquestador.pruebas.models.User;
import com.orquestador.pruebas.services.IResourcesServices;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/resources")
public class ResourcesController {

    private final IResourcesServices iresourcesServices;

    public ResourcesController(IResourcesServices iresourcesServices) {
        this.iresourcesServices = iresourcesServices;
    }

    @PostMapping("/")
    public Resources create(@RequestBody User user) {
        return iresourcesServices.create(user);
    }

    @DeleteMapping("/{id}")
    public Resources cancel(@PathVariable String id) {
        return iresourcesServices.cancel(id);
    }

    @GetMapping("/{id}")
    public Resources consult(@PathVariable String id) {
        return iresourcesServices.consutl(id);
    }
    
    

}
