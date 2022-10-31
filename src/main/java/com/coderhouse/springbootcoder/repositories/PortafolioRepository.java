package com.coderhouse.springbootcoder.repositories;

import com.coderhouse.springbootcoder.entity.documents.Portafolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortafolioRepository extends JpaRepository<Portafolio, Long> {
//    List<Portafolio> findAllByPrice(double price, Pageable pageable);
}
