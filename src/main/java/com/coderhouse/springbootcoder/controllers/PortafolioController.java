package com.coderhouse.springbootcoder.controllers;

import com.coderhouse.springbootcoder.entity.documents.Portafolio;
import com.coderhouse.springbootcoder.entity.documents.Usuario;
import com.coderhouse.springbootcoder.entity.schemas.requests.PortafolioRequest;
import com.coderhouse.springbootcoder.entity.schemas.requests.UsuarioRequest;
import com.coderhouse.springbootcoder.service.PortafolioService;
import com.coderhouse.springbootcoder.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/portafolio")
@RequiredArgsConstructor
public class PortafolioController {
    @Autowired
    private final PortafolioService portafolioService;

    @GetMapping(value = "{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> read(@PathVariable(name = "id") final Long id) {
        final Optional<Portafolio> portafolio = portafolioService.findById(id);
        if (portafolio.isPresent()) {
            return ResponseEntity.ok(portafolio);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> readAll() {
        final List<Portafolio> portafolios =
                portafolioService.findAll()
                        .collect(Collectors.toList());
        return ResponseEntity.ok(portafolios);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> savePortafolio(@RequestBody final PortafolioRequest portafolioRequest) {
        try {
            final Portafolio portafolio = portafolioService.save(portafolioRequest);
            return ResponseEntity.created(URI.create("")).body(portafolio);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(null);
        }
    }
}
