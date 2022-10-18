package com.coderhouse.springbootcoder.service;

import com.coderhouse.springbootcoder.entity.documents.Portafolio;
import com.coderhouse.springbootcoder.entity.documents.Usuario;
import com.coderhouse.springbootcoder.entity.schemas.requests.PortafolioRequest;
import com.coderhouse.springbootcoder.entity.schemas.requests.UsuarioRequest;
import com.coderhouse.springbootcoder.repositories.PortafolioRepository;
import com.coderhouse.springbootcoder.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class PortafolioServiceImp implements PortafolioService{
    private final PortafolioRepository portafolioRepository;

    @Autowired
    MediaStorageService mediaStorageService;

    @Override
    @Transactional(readOnly = true)
    public Stream<Portafolio> findAll() {
        Pageable firstPageWithTwoElements = PageRequest.of(0, 5, Sort.by("nombre").descending());
        return portafolioRepository.findAll(firstPageWithTwoElements).stream();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Portafolio> findById(final Long id) {
        return portafolioRepository.findById(id);
    }

    @Override
    @Transactional
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
