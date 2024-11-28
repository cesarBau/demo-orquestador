package com.orquestador.pruebas.services;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.orquestador.pruebas.models.EstatusSuscripcion;
import com.orquestador.pruebas.models.Suscripcion;
import com.orquestador.pruebas.models.User;

@Service
public class SuscripcionService implements ISuscripcionService {

    private static Logger logger = LoggerFactory.getLogger(SuscripcionService.class);
    private static String resourceUrl = "http://localhost:5000/";
    private RestTemplate restTemplate = new RestTemplate();

    public SuscripcionService(){}

    @SuppressWarnings("null")
    @Override
    public Suscripcion createSuscripcion(Suscripcion suscripcion) {
        logger.info("Consume service createSuscripcion");
        try {
            logger.info("Consult to exist suscripcion");
            Suscripcion consult = restTemplate.getForObject(resourceUrl + "suscription/" + suscripcion.idproveedor(), Suscripcion.class);
            logger.info(consult.toString());
            if (consult.estatusSuscripcion().id() == 1) {
                logger.info("Exist suscripcion and your status is active");
                return consult;
            } else {
                logger.info("Exist suscripcion and your status is not active");
                HttpEntity<Suscripcion> request =  new HttpEntity<>(new Suscripcion(null, null, null, null, null, new EstatusSuscripcion(null, null), null));
                ResponseEntity<Suscripcion> result = restTemplate.exchange(resourceUrl + "suscription/" + consult.idproveedor(), HttpMethod.PUT, request, Suscripcion.class);
                logger.info("Update suscripcion, is now active");
                return result.getBody();
            }
        } catch (HttpClientErrorException e) {
            logger.info("Create on suscripcion");
            try {
                logger.info("Consult to exist user for idproveedor");
                restTemplate.getForObject(resourceUrl + "user/idproveedor/" + suscripcion.idproveedor(), User.class);
            } catch (HttpClientErrorException z) {
                throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Not exist user whith asociate idproveedor", z);
            }
            LocalDateTime now = LocalDateTime.now();
            Suscripcion data = new Suscripcion(null, suscripcion.idproveedor(), now, now, null, new EstatusSuscripcion(1, "activo"), now);
            Suscripcion result = restTemplate.postForObject(resourceUrl + "suscription/", data, Suscripcion.class);
            return result;
        }
    }

    @Override
    public Suscripcion cancelSuscripcion(Suscripcion suscripcion) {
        logger.info("Consume service cancelSuscripcion");
        Suscripcion consult;
        try {
            logger.info("Consult to exist suscription");
            consult = restTemplate.getForObject(resourceUrl + "suscription/" + suscripcion.idproveedor(), Suscripcion.class);
        } catch (HttpClientErrorException z) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Not exist suscription whith asociate idproveedor", z);
        }
        try {
            logger.info("Cancel suscription");
            restTemplate.delete(resourceUrl + "suscription/" + suscripcion.idproveedor());
            logger.info("Cancel suscription complete");
        } catch (HttpClientErrorException z) {
            throw new ResponseStatusException(
                HttpStatus.BAD_REQUEST, "The subscription could not be canceled", z);
        }
        consult = restTemplate.getForObject(resourceUrl + "suscription/" + suscripcion.idproveedor(), Suscripcion.class);
        return consult;
    }

    
}
