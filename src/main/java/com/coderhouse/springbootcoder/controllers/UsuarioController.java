package com.coderhouse.springbootcoder.controllers;

import com.coderhouse.springbootcoder.entity.documents.Usuario;
import com.coderhouse.springbootcoder.entity.schemas.requests.UsuarioRequest;
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
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UsuarioController {
    @Autowired
    private final UsuarioService usuarioService;

    @GetMapping(value = "usuario", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getAllUsuarios() {
        final Set<Usuario> usuario = usuarioService.getAllUsuarios();
        return ResponseEntity.ok(usuario);
    }

    @GetMapping(value = "usuario/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getUsuarioById(@PathVariable(name = "id") final Long id) {
        final Optional<Usuario> usuario = usuarioService.getUsuarioById(id);
        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "usuario", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> guardarCliente(@RequestBody final UsuarioRequest usuarioRequest) {
        try {
            final Usuario usuarioGuardado = usuarioService.postNewUsuario(usuarioRequest);
            return ResponseEntity.created(URI.create("")).body(usuarioGuardado);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(null);
        }
    }
}
