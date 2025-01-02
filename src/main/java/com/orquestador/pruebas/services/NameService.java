package com.orquestador.pruebas.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.orquestador.pruebas.models.Name;
import com.orquestador.pruebas.models.dto.NameResponse;

@Service
@PropertySource("classpath:other.properties")
public class NameService implements INameService {

    @Value("${url.microuser}")
    private String resourceUrl;

    private Logger logger = LoggerFactory.getLogger(NameService.class);
    private RestTemplate restTemplate = new RestTemplate();

    @SuppressWarnings("null")
    @Override
    public NameResponse createName(Name entity) {
        logger.info("Consume service createName");
        logger.info("Create to name");
        try {
            NameResponse consult = restTemplate.postForObject(resourceUrl + "/name/", entity, NameResponse.class);
            logger.info(consult.toString());
            return consult;
        } catch (HttpClientErrorException z) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Not create Name for error in conection", z);
        }
    }

    @SuppressWarnings("null")
    @Override
    public NameResponse getNameById(Integer id) {
        logger.info("Consume service getNameById");
        try {
            NameResponse consult = restTemplate.getForObject(resourceUrl + "/name/" + id, NameResponse.class);
            logger.info(consult.toString());
            return consult;
        } catch (HttpClientErrorException z) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Not get Name for error in conection", z);
        }
    }

}
