package com.orquestador.pruebas.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.orquestador.pruebas.models.Resources;
import com.orquestador.pruebas.models.Suscripcion;
import com.orquestador.pruebas.models.User;

@Service
public class ResourcesService implements IResourcesServices{

    private static Logger logger = LoggerFactory.getLogger(ResourcesService.class);
    private static String resourceUrl = "http://localhost:5000/";
    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private final IUserService iuserService;

    @Autowired
    private final ISuscripcionService isuscripcionService;

    public ResourcesService(IUserService iuserService, ISuscripcionService isuscripcionService) {
        this.iuserService = iuserService;
        this.isuscripcionService = isuscripcionService;
    }

    @Override
    public Resources cancel(String idusuario) {
        logger.info("Consume service cancel");
        logger.info("Change value in User");
        User changeUser = iuserService.changeUserstatus(idusuario);
        logger.info("Cancel suscription");
        Suscripcion data = new Suscripcion(null, changeUser.idproveedor(), null, null, null, null, null);
        Suscripcion cancelsuscription = isuscripcionService.cancelSuscripcion(data);
        Resources response = new Resources(changeUser.idusuario(),changeUser, cancelsuscription);
        return response;
    }

    @Override
    public Resources create(User user) {
        logger.info("Consume service create");
        logger.info("Create new User");
        User createUser =  iuserService.createUser(user.idusuario(), user);
        Suscripcion data = new Suscripcion(null, createUser.idproveedor(), null, null, null, null, null);
        logger.info("Create new Suscription");
        Suscripcion createSuscription = isuscripcionService.createSuscripcion(data);
        Resources response = new Resources(createUser.idusuario(),createUser, createSuscription);
        return response;
    }

    @SuppressWarnings("null")
    @Override
    public Resources consutl(String idusuario) {
        logger.info("Consume service consutl");
        User consultUser;
        Suscripcion consultSuscription;
        try {
            logger.info("Consutl User");
            consultUser = restTemplate.getForObject(resourceUrl + "user/" + idusuario, User.class);
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "User not found", e);
        }
        try {
            logger.info("Consutl Suscripcion");
            consultSuscription = restTemplate.getForObject(resourceUrl + "suscription/" + consultUser.idproveedor(), Suscripcion.class);
        } catch (HttpClientErrorException x) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Suscription not found", x);
        }
        Resources response =  new Resources(idusuario, consultUser, consultSuscription);
        return response;
    }
    
}
