package com.orquestador.pruebas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orquestador.pruebas.models.Resources;
import com.orquestador.pruebas.models.User;
import com.orquestador.pruebas.services.IResourcesServices;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/resources")
@PreAuthorize("denyAll()")
public class ResourcesController {

    private final IResourcesServices iresourcesServices;

    public ResourcesController(IResourcesServices iresourcesServices) {
        this.iresourcesServices = iresourcesServices;
    }

    @PostMapping("/")
    @PreAuthorize("hasAuthority('CREATE')")
    public Resources create(@RequestBody User user) {
        return iresourcesServices.create(user);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('CREATE')")
    public Resources cancel(@PathVariable String id) {
        return iresourcesServices.cancel(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('READ')")
    public Resources consult(@PathVariable String id) {
        return iresourcesServices.consutl(id);
    }
    
    

}
