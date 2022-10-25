package com.coderhouse.springbootcoder.service;

import com.coderhouse.springbootcoder.entity.documents.Portafolio;
import com.coderhouse.springbootcoder.entity.schemas.requests.PortafolioRequest;

import java.util.Optional;
import java.util.stream.Stream;

public interface PortafolioService {
    Stream<Portafolio> findAll(Integer page);
    Optional<Portafolio> findById(final Long id);
    Portafolio save(final PortafolioRequest portafolioRequest);
}
