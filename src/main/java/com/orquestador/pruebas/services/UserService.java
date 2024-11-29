package com.orquestador.pruebas.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.orquestador.pruebas.models.EstatusUsuario;
import com.orquestador.pruebas.models.User;

@Service
@PropertySource("classpath:other.properties")
public class UserService implements IUserService{

    @Value("${url.microuser}")
    private String resourceUrl;

    private Logger logger = LoggerFactory.getLogger(UserService.class);
    private RestTemplate restTemplate = new RestTemplate();

    public UserService() {
    }

    @SuppressWarnings("null")
    @Override
    public User createUser(String idusuario, User user) {
        logger.info("Consume service createUser");
        try{
            logger.info("Consult to exist user");
            User consult = restTemplate.getForObject(resourceUrl + "/user/" + idusuario, User.class);
            logger.info("Exist user");
            logger.info(consult.toString());
            String idproveedor = consult.idproveedor();
            if(consult.estatusUsuario().id() == 2){
                logger.info("Change user: "+ idproveedor + " a estatusUsuario to 1");
                HttpEntity<User> request = new HttpEntity<>(new User(null, null, null, new EstatusUsuario(1, "valido"), null));
                ResponseEntity<User> response = restTemplate.exchange(resourceUrl + "/user/" + idproveedor, HttpMethod.PUT, request, User.class);
                logger.info("StatusCode to operation update: " + String.valueOf(response.getStatusCode()));
                User result = response.getBody();
                return result;
            }
            logger.info("User: "+ idproveedor + " a estatusUsuario is " + consult.estatusUsuario().descripcion());
            return consult;
        } catch (HttpClientErrorException e) {
            logger.info("Create new user");
            HttpEntity<User> request = new HttpEntity<>(new User(null, user.idusuario(), null, new EstatusUsuario(1, "valido"), null));
            User result = restTemplate.postForObject(resourceUrl + "/user/", request, User.class);
            logger.info(result.toString());
            return result;
        }
    }

    @SuppressWarnings("null")
    @Override
    public User changeUserstatus(String idusuario) {
        logger.info("Consume service changeUserstatus");
        try{
            logger.info("Consult User");
            User consult = restTemplate.getForObject(resourceUrl + "/user/" + idusuario, User.class);
            logger.info("Exist user");
            if (consult.estatusUsuario().id() == 1) {
                String idproveedor = consult.idproveedor();
                logger.info("Change user: "+ idproveedor + " a estatusUsuario to 2");
                HttpEntity<User> request = new HttpEntity<>(new User(null, null, null, new EstatusUsuario(2, "invalido"), null));
                ResponseEntity<User> response = restTemplate.exchange(resourceUrl + "/user/" + idproveedor, HttpMethod.PUT, request, User.class);
                logger.info(String.valueOf(response.getStatusCode()));
                User result = response.getBody();
                return result;
            }
            return consult;
        } catch (HttpClientErrorException e) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "User not found", e);
        }
    }

}
