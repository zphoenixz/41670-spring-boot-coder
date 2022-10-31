package com.coderhouse.springbootcoder.service;

import com.coderhouse.springbootcoder.entity.documents.Usuario;
import com.coderhouse.springbootcoder.entity.schemas.requests.UsuarioRequest;
import com.coderhouse.springbootcoder.repositories.UserOldRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImp implements UsuarioService{
    private final UserOldRepository userOldRepository;

    @Transactional
    public Set<Usuario> getAllUsuarios(){
        Set<Usuario> usuarios = userOldRepository.fetchAllUsersByJoin();
        return usuarios;
    }
    @Transactional
    public Optional<Usuario> getUsuarioById(final Long id){
        Optional<Usuario> usuario = userOldRepository.findById(id);
        return usuario;
    }
    public Usuario postNewUsuario(final UsuarioRequest usuarioRequest){
        final Usuario usuarioDoc = new Usuario();
        usuarioDoc.setCelular(usuarioRequest.getCelular());
        usuarioDoc.setEdad(usuarioRequest.getEdad());
        usuarioDoc.setNombre(usuarioRequest.getNombre());
        return userOldRepository.save(usuarioDoc);
    }
}
