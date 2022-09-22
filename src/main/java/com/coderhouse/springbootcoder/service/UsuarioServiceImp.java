package com.coderhouse.springbootcoder.service;

import com.coderhouse.springbootcoder.models.documents.Usuario;
import com.coderhouse.springbootcoder.models.schemas.requests.UsuarioRequest;
import com.coderhouse.springbootcoder.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImp implements UsuarioService{
    private final UsuarioRepository usuarioRepository;

    public Optional<Usuario> getUsuarioById(final Long id){
        return usuarioRepository.findById(id);
    }
    public Usuario postNewUsuario(final UsuarioRequest usuarioRequest){
        final Usuario usuarioDoc = new Usuario();
        usuarioDoc.setCelular(usuarioRequest.getCelular());
        usuarioDoc.setEdad(usuarioRequest.getEdad());
        usuarioDoc.setNombre(usuarioRequest.getNombre());
        return usuarioRepository.save(usuarioDoc);
    }
}
