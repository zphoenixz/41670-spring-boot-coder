package com.coderhouse.springbootcoder.controllers;

import com.coderhouse.springbootcoder.entity.documents.Portafolio;
import com.coderhouse.springbootcoder.entity.schemas.requests.PortafolioRequest;
import com.coderhouse.springbootcoder.entity.schemas.responses.Response;
import com.coderhouse.springbootcoder.handler.exceptions.ApiRestException;
import com.coderhouse.springbootcoder.service.PortafolioService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/portafolio")
@RequiredArgsConstructor
public class PortafolioController {
    Logger logger = LogManager.getLogger(PortafolioController.class);

    @Autowired
    private final PortafolioService portafolioService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Response> read(@PathVariable(name = "id") final Long id) throws ApiRestException {
        logger.info("GET /api/portafolio/{id}");
        final Optional<Portafolio> portafolio = portafolioService.findById(id);

        if (portafolio.isPresent()) {
            final Response<Portafolio> result = new Response(Instant.now(), portafolio, 200, "Success");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }else{
//            throw new IndexOutOfBoundsException("Código de Portafolio inexistente");
            throw new ApiRestException("Código de Portafolio inexistente");
        }
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> readAll() {
        logger.info("GET /api/portafolio");
        final List<Portafolio> portafolios =
                portafolioService.findAll()
                        .collect(Collectors.toList());
        final Response<Portafolio> result = new Response(Instant.now(), portafolios, 200, "Success");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Response> savePortafolio(@Validated @RequestBody final PortafolioRequest portafolioRequest) {
        logger.info("POST /api/portafolio");
        try {
//            if(portafolioRequest.getDirección().isEmpty()){
//                throw new Exception("No contiene la direccion del portafolio");
//            }
            final Portafolio portafolio = portafolioService.save(portafolioRequest);
            final Response<Portafolio> result = new Response(Instant.now(), portafolio, 201, "Created");
            return new ResponseEntity<Response>(result, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Error enviando respuesta del controlador", e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
