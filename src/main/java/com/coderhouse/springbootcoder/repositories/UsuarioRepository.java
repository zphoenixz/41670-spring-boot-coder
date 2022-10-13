package com.coderhouse.springbootcoder.repositories;

import com.coderhouse.springbootcoder.entity.documents.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query(value = "FROM Usuario")
    Set<Usuario> fetchAllUsersByJoin();
}
