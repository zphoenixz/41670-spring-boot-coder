package com.coderhouse.springbootcoder.service;

import com.coderhouse.springbootcoder.entity.documents.Portafolio;
import com.coderhouse.springbootcoder.entity.documents.Usuario;
import com.coderhouse.springbootcoder.entity.schemas.requests.PortafolioRequest;
import com.coderhouse.springbootcoder.entity.schemas.requests.UsuarioRequest;
import com.coderhouse.springbootcoder.repositories.PortafolioRepository;
import com.coderhouse.springbootcoder.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class PortafolioServiceImp implements PortafolioService{
    private final PortafolioRepository portafolioRepository;


    @Override
    public Stream<Portafolio> findAll() {
        return portafolioRepository.findAll().stream();
    }

    @Override
    public Optional<Portafolio> findById(final Long id) {
        return portafolioRepository.findById(id);
    }

    @Override
    public Portafolio save(final PortafolioRequest portafolioRequest) {
        final Portafolio portafolioDoc = new Portafolio();
        portafolioDoc.setCelular(portafolioRequest.getCelular());
        portafolioDoc.setEdad(portafolioRequest.getEdad());
        portafolioDoc.setNombre(portafolioRequest.getNombre());
        portafolioDoc.setDirección(portafolioRequest.getDirección());
        portafolioDoc.setUrlAvatar(portafolioRequest.getUrlAvatar());
        return portafolioRepository.save(portafolioDoc);
    }
}
