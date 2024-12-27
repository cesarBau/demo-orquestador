package com.orquestador.pruebas.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.orquestador.pruebas.models.LastName;
import com.orquestador.pruebas.models.dto.LastNameResponse;

@Service
public class LastNameService implements ILastNameService {

    @Value("${url.microuser}")
    private String resourceUrl;

    private Logger logger = LoggerFactory.getLogger(LastNameService.class);
    private RestTemplate restTemplate = new RestTemplate();

    @SuppressWarnings("null")
    @Override
    public LastNameResponse createLastName(LastName entity) {
        logger.info("Consume service createLastName");
        try {
            LastNameResponse consult = restTemplate.postForObject(resourceUrl + "/lastname/", entity,
                    LastNameResponse.class);
            logger.info(consult.toString());
            return consult;
        } catch (HttpClientErrorException z) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Not create LastName for error in conection", z);
        }
    }

}
