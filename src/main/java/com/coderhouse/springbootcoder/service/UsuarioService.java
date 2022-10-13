package com.coderhouse.springbootcoder.service;

import com.coderhouse.springbootcoder.entity.documents.Usuario;
import com.coderhouse.springbootcoder.entity.schemas.requests.UsuarioRequest;

import java.util.Optional;
import java.util.Set;

public interface UsuarioService {
    Set<Usuario> getAllUsuarios();
    Optional<Usuario> getUsuarioById(final Long id);
    Usuario postNewUsuario(final UsuarioRequest usuarioRequest);
}
