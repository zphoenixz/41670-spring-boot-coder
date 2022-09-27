package com.coderhouse.springbootcoder.service;

import com.coderhouse.springbootcoder.entity.documents.Usuario;
import com.coderhouse.springbootcoder.entity.schemas.requests.UsuarioRequest;

import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> getUsuarioById(final Long id);
    Usuario postNewUsuario(final UsuarioRequest usuarioRequest);
}
